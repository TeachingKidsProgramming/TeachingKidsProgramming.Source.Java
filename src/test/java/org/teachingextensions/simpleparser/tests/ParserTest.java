package org.teachingextensions.simpleparser.tests;

import junit.framework.TestCase;

import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.simpleparser.Parser;

@UseReporter(DiffReporter.class)
@SuppressWarnings("unused")
public class ParserTest extends TestCase
{
  private int    a = 1;
  private String b = "howdy";
  public void testSimpleParse() throws Exception
  {
    String text = Parser.parse("This should show \r\n  a = {a} \r\n  b = {b}", this);
    Approvals.verify(text);
  }
}
