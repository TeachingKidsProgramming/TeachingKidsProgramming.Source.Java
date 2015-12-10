package org.teachingkidsprogramming.recipes.completed.section07objects;

import javax.swing.ImageIcon;

import org.teachingextensions.logo.utils.EventUtils.FancyMessageBox;

//*************This Lesson is In Development*****************************//
public class WhichFish
{
  public static void main(String[] args)
  {
    //  Uncomment to create a variable called 'numberOfFish' to hold the result of the question "How many fishes?"
    //  Use the FancyMessageBox with a title of "Are fishes like wishes?"
    int numberOfFish = FancyMessageBox.askForNumericalInput("How many fishes?", "Are Fishes Like Wishes?");
    //  create recipe makeAFishyDecision using the numberOfFish (recipe below)
    makeAFishyDecision(numberOfFish);
  }
  //    recipe for makeAFishyDecision with the numberOfFish
  public static void makeAFishyDecision(int numberOfFish)
  {
    // Use a switch...case on the numberOfFish
    switch (numberOfFish)
    {
      // When the numberOfFish is -1
      case -1 :
        // Uncomment to create a string of this image
        String image = "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/thumb-up.png";
        //  Create a new ImageIcon from your image
        ImageIcon icon = new ImageIcon(image);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("Had a Fish", "Not hungry anymore...", icon);
        // End
        break;
      // When the numberOfFish is 0  
      case 0 :
        // Uncomment to create a string of this image
        String image0 = "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/information.png";
        //  Create a new ImageIcon from your image
        ImageIcon icon0 = new ImageIcon(image0);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("No Fish", "Still hungry", icon0);
        // End
        break;
      // When the numberOfFish is 1    
      case 1 :
        // Uncomment to create a string of this image
        String image1 = "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/star.png";
        // Create a new ImageIcon from your image
        ImageIcon icon1 = new ImageIcon(image1);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("One Fish", "This one has a little star", icon1);
        // End
        break;
      // When the numberOfFish is 0    
      case 2 :
        // Uncomment to create a string of this image
        String image2 = "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/github.png";
        //  Create a new ImageIcon from your image
        ImageIcon icon2 = new ImageIcon(image2);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("Two Fish", "Funny things are everywhere", icon2);
        // End
        break;
      // Otherwise  
      default :
        // Uncomment to create a string of this image
        String image4 = "../TeachingKidsProgramming.Source.Java/src/main/resources/icons/hint.png";
        // Create a new ImageIcon from your image
        ImageIcon icon4 = new ImageIcon(image4);
        // Show a message with the fancy message box this text, this title and this icon...
        FancyMessageBox.showMesage("Vegetaraian meal", "Fish are icky", icon4);
        // End
        break;
    }
  }
}
