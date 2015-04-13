package org.teachingkidsprogramming.recipes.completed.section05recursion;

import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizGrader;

public class TreeQuiz extends TreeQuizAdapter
{
  public void questions1To4()
  {
    //   Question 1 
    //   doubleLength (recipe below) 
    //   ------------- Recipe for doubleLength 
    //       make the current length twice what it is
    //   ------------- End of doubleLength recipe
    //
    //   Question 2 
    //   decreaseTurn (recipe below) 
    //   ------------- Recipe for decreaseTurn 
    //      decrease the current turn by 1
    //   ------------- End of decreaseTurn recipe
    //
    //   Question 3 
    //   setNinety (recipe below) 
    //   ------------- Recipe for setNinety 
    //       set the current turn angle to 90, HINT: Use angles.put(key,value);
    //   ------------- End of setNinety recipe
    //
    //   Question 4 
    //   angleFive (recipe below) 
    //   ------------- Recipe for angleFive 
    //       sets the 5th angle to 36 degrees
    //   ------------- End of angleFive recipe
  }
  //  Sub question1
  public void doubleLength()
  {
    // make the current length twice what it is
    length = length * 2;
  }
  //      EndSub
  //Question2
  // create a sub called DecreaseTurn which 
  public void decreaseTurn()
  {
    turn = turn - 1;
  }
  // decrease the current turn by 1
  //Question3
  //create a sub called SetNinety which 
  public void setNinety()
  {
    // sets the angle of the current turn to 90
    angles.put(turn, 90);
  }
  //Question4
  //create a sub called AngleFive which 
  public void angleFive()
  {
    angles.put(5, 36);
  }
  // sets the 5th angle to 36 degrees
  public static void main(String[] args)
  {
    new TreeQuizGrader().grade(new TreeQuiz());
  }
}
