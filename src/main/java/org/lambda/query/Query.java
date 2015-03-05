package org.lambda.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.lambda.functions.Function1;

public class Query<In>
{
  public static <In, Out> List<Out> select(List<In> list, Function1<In, Out> function)
  {
    ArrayList<Out> out = new ArrayList<Out>();
    for (In i : list)
    {
      out.add(function.call(i));
    }
    return out;
  }
  public static <In, Out> List<Out> select(In[] list, Function1<In, Out> function)
  {
    return select(Arrays.asList(list), function);
  }
  public static <In> List<In> where(Iterable<In> list, Function1<In, Boolean> funct)
  {
    ArrayList<In> out = new ArrayList<In>();
    for (In i : list)
    {
      if (funct.call(i))
      {
        out.add(i);
      }
    }
    return out;
  }
  public static <In> List<In> where(In[] list, Function1<In, Boolean> funct)
  {
    ArrayList<In> out = new ArrayList<In>();
    for (In i : list)
    {
      if (funct.call(i))
      {
        out.add(i);
      }
    }
    return out;
  }
  public static <In> Double average(List<In> list, Function1<In, Number> f1)
  {
    double total = 0.00;
    for (In in : list)
    {
      total += f1.call(in).doubleValue();
    }
    return total / list.size();
  }
  public static <In, Out extends Number> Double sum(In[] list, Function1<In, Out> f1)
  {
    return sum(Arrays.asList(list), f1);
  }
  public static <In, Out extends Number> Double sum(Collection<In> list, Function1<In, Out> f1)
  {
    double sum = 0;
    for (In in : list)
    {
      sum += f1.call(in).doubleValue();
    }
    return sum;
  }
  public static <Out extends Number> Double sum(Collection<Out> list)
  {
    return sum(list, new Echo1<Out>());
  }
  public static <Out extends Number> Double sum(Out[] list)
  {
    return sum(list, new Echo1<Out>());
  }
}
