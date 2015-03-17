package org.teachingkidsprogramming.util.io;

public interface StackElementSelector
{
  public abstract StackTraceElement selectElement(StackTraceElement[] trace) throws Exception;
}