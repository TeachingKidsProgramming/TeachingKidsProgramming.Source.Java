package org.teachingkidsprogramming.recipes.quizzes.tests;

import org.junit.Test;
import org.teachingextensions.approvals.lite.reporters.DelayedClipboardReporter;
import org.teachingextensions.approvals.lite.reporters.DiffReporter;
import org.teachingextensions.approvals.lite.reporters.UseReporter;
import org.teachingextensions.approvals.lite.util.JUnitUtils;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.utils.TortoiseUtils;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizAdapter;
import org.teachingkidsprogramming.recipes.quizzes.graders.TreeQuizGrader;

@UseReporter({DelayedClipboardReporter.class, DiffReporter.class})
public class TreeQuizTest {
    @SuppressWarnings("unused")
    public static class TreeCorrectQuiz extends TreeQuizAdapter {
        //  Sub question1
        private void doubleLength() {
            // make the current length twice what it is
            length = length * 2;
        }

        //      EndSub
        //Question2
        // create a sub called DecreaseTurn which 
        private void decreaseTurn() {
            turn = turn - 1;
        }

        // decrease the current turn by 1
        //Question3
        //create a sub called SetNinety which 
        private void setNinety() {
            // sets the angle of the current turn to 90
            angles.put(turn, 90);
        }

        //Question4
        //create a sub called AngleFive which 
        private void angleFive() {
            angles.put(5, 36);
        }
        // sets the 5th angle to 36 degrees
    }

    @Test
    public void testCorrect() throws Exception {
        JUnitUtils.assumeNotHeadless();
        TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
        new TreeQuizGrader().grade(new TreeCorrectQuiz());
        TortoiseUtils.verifyForOs();
    }

    @SuppressWarnings("unused")
    public static class TreeIncorrectQuiz extends TreeQuizAdapter {
        //  Sub question1
        private void doubleLength() {
            // make the current length twice what it is
            length = length + 2;
        }

        //      EndSub
        //Question2
        // create a sub called DecreaseTurn which 
        private void decreaseTurn() {
            turn = turn + 1;
        }

        // decrease the current turn by 1
        //Question3
        //create a sub called SetNinety which 
        private void setNinety() {
            // sets the angle of the current turn to 90
            angles.put(turn, 30);
        }

        //Question4
        //create a sub called AngleFive which 
        private void angleFive() {
            angles.put(36, 5);
        }
        // sets the 5th angle to 36 degrees
    }

    @Test
    public void testIncorrect() throws Exception {
        JUnitUtils.assumeNotHeadless();
        TreeQuizGrader.TURTLE_SPEED = Turtle.TEST_SPEED;
        new TreeQuizGrader().grade(new TreeIncorrectQuiz());
        TortoiseUtils.verifyForOs();
    }
}
