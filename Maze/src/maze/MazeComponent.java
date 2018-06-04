package maze;



//Name: Xijia Chen	
//USC NetID: xijiac
//CS 455 PA3
//Spring 2018
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.Iterator;

import javax.swing.JComponent;


/**
MazeComponent class

A component that displays the maze and path through it if one has been found.
*/
public class MazeComponent extends JComponent
{

private static final int START_X = 10; // top left of corner of maze in frame
private static final int START_Y = 10;
private static final int BOX_WIDTH = 20;  // width and height of one maze "location"
private static final int BOX_HEIGHT = 20;
private static final int INSET = 2;  
                 // how much smaller on each side to make entry/exit inner box
private int row = 0, col = 0;
private MazeCoord startLoc;
private MazeCoord endLoc;
private Maze maze;

/**
   Constructs the component.
   @param maze   the maze to display
*/
public MazeComponent(Maze maze) 
{   
   row = maze.numRows();
   col = maze.numCols();
   startLoc = maze.getEntryLoc();
   endLoc = maze.getExitLoc();
   this.maze = maze;
}


/**
  Draws the current state of maze including the path through it if one has
  been found.
  @param g the graphics context
*/
public void paintComponent(Graphics g)
{
	Graphics2D g2 = (Graphics2D) g;
	Rectangle outWall = new Rectangle(START_X-1, START_Y-1, BOX_WIDTH*col+2, BOX_HEIGHT*row+2);
	g2.setColor(Color.BLACK);
	g2.draw(outWall);
	for(int i = 0; i<row; i++) {
		for(int j = 0; j<col; j++) {
			Rectangle box = new Rectangle(START_X+j*BOX_WIDTH, START_Y+i*BOX_HEIGHT, BOX_WIDTH, BOX_HEIGHT);
			Color color = maze.mazeData[i][j]==true?Color.BLACK:Color.WHITE;
			g2.setColor(color);
			g2.draw(box);
			g2.fill(box);
			if(i==startLoc.getRow()&&j==startLoc.getCol()) {
				Rectangle start = new Rectangle(START_X+j*BOX_WIDTH+INSET, START_Y+i*BOX_HEIGHT+INSET, BOX_WIDTH-2*INSET, BOX_HEIGHT-2*INSET);
				g2.setColor(Color.YELLOW);
				g2.draw(start);
				g2.fill(start);
			}else if (i==endLoc.getRow()&&j==endLoc.getCol()) {
				Rectangle end = new Rectangle(START_X+j*BOX_WIDTH+INSET, START_Y+i*BOX_HEIGHT+INSET, BOX_WIDTH-2*INSET, BOX_HEIGHT-2*INSET);
				g2.setColor(Color.GREEN);
				g2.draw(end);
				g2.fill(end);
			}
		}
	}
	if(maze.getPath()!=null) {
		Iterator line = maze.getPath().iterator();
		MazeCoord start = (MazeCoord) line.next();
		MazeCoord next;
		g2.setColor(Color.BLUE);
		while(line.hasNext()) {
			next = (MazeCoord) line.next();
			if(next.getRow()>start.getRow()) {
				Line2D.Double route = new Line2D.Double(((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+0.5)*(double)BOX_HEIGHT)
						, ((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+1.5)*(double)BOX_HEIGHT));
				g2.draw(route);
			}else if(next.getRow()<start.getRow()) {
				Line2D.Double route = new Line2D.Double(((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+0.5)*(double)BOX_HEIGHT)
						, ((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()-0.5)*(double)BOX_HEIGHT));
				g2.draw(route);
			}else if(next.getCol()>start.getCol()) {
				Line2D.Double route = new Line2D.Double(((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+0.5)*(double)BOX_HEIGHT)
						, ((double)START_X+((double)start.getCol()+1.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+0.5)*(double)BOX_HEIGHT));
				g2.draw(route);
			}else if(next.getCol()<start.getCol()) {
				Line2D.Double route = new Line2D.Double(((double)START_X+((double)start.getCol()+0.5)*(double)BOX_WIDTH), ((double)START_Y+((double)start.getRow()+0.5)*(double)BOX_HEIGHT)
						, (START_X+((double)start.getCol()-0.5)*BOX_WIDTH), (START_Y+((double)start.getRow()+0.5)*BOX_HEIGHT));
				g2.draw(route);
			}
			start = next;
		}
	}
}

}



