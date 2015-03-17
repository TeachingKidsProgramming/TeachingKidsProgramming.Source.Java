package org.teachingextensions.approvals.lite.util.velocity;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.NullLogSystem;
import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;
import org.teachingextensions.approvals.lite.util.parser.ParserCommons;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Properties;

public class VelocityParser {
    private static VelocityEngine currentEngine = null;

    static {
        for (Enumeration e = LogManager.getCurrentLoggers(); e.hasMoreElements(); ) {
            ((Logger) e.nextElement()).setLevel(Level.OFF);
        }
    }

    public static String parseString(String template, ContextAware process) {
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", StringResourceLoader.class.getName());
        props.put("velocimacro.context.localscope", "" + true);
        props.put("runtime.introspector.uberspect", TestableUberspect.class.getName());
        props.put("velocimacro.permissions.allow.inline.local.scope", "" + true);
        return parse(template, props, new ContextAware[]{process, Default.INSTANCE});
    }

    public static String parse(String template, Properties props, ContextAware[] process) {
        StringWriter out = new StringWriter();
        parse(template, props, process, out);
        return out.toString();
    }

    public static Writer parse(String template, Properties props, ContextAware process[], Writer out) {
        try {
            props.put("directive.foreach.counter.initial.value", "0");
            props.put(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, NullLogSystem.class.getName());
            VelocityEngine engine = initializeEngine(props);
            VelocityContext context = new VelocityContext();
            Template velocityTemplate = engine.getTemplate(template);
            for (ContextAware p : process) {
                if (p != null) p.setupContext(context);
            }
            velocityTemplate.merge(context, out);
            return out;
        } catch (Exception e) {
            throw ObjectUtils.throwAsError(e);
        }
    }

    public static synchronized VelocityEngine initializeEngine(Properties props) throws Exception {
        if (currentEngine == null || isDifferentForProperties(props, currentEngine, new String[]{"resource.loader", "file.resource.loader.path"})) {
            currentEngine = new VelocityEngine();
            currentEngine.init(props);
        }
        return currentEngine;
    }

    private static boolean isDifferentForProperties(Properties props, VelocityEngine engine, String[] keys) {
        for (String key : keys) {
            if (!ObjectUtils.isEqual(props.get(key), engine.getProperty(key))) {
                return true;
            }
        }
        return false;
    }

    public static class Default implements ContextAware {
        public static ContextAware INSTANCE = new Default();

        public void setupContext(Context context) {
            context.put("commons", ParserCommons.INSTANCE);
        }
    }

    public static String parseFromClassPath(Class clazz, String string, ContextAware context) {
        String resource = FileUtils.readFromClassPath(clazz, string);
        return parseString(resource, context);
    }

}
