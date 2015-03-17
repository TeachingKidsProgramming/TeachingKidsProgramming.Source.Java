package org.lambda.query;

import org.teachingkidsprogramming.util.lambda.Action1;

public class Loops
{
  public static <In> void forEach(Iterable<In> students, Action1<In> a1)
  {
    for (In in : students)
    {
      a1.call(in);
    }
  }
}
