package org.teachingextensions.logo.tests;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;
import org.teachingextensions.virtualproctor.VirtualProctor;

public class VirtualProctorTest 
{
  @Test 
  public void testSetName() throws Exception
  {
    VirtualProctor.internals.resetName();
    VirtualProctor.setName("Lynn");
    assertEquals("Lynn", VirtualProctor.internals.getName());
  }
  
  @Test
  public void testSetClassName(){
    VirtualProctor.internals.resetClassName();
  VirtualProctor.setClassName("Mob");
  assertEquals("Mob", VirtualProctor.internals.getClassName());
  }
  
  @Test
  public void testGetFullName(){
    VirtualProctor.internals.resetClassName();
    VirtualProctor.internals.resetName();
    VirtualProctor.setName("Jason");
    VirtualProctor.setClassName("BoardGames");
    assertEquals("BoardGames.Jason", VirtualProctor.internals.getFullName());  
  }
}

