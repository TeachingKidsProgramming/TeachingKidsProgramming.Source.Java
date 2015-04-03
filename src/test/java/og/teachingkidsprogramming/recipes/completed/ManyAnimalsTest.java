package og.teachingkidsprogramming.recipes.completed;

import org.junit.Test;
import org.teachingextensions.approvals.lite.Approvals;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingkidsprogramming.recipes.completed.ManyAnimals;

@UseReporter({DiffReporter.class, DelayedClipboardReporter.class})
public class ManyAnimalsTest
{
  @Test
  public void testShowSomeTurtles(){
    ManyAnimals m = new ManyAnimals();
    Approvals.verify(m.mt);
  }
}
