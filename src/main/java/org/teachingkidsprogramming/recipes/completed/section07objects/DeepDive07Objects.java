package org.teachingkidsprogramming.recipes.completed.section07objects;

import org.junit.Assert;
import org.junit.Test;
import org.teachingextensions.logo.Tortoise;
import org.teachingextensions.logo.Turtle;
import org.teachingextensions.logo.Turtle.Animals;
import org.teachingextensions.logo.utils.PizzaUtils.Pizza;
import org.teachingextensions.logo.utils.PizzaUtils.Topping;

import java.awt.*;

@SuppressWarnings("unused")
public class DeepDive07Objects
{
  @Test
  public void twoTortoises() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    boolean result = rafael.equals(michealangelo);
    Assert.assertEquals(false, result);
  }
  @Test
  public void twoTortoisesAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise anonymousNinja = rafael;
    boolean result = rafael.equals(anonymousNinja);
    Assert.assertEquals(true, result);
  }
  @Test
  public void twoTortoisesYetAgain() throws Exception
  {
    Tortoise rafael = new Tortoise();
    Tortoise michelangelo = new Tortoise();
    Tortoise anonymousNinja = michelangelo;
    boolean result = michelangelo.equals(anonymousNinja);
    Assert.assertEquals(true, result);
  }
  //Turtle Leonardo belongs to "this"
  private Turtle leonardo;
  @Test
  public void fatTrailTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this.leonardo = ninja;
    ninja.setPenWidth(30);
    Assert.assertEquals(30, this.leonardo.getPenWidth());
  }
  //Turtle Donatello belongs to "this"
  private Turtle donatello;
  @Test
  public void explodingTurtle() throws Exception
  {
    Turtle ninja = new Turtle();
    this.donatello = ninja;
    this.donatello.setAnimal(Animals.ExplodedTurtle);
    Assert.assertTrue("The ninja is still alive!", ninja.isDead());
  }
  @Test
  public void feedTheNinja() throws Exception
  {
    Tortoise michelangelo = new Tortoise();
    michelangelo.likesTopping(Topping.Pepperoni);
    Pizza pizza = new Pizza();
    pizza.addTopping(Topping.Pepperoni);
    boolean likedIt = michelangelo.eatPizza(pizza);
    Assert.assertTrue("Michelangelo barfs! Wrong pizza!", likedIt);
  }
  @Test
  public void feedTheNinjaTwo() throws Exception
  {
    Tortoise karai = new Tortoise();
    karai.likesTopping(Topping.Anchovy);
    Pizza pizza = new Pizza();
    pizza.addTopping(Topping.Anchovy);
    boolean likedIt = karai.eatPizza(pizza);
    Assert.assertTrue("Karai turns greener! Wrong pizza!", true);
  }
  @Test
  public void checkOutThePizza() throws Exception
  {
    Tortoise cecil = new Tortoise();
    cecil.likesTopping(Topping.Cheese);
    Pizza pizza = new Pizza();
    pizza.addTopping(Topping.Cheese);
    pizza.cook();
    boolean likedIt = cecil.eatPizza(pizza);
    Assert.assertTrue("Cecil sends it back, raw pizza!", likedIt);
  }
  @Test
  public void feedAllTheNinjas() throws Exception
  {
    Tortoise[] tortoises = throwPizzaParty();
    Pizza pizza = new Pizza();
    pizza.superSizeIt();
    for (Tortoise tortoise : tortoises)
    {
      gotASlice = tortoise.eatPizza(pizza);
      if (!gotASlice)
      {
        break;
      }
    }
    Assert.assertTrue("The ninja flips out - not enough pizza!", gotASlice);
  }
  @Test
  public void feedAllTheNinjasAgain() throws Exception
  {
    Tortoise[] tortoises = throwPizzaParty();
    Pizza pizza = new Pizza();
    pizza.superSizeIt();
    for (Tortoise tortoise : tortoises)
    {
      this.gotASlice = tortoise.eatPizza(pizza);
      if (!this.gotASlice)
      {
        break;
      }
    }
    Assert.assertTrue("The ninja flips out - not enough pizza!", this.gotASlice);
  }
  /**
   * Ignore the following, It's needed to run the deep dive
   *
   *
   *
   *
   *
   *
   *
   *
   *
   *
   */
  private Tortoise[] throwPizzaParty()
  {
    Tortoise karai = new Tortoise();
    Tortoise cecil = new Tortoise();
    Tortoise michealangelo = new Tortoise();
    Tortoise fred = new Tortoise();
    return new Tortoise[]{karai, cecil, michealangelo, fred};
  }
  private boolean gotASlice;
  public boolean  _____     = false;
  public boolean  ______    = true;
  public String   ___       = "You need to fill in the blank ___";
  public int      ____      = 0;
  public Turtle   _______   = new Turtle();
  public Tortoise ________;
  public Topping  _________ = Topping.NoTopping;
  public String ___()
  {
    return ___;
  }
  private Cursor getCursor()
  {
    return Tortoise.getBackgroundWindow().getCanvas().getCursor();
  }
  public DeepDive07Objects()
  {
    this.leonardo = new Turtle();
    this.donatello = new Turtle();
  }
}
