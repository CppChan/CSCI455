package maze;



//Name: Xijia Chen	
//USC NetID:xijiac	 
//CS 455 PA3
//Spring 2018
import java.util.HashSet;
import java.util.LinkedList;


/**
Maze class

Stores information about a maze and can find a path through the maze
(if there is one).

Assumptions about structure of the maze, as given in mazeData, startLoc, and endLoc
(parameters to constructor), and the path:
  -- no outer walls given in mazeData -- search assumes there is a virtual 
     border around the maze (i.e., the maze path can't go outside of the maze
     boundaries)
  -- start location for a path is maze coordinate startLoc
  -- exit location is maze coordinate exitLoc
  -- mazeData input is a 2D array of booleans, where true means there is a wall
     at that location, and false means there isn't (see public FREE / WALL 
     constants below) 
  -- in mazeData the first index indicates the row. e.g., mazeData[row][col]
  -- only travel in 4 compass directions (no diagonal paths)
  -- can't travel through walls

*/

public class Maze {

public static final boolean FREE = false;
public static final boolean WALL = true;
public boolean[][]mazeData;
private MazeCoord startLoc;
private MazeCoord exitLoc;
private LinkedList<MazeCoord>result;
private boolean[][]visited;

/**
   Constructs a maze.
   @param mazeData the maze to search.  See general Maze comments above for what
   goes in this array.
   @param startLoc the location in maze to start the search (not necessarily on an edge)
   @param exitLoc the "exit" location of the maze (not necessarily on an edge)
   PRE: 0 <= startLoc.getRow() < mazeData.length and 0 <= startLoc.getCol() < mazeData[0].length
      and 0 <= endLoc.getRow() < mazeData.length and 0 <= endLoc.getCol() < mazeData[0].length

 */
public Maze(boolean[][] mazeData, MazeCoord startLoc, MazeCoord exitLoc) {
	this.mazeData = mazeData;
	this.startLoc = startLoc;
	this.exitLoc = exitLoc;
}


/**
   Returns the number of rows in the maze
   @return number of rows
*/
public int numRows() {
   return mazeData.length;   // DUMMY CODE TO GET IT TO COMPILE
}


/**
   Returns the number of columns in the maze
   @return number of columns
*/   
public int numCols() {
   return mazeData[0].length;   // DUMMY CODE TO GET IT TO COMPILE
} 


/**
   Returns true iff there is a wall at this location
   @param loc the location in maze coordinates
   @return whether there is a wall here
   PRE: 0 <= loc.getRow() < numRows() and 0 <= loc.getCol() < numCols()
*/
public boolean hasWallAt(MazeCoord loc) {
	return mazeData[loc.getRow()][loc.getCol()] == true? true: false;
	// DUMMY CODE TO GET IT TO COMPILE
}


/**
   Returns the entry location of this maze.
 */
public MazeCoord getEntryLoc() {
   return startLoc;   // DUMMY CODE TO GET IT TO COMPILE
}


/**
  Returns the exit location of this maze.
*/
public MazeCoord getExitLoc() {
   return exitLoc;   // DUMMY CODE TO GET IT TO COMPILE
}


/**
   Returns the path through the maze. First element is start location, and
   last element is exit location.  If there was not path, or if this is called
   before a call to search, returns empty list.

   @return the maze path
 */
public LinkedList<MazeCoord> getPath() {

   return result;   // DUMMY CODE TO GET IT TO COMPILE

}


/**
   Find a path from start location to the exit location (see Maze
   constructor parameters, startLoc and exitLoc) if there is one.
   Client can access the path found via getPath method.

   @return whether a path was found.
 */
public boolean search()  {  
   
   result = new LinkedList<MazeCoord>();
   visited = new boolean[numRows()][numCols()];
   if(findToEnd(startLoc)==true) {
	   return true;
   }else {
	   result = null;
	   return false;
   }
}

private boolean findToEnd(MazeCoord point) {
	
	int pointX = point.getRow();
	int pointY = point.getCol();
	if(visited[pointX][pointY]==true)return false;
	if(point.equals(startLoc)) {
		visited[pointX][pointY]=true;
	}
	if(mazeData[pointX][pointY]==true) {
		return false;
	}else if(point.equals(exitLoc)) {
		result.add(point);
		return true;
	}
	if(pointX+1<numRows()) {
		if(visited[pointX+1][pointY]==false) {
			visited[pointX][pointY]=true;
			if(findToEnd(new MazeCoord(pointX+1, pointY))==true) {
				result.add(point);
				return true;
			}
		}	
	}
	if(pointX-1>=0) {
		if(visited[pointX-1][pointY]==false) {
			visited[pointX][pointY]=true;
			if(findToEnd(new MazeCoord(pointX-1, pointY))==true) {
				result.add(point);	
				return true;
			}
		}	
	}
	if(pointY+1<numCols()) {
		if(visited[pointX][pointY+1]==false) {
			visited[pointX][pointY]=true;
			if(findToEnd(new MazeCoord(pointX, pointY+1))==true) {
				result.add(point);
				return true;
			}
		}	
	}
	if(pointY-1>=0) {
		if(visited[pointX][pointY-1]==false) {
			visited[pointX][pointY]=true;
			if(findToEnd(new MazeCoord(pointX, pointY-1))==true) {
				result.add(point);
				return true;
			}
		}	
	}
	return false;
}

}
