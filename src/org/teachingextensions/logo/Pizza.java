package org.teachingextensions.logo;

import java.util.ArrayList;

public class Pizza
{
  private ArrayList<Topping> toppings = new ArrayList<Topping>();
  private boolean            cooked;
  private int                slices   = 2;
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
  public void cook()
  {
    this.cooked = true;
  }
  public boolean wasCooked()
  {
    return this.cooked;
  }
  public void ____()
  {
  }
  public boolean takeSlice()
  {
    if (0 < this.slices)
    {
      this.slices--;
      return true;
    }
    return false;
  }
  public void superSizeIt()
  {
    this.slices = 8;
  }
}
