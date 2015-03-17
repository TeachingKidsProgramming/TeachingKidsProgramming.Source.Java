package org.teachingextensions.simpleparser;

import java.lang.reflect.Field;
import java.util.List;

import org.teachingkidsprogramming.util.lambda.Function1;
import org.teachingkidsprogramming.util.lambda.Query;

import org.teachingkidsprogramming.util.ObjectUtils;
import org.teachingkidsprogramming.util.io.FileUtils;

public class Parser
{
  /**
   * Parses a template with a data object to create a string
   * 
   * <div><b>Example:</b>   Words data = new Words ();<br>
   * data.action = "Shake";<br>
   * data.weapon = "spear";<br>
   * String greeting = Parser.parse("Captain {action}{weapon}!!!",data)<br></div>
   * 
   * Captain Shakespear!!! 
   * 
   * @param text
   *          The template with the fields from the data object surrounded in {curlyBraces}
   * @param data
   *          an object whose fields will be merged with the template during parsing
   */
  public static String parse(String text, Object data)
  {
    return parse(text, "{", "}", data);
  }
  public static String parse(String text, String startCharacter, String endCharacter, Object data)
  {
    StringBuffer sb = new StringBuffer();
    String temp = text;
    int start = temp.indexOf(startCharacter);
    while (start > 0)
    {
      int end = temp.indexOf(endCharacter, start);
      sb.append(temp.substring(0, start));
      String key = temp.substring(start + startCharacter.length(), end);
      sb.append(getValue(key, data));
      temp = temp.substring(end + endCharacter.length());
      start = temp.indexOf(startCharacter);
    }
    sb.append(temp);
    return sb.toString();
  }
  private static String getValue(final String piece, Object data)
  {
    try
    {
      Field[] declaredFields = data.getClass().getDeclaredFields();
      List<Field> f = Query.where(declaredFields, new Function1<Field, Boolean>()
      {
        @Override
        public Boolean call(Field i)
        {
          return i.getName().equals(piece);
        }
      });
      f.get(0).setAccessible(true);
      return "" + f.get(0).get(data);
    }
    catch (Exception e)
    {
      return piece;
    }
  }
  public static String parseRtfFile(String fileName, Object data)
  {
    try
    {
      String text = FileUtils.readFromClassPath(data.getClass(), fileName);
      return parse(text, "\\{", "\\}", data);
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
