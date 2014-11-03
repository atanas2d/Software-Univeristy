package chapter10_Recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Exr09_BFSRecursion {
	
	public static int counter = 0;
	public static char[][] maze = {		// 6 x 5 maze[x][y]
		{'s',' ',' ',' ','*',' '},
		{'*','*','*',' ','*',' '},
		{' ','*',' ',' ',' ',' '},
		{' ','*',' ','*','*',' '},
		{' ',' ',' ',' ',' ','e'},		
	};
	
	public static int bestResult = maze.length * maze[1].length;	// Best result keeper, initial value - maximum number of cells in the matrix
	
	public static char shortestPath[][] = new char[5][6];			// Shortest path keeper
	
		
	public static void findPath(int x, int y, char[][] labyrinth, int c) {		// x,y - coordinates, labyrinth -shortest path keeper array, c - step counter
		
		// Transfer labyrinth to 
		
		// Try left
		if ((y - 1 > 0) && (maze[x][y - 1] == ' ')) {	// Check if the left cell is not out of boundaries, not visited, or not wall
			if (maze[x][y - 1] == 'e') {
				if (c < bestResult) {
					bestResult = c;
					// copy labyrinth to shortest Path:
					for (int hor = 0; hor < labyrinth[1].length; hor++ ) {
						for (int vert = 0; vert < labyrinth.length; vert++ ) {
							shortestPath[hor][vert] = labyrinth[hor][vert]; 
						}
					}					
				} 
			} else {
				labyrinth[x][y] = 'l';
				findPath(x, y - 1, labyrinth, c + 1);
			}			
			
		}
		// Try right
		if ((y + 1 < maze[1].length) && ((maze[x][y + 1]) == ' ')) {
			if (maze[x][y + 1] == 'e') {
				if (c < bestResult) {
					bestResult = c;
					// copy labyrinth to shortest Path:
					for (int hor = 0; hor < labyrinth[1].length; hor++ ) {
						for (int vert = 0; vert < labyrinth.length; vert++ ) {
							shortestPath[hor][vert] = labyrinth[hor][vert]; 
						}
					}					
				} 
			} else {
				labyrinth[x][y] = 'r';
				findPath(x, y + 1, labyrinth, c + 1);
			}			
			
		}
		// Try up
		if ((x - 1 > 0) && (maze[x - 1][y] == ' ')) {
			if (maze[x - 1][y] == 'e') {
				if (c < bestResult) {
					bestResult = c;
					// copy labyrinth to shortest Path:
					for (int hor = 0; hor < labyrinth[1].length; hor++ ) {
						for (int vert = 0; vert < labyrinth.length; vert++ ) {
							shortestPath[hor][vert] = labyrinth[hor][vert]; 
						}
					}					
				} 
			} else {
				labyrinth[x][y] = 'r';
				findPath(x - 1, y, labyrinth, c + 1);
			}			
		}
		// Try down 
		if ((x + 1 < maze.length) && (maze[x + 1][y] == ' ')) {
			if (maze[x + 1][y] == 'e') {
				if (c < bestResult) {
					bestResult = c;
					// copy labyrinth to shortest Path:
					for (int hor = 0; hor < labyrinth[1].length; hor++ ) {
						for (int vert = 0; vert < labyrinth.length; vert++ ) {
							shortestPath[hor][vert] = labyrinth[hor][vert]; 
						}
					}					
				} 
			} else {
				labyrinth[x][y] = 'r';
				findPath(x + 1, y, labyrinth, c + 1);
			}			
		}
		
		
			
	}	

	public static void main(String[] args) {
		// TODO BFS searching the shortest path in a labyrinth			
		
		findPath(0,0,maze,0);
		
		// Print maze:
				for (int ver = 0; ver < maze.length; ver ++ ) {
					for (int hor = 0; hor < maze[1].length; hor ++) {
						System.out.printf("[%c]", maze[ver][hor]);
					}
					System.out.println();
				}
				
		// Print the result:
		for (int ver = 0; ver < shortestPath.length; ver ++ ) {
			for (int hor = 0; hor < shortestPath[1].length; hor ++) {
				System.out.printf("[%c]", shortestPath[ver][hor]);
			}
			System.out.println();
		}
		
	}
		

}
