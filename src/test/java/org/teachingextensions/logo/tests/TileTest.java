package org.teachingextensions.logo.tests;

import org.junit.Test;
import org.teachingkidsprogramming.section08tdd.Tile;

import java.awt.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by james on 3/20/15.
 */
public class TileTest {
  @Test
  public void tileShouldKnowWhereItBelongs(){
    Tile t = new Tile(0, new Point(0, 0));
    assertEquals(0, t.getCorrectPositionIndex());
  }
}
