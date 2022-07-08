// Sean Szumlanski
// But also, like, szlum dawg
// COP 3503, Fall 2021

// =========================
// Pathogen: SussyBaka.java
// =========================

import java.io.*;
import java.util.*;

public class SussyBaka
{
	// Read maze from file. This function dangerously assumes the input file
	// exists and is well formatted according to the specification above.
	private static char [][] readMaze(String filename) throws IOException
	{
		Scanner in = new Scanner(new File(filename));

		int height = in.nextInt();
		int width = in.nextInt();

		char [][] maze = new char[height][];

		// After reading the integers, there's still a new line character we
		// need to do away with before we can continue.

		in.nextLine();

		for (int i = 0; i < height; i++)
		{
			// Explode out each line from the input file into a char array.
			maze[i] = in.nextLine().toCharArray();
		}

		return maze;
	}

	public static void main(String [] args) throws IOException
	{
		// Load maze and solution paths from file.
		char [][] maze = readMaze("input_files/maze-sussy.txt");
		
		// Calculate paths.
		Pathogen.disableAnimation();
		HashSet<String> paths = Pathogen.findPaths(maze);

		System.out.println();
		System.out.println("======== MAZE ========");
		for (char[] line : maze)
			System.out.println(line);

		System.out.println();
		System.out.println("======== COUNT ========");
		System.out.printf("There are %d path(s).\n", paths.size());

		System.out.println();
		System.out.println("======== PATHS ========");
		for (String path : paths)
			System.out.println(path);
	}
}
