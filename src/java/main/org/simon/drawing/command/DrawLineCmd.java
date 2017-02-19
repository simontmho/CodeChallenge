package org.simon.drawing.command;

import org.simon.drawing.object.Canvas;

/**
 * Draw line command
 * Command 		Description
 * L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
 *                 horizontal or vertical lines are supported. Horizontal and vertical lines
 *                 will be drawn using the 'x' character.
 * @author Simon
 *
 */
public class DrawLineCmd implements IDrawCommand {
	
	private DrawLineCmd() {}
	
	private static final char FILL_CHAR = 'x';
	
	/**
	 * Draw a line in the provided dimension
	 * @param canvas
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	public static void drawLine(Canvas canvas, int x1, int y1, int x2, int y2)
	{
		if ( (x1 != x2) && (y1 != y2))
			throw new IllegalArgumentException("Currently only horizontal or vertical lines are supported.");
		
		int startPos;
		int endPos;
		// for drawing vertical line
		if (x1 == x2)
		{
			if (y1 < y2)
			{
				startPos = y1;
				endPos = y2;
			}
			else
			{
				startPos = y2;
				endPos = y1;
			}
			
			for (int pos=startPos; pos<= endPos; pos++)
				canvas.setChar(x1, pos, FILL_CHAR);
		}
		
		// for drawing horizontal line
		if (y1 == y2)
		{
			if (x1 < x2)
			{
				startPos = x1;
				endPos = x2;
			}
			else
			{
				startPos = x2;
				endPos = x1;
			}
			for (int pos=startPos; pos<= endPos; pos++)
				canvas.setChar(pos, y1, FILL_CHAR);
		}
	}
}
