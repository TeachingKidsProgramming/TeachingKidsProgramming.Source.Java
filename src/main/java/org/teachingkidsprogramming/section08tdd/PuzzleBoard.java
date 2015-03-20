package org.teachingkidsprogramming.section08tdd;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.logo.PenColors;

public class PuzzleBoard extends JPanel {
  private static final String completed        = "Batgirl.png";
  private static final long   serialVersionUID = -3592444274530147326L;
  private final List<Tile>    tiles;
  private final List<Point>   positions;
  private boolean             done;

  public PuzzleBoard() {
    this.positions = createPositions();
    this.tiles = createTiles(shuffled(this.positions));

  }

  public PuzzleBoard(List<Point> positions, List<Tile> tiles) {
    this.positions = new ArrayList<>(positions.size());
    for (int i = 0; i < positions.size(); i++) {
      Point p = positions.get(i);
      this.positions.add(i, new Point(p));
    }

    this.tiles = new ArrayList<>(tiles.size());
    for (int i = 0; i < tiles.size(); i++) {
      Tile t = tiles.get(i);
      this.tiles.add(i, new Tile(t));
    }
  }

  public PuzzleBoard(PuzzleBoard puzzle) {
    this(puzzle.positions, puzzle.tiles);
  }

  private static List<Point> shuffled(List<Point> positions) {
    List<Point> s = new ArrayList<>(positions);
    Collections.shuffle(s);
    return s;
  }

  public static List<Point> createPositions() {
    ArrayList<Point> p = new ArrayList<>(9);
    Point point;
    for (int i = 0; i < 9; i++) {
      if (i < 3) {
        point = new Point(35, 35 + (127 * i));
      } else if (i < 6) {
        point = new Point(162, 35 + (127 * (i - 3)));
      } else {
        point = new Point(289, 35 + (127 * (i - 6)));
      }
      p.add(point);
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
    g2d.drawImage(image, this.positions.get(0).x, this.positions.get(0).y, 376,
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
    return new ArrayList<>(positions);
  }

  public boolean isSorted() {
    return countMisplaced() == 0;
  }

  private int countMisplaced() {
    int misplaced = 0;
    for (int i = 0; i < 8; i++) {
      Tile tile = this.tiles.get(i);
      Point point = this.positions.get(i);
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
   *          the move to check
   * @return true if the move is valid
   */
  public boolean isValidMove(TileMove move) {
    Point blank = findBlank();
    return blank == this.positions.get(move.getTarget());
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
   *          the move to perform on the puzzle copy
   * @return The updated copy of the board
   */
  public PuzzleBoard useMove(TileMove move) {
    PuzzleBoard c = new PuzzleBoard(this);

    Tile s = c.getPieceFromPosition(move.getSource());
    s.moveTo(c.positions.get(move.getTarget()));
    s.teleport();

    return c;
  }

  /**
   * Estimate the cost of solving the puzzle if this is the next step in the
   * solution.
   *
   * @param history
   *          All the steps we have already visited.
   * @return The estimated cost
   */
  public int estimateCost(List<PuzzleBoard> history) {

    // see
    // https://jdanger.com/solving-8-puzzle-with-artificial-intelligence.html
    // for ruby implementation

    // We know the actual cost will be at least 1, because we must
    // make at least one move to get to this board.
    int cost = 1;

    // Each tile that is in the wrong position will require at least
    // one move to get it in the right position (and possibly more than
    // 1). So add 1 to the estimate for every misplaced tile.
    cost += this.countMisplaced();

    // If we have visited this board before, then we are actually
    // going backward. We will need at least one more move after
    // this one to move forward to the solution. So add one more move
    // to the estimate for every time we have visited this board.
    cost += this.timesVisited(history);

    return cost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    PuzzleBoard that = (PuzzleBoard) o;

    if (!tiles.equals(that.tiles))
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return tiles.hashCode();
  }

  private int timesVisited(List<PuzzleBoard> history) {
    int visited = 0;
    for (PuzzleBoard puzzleBoard : history) {
      if (this.equals(puzzleBoard)) {
        visited++;
      }
    }

    return visited;
  }

  public Tile getPieceFromPosition(int source) {
    Point position = this.positions.get(source);
    for (Tile tile : this.tiles) {
      if (tile.isAt(position)) {
        return tile;
      }
    }

    return null;
  }
}
