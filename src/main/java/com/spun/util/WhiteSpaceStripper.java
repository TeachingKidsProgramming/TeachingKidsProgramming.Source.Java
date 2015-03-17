package com.spun.util;

import org.teachingkidsprogramming.util.MySystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WhiteSpaceStripper 
{
	/***********************************************************************/
	public static void stripFolder(File dir)
  {
    stripFolder(dir, true);
  }
	/***********************************************************************/
	public static void stripFolder(File dir, boolean recursive)
  {
  	if (!dir.isDirectory())
    {
    	MySystem.warning("File is not a Directory - " + dir.toString());
    	return;
    }
  	
  	File[] files = dir.listFiles(new WhiteSpaceFileFilter());
  	for (int i = 0; i < files.length; i++)
    {
    	if (files[i].isDirectory())
      {
      	MySystem.event("Scaning Directory -" + files[i].getName());
      	if (recursive) stripFolder(files[i], recursive);
      }
    	else
      {
        stripFile(files[i]);
      }
    }
  }

    /***********************************************************************/
	public static void stripFile(File file)
  {
    
  	if (!file.isFile())
    {
    	MySystem.warning("File is not a File - " + file.toString());
    	return;
    }
		if(!file.canWrite())
		{
			MySystem.event("File '" + file.toString() + "' is readonly");
        }
		else
		{
	    try
	    {
	      String contents = readFile(file);
	      String stripped = stripWhiteSpace(contents);
	      writeFile(file, stripped);
	    }
	    catch (IOException e)
	    {
	      MySystem.warning(e);
	    }
		}
  }
  /***********************************************************************/
  public static String stripWhiteSpace(String text)
  {
    StringBuilder newText = new StringBuilder();
    boolean whitespace = false;
    int num = text.length();
		char whiteSpaceChar = ' ';
    for (int i = 0; i < num; i++)
    {
      char c = text.charAt(i);
			switch (c)
			{
				case '\n' : whiteSpaceChar = '\n';whitespace = true;break;
				case '\t' :
				case ' '  : whitespace = true;break;
				default	  : 
					if (whitespace)
					{
						whitespace = false;
						newText.append(whiteSpaceChar);
						whiteSpaceChar = ' '; 
					}						
	        newText.append(c);break;
      }
    }
    return newText.toString();
  }

    /***********************************************************************/
  private static String readFile(File file)
  throws IOException
  {
    BufferedReader reader = new BufferedReader(new FileReader(file));
    StringBuilder output = new StringBuilder();
    
    while (reader.ready())
    {
      output.append(reader.readLine());
	    output.append("\n");
    }
    
    reader.close();
    return output.toString();
  }
	/***********************************************************************/
	private static void writeFile(File file, String text)
	throws IOException
	{
    FileWriter writer = new FileWriter(file);
    
    writer.write(text);
    
    writer.close();
	}
	/***********************************************************************/
  public static void main (String [] args)
  {
//    stripFolder(new File("C:\\temp\\stockgazing"));
  }
	/***********************************************************************/
  /***********************************************************************/
}


class WhiteSpaceFileFilter
  implements java.io.FileFilter
{

  /***********************************************************************/

  public boolean accept(File pathname)
  {
  	
    if (pathname.getName().equals(".") || pathname.getName().equals("."))
    {
      return false;
    }
    else if (pathname.getName().equalsIgnoreCase("email"))
    {
      return false;
    }
    else
        return pathname.isDirectory() || (pathname.getName().indexOf(".htm") != -1) || (pathname.getName().indexOf(".txt") != -1);
  }
  
  /***********************************************************************/
  /***********************************************************************/
}