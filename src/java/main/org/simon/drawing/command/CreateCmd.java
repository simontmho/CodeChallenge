package org.simon.drawing.command;

import org.simon.drawing.object.Canvas;

/**
 * This command create a canvas
 * Command 		Description
 * C w h           Should create a new canvas of width w and height h.
 * @author Simon
 *
 */
public class CreateCmd implements IDrawCommand {
	
	private CreateCmd() {}
	
	/**
	 * Create a canvas
	 * @param canvas
	 * @param width
	 * @param height
	 */
	public static void createCanvas(Canvas canvas, int width, int height)
	{
		canvas.create(width, height);
	}
}
