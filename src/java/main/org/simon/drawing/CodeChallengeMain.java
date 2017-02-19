package org.simon.drawing;

import org.simon.drawing.object.Canvas;

/**
 * This is the main entrance class for whole code challenging to kick start 
 * and run in console.
 * @author Simon
 *
 */
public class CodeChallengeMain {

	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		
		CommandParser parser = new CommandParser(canvas);
		parser.start();
	}

}
