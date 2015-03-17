package com.spun.util.servlets;

import org.teachingkidsprogramming.util.parser.TemplateError;

public interface SecondaryErrorProcessor
{
  public String processError(TemplateError error, Throwable t2);
}
