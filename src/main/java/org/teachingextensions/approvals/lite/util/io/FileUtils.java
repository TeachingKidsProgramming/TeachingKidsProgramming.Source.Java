package org.teachingextensions.approvals.lite.util.io;

import org.teachingextensions.approvals.lite.util.ArrayUtils;
import org.teachingextensions.approvals.lite.util.Asserts;
import org.teachingextensions.approvals.lite.util.ObjectUtils;

import java.io.*;
import java.util.ArrayList;

/**
 * A static class of convenience functions for Files
 */
public class FileUtils {
    public static String readFromClassPath(Class clazz, String string) {
        final InputStream resourceAsStream = clazz.getClassLoader().getResourceAsStream(string);
        if (resourceAsStream == null) {
            String message = String.format("Could not find %s from %s", string, clazz.getName());
            throw new RuntimeException(message);
        }
        return FileUtils.readStream(resourceAsStream);
    }

    /**
     * *******************************************************************
     */
    public static File[] getRecursiveFileList(File directory) {
        return getRecursiveFileList(directory, new SimpleFileFilter());
    }

    /**
     * *******************************************************************
     */
    public static File[] getRecursiveFileList(File directory, FileFilter filter) {
        ArrayList<File> list = new ArrayList<>();
        if (!directory.isDirectory()) {
            throw new Error("File is not a directory: " + directory.getName());
        }
        File directories[] = directory.listFiles(new SimpleDirectoryFilter());
        for (File directory1 : directories) {
            ArrayUtils.addArray(list, getRecursiveFileList(directory1, filter));
        }
        File files[] = directory.listFiles(filter);
        ArrayUtils.addArray(list, files);
        return list.toArray(new File[list.size()]);
    }

    /**
     * *******************************************************************
     */
    public static void writeFile(File file, String text) throws IOException {
        Asserts.assertNotNull("Writing to file: " + file, text);
        file.getCanonicalFile().getParentFile().mkdirs();
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        out.write(text);
        out.close();
    }

    /**
     * *******************************************************************
     */
    public static void writeFileQuietly(File file, String text) {
        try {
            writeFile(file, text);
        } catch (IOException e) {
            ObjectUtils.throwAsError(e);
        }
    }

    /**
     * *******************************************************************
     */
    public static String readFile(String absolutePath) throws IOException {
        return readFile(new File(absolutePath));
    }

    /**
     * *******************************************************************
     */
    public static String readFile(File file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        return readBuffer(in);
    }

    public static String readBuffer(BufferedReader in) throws IOException {
        StringBuilder string = new StringBuilder();
        while (in.ready()) {
            string.append(in.readLine());
            string.append("\n");
        }
        in.close();
        return string.toString();
    }

    /**
     * ********************************************************************
     */
    public static String readFileWithSuppressedExceptions(File databaseFile) {
        try {
            return FileUtils.readFile(databaseFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Invalid file '" + databaseFile.getAbsolutePath() + "'", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /************************************************************************/
    /**
     * ********************************************************************
     */
    public static String getExtensionWithDot(String filename) {
        int p = filename.lastIndexOf('.');
        return filename.substring(p);
    }

    public static void createIfNeeded(String file) throws IOException {
        File f = new File(file);
        if (!f.exists()) {
            writeFile(f, "");
        }
    }

    public static String readStream(InputStream resourceAsStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        String resource = null;
        try {
            resource = FileUtils.readBuffer(reader);
        } catch (IOException e) {
            ObjectUtils.throwAsError(e);
        }
        return resource;
    }

    public static boolean isNonEmptyFile(String approved) {
        File file = new File(approved);
        return file.exists() && file.length() > 0;
    }
}