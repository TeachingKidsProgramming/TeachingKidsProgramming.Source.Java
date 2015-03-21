package org.teachingkidsprogramming.section08tdd;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.PenColors;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PuzzleBoard extends JPanel {
  private static final String completed        = "Batgirl.png";
  private static final long   serialVersionUID = -3592444274530147326L;
  private final List<Tile>        tiles;
  private final Point[]           positions;
  private final List<PuzzleBoard> history;
  private       boolean           done;

  public PuzzleBoard() {
    this.positions = createPositions();
    this.tiles = createTiles(shuffled(this.positions));
    this.history = new ArrayList<>();
  }

  public PuzzleBoard(Point[] positions, List<Tile> tiles) {
    this(positions, tiles, new ArrayList<PuzzleBoard>());
  }

  public PuzzleBoard(PuzzleBoard puzzle) {
    this(puzzle.positions, puzzle.tiles, puzzle.history);
  }

  public PuzzleBoard(Point[] positions, List<Tile> tiles, List<PuzzleBoard> history) {
    this.positions = new Point[positions.length];
    for (int i = 0; i < positions.length; i++) {
      this.positions[i] = new Point(positions[i]);
    }

    this.tiles = new ArrayList<>(tiles.size());
    for (int i = 0; i < tiles.size(); i++) {
      Tile t = tiles.get(i);
      this.tiles.add(i, new Tile(t));
    }

    if (history == null) history = new ArrayList<>();

    this.history = new ArrayList<>(history.size());
    for (int i = 0; i < history.size(); i++) {
      PuzzleBoard b = history.get(i);
      this.history.add(i, new PuzzleBoard(b));
    }
  }

  public static List<Point> shuffled(Point[] positions) {
    List<Point> s = new ArrayList<>(Arrays.asList(positions));
    Collections.shuffle(s);
    return s;
  }

  public static Point[] createPositions() {
    Point[] p = new Point[9];
    Point point;
    for (int i = 0; i < 9; i++) {
      if (i < 3) {
        point = new Point(35, 35 + (127 * i));
      } else if (i < 6) {
        point = new Point(162, 35 + (127 * (i - 3)));
      } else {
        point = new Point(289, 35 + (127 * (i - 6)));
      }
      p[i] = point;
    }
    return p;
  }

  public static List<Tile> createTiles(List<Point> positions) {
    ArrayList<Tile> t = new ArrayList<>(9);
    for (int i = 0; i < 8; i++) {
      t.add(new Tile(i, positions.get(i)));
    }
    return t;
  }

  public static List<Tile> createTiles(Point[] positions) {
    return createTiles(Arrays.asList(positions));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawBorder(g);
    drawField(g);
    if (!this.done) {
      drawTiles(g);
    } else {
      drawReward(g);
    }
  }

  private void drawReward(Graphics g) {
    Image image = ObjectUtils.loadImage(this.getClass(), completed);
    Graphics2D g2d = (Graphics2D) g.create();
    g2d.drawImage(image, this.positions[0].x, this.positions[0].y, 376,
        376, null);
    g2d.dispose();
  }

  private void drawTiles(Graphics g) {
    Graphics2D g2d = (Graphics2D) g.create();
    for (Tile tile : tiles) {
      tile.paint(g2d);
    }
    g2d.dispose();
  }

  private void drawField(Graphics g) {
    g.setColor(PenColors.Blues.SkyBlue);
    g.fillRect(30, 30, 386, 386);
  }

  private void drawBorder(Graphics g) {
    g.setColor(PenColors.Blues.DarkBlue);
    g.fillRect(20, 20, 410, 410);
  }

  public Tile getPiece(int i) {
    return this.tiles.get(i);
  }

  public List<Point> getPositions() {
    return Arrays.asList(positions);
  }

  public boolean isSorted() {
    return countMisplaced() == 0;
  }

  private int countMisplaced() {
    int misplaced = 0;
    for (int i = 0; i < 8; i++) {
      Tile tile = this.tiles.get(i);
      Point point = this.positions[i];
      if (!tile.isAt(point)) {
        misplaced++;
      }
    }
    return misplaced;
  }

  public void finish() {
    this.done = true;
  }

  public List<Tile> getTiles() {
    return new ArrayList<>(this.tiles);
  }

  /**
   * A move is valid if the target is the board's blank square
   *
   * @param move
   *     the move to check
   * @return true if the move is valid
   */
  public boolean isValidMove(TileMove move) {
    Point blank = findBlank();
    return blank == this.positions[move.getTarget()];
  }

  private Point findBlank() {
    for (Point point : positions) {
      if (!anyTileIsAt(point)) {
        return point;
      }
    }

    return null;
  }

  private boolean anyTileIsAt(Point point) {
    for (Tile tile : tiles) {
      if (tile.isAt(point)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Create a copy of the board then use the provided move to update it
   *
   * @param move
   *     the move to perform on the puzzle copy
   * @return The updated copy of the board
   */
  public PuzzleBoard useMove(TileMove move) {
    PuzzleBoard c = new PuzzleBoard(this);

    Tile s = c.getPieceFromPosition(move.getSource());
    s.moveTo(c.positions[move.getTarget()]);
    s.teleport();
    c.history.add(new PuzzleBoard(this));

    return c;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    PuzzleBoard that = (PuzzleBoard) o;

    return this.toString().equals(that.toString());

  }

  @Override
  public int hashCode() {
    return tiles.hashCode();
  }

  public Tile getPieceFromPosition(int source) {
    Point position = this.positions[source];
    for (Tile tile : this.tiles) {
      if (tile.isAt(position)) {
        return tile;
      }
    }

    return null;
  }

  public List<PuzzleBoard> getHistory() {
    return new ArrayList<>(this.history);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[ ");
    for(Tile t : this.tiles){
      builder.append(t.toString()).append(", ");
    }
    builder.append("]");

    return builder.toString();
  }

  public boolean isVisited() {
    return this.history.contains(this);
  }
}
