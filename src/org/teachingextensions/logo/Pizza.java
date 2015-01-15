package org.teachingextensions.logo;

import java.util.ArrayList;

public class Pizza
{
  private ArrayList<Topping> toppings = new ArrayList<Topping>();
  public void addTopping(Topping topping)
  {
    this.toppings.add(topping);
  }
  public boolean hasTopping(Topping topping)
  {
    for (Topping toppingToday : toppings)
    {
      if (toppingToday == topping) { return true; }
    }
    return false;
  }
}
