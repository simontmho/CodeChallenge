package org.simon.drawing.command;

import org.simon.drawing.object.Canvas;

/**
 * Draw a recentangle 
 * R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
 *                 lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
 *                 using the 'x' character.
 * @author Simon
 *
 */
public class DrawRectangleCmd implements IDrawCommand {
	
	private DrawRectangleCmd() {}
	
	/*
	 * Draw a rectangle.
	 */
	public static void drawRecentage(Canvas canvas, int x1, int y1, int x2, int y2)
	{
		DrawLineCmd.drawLine(canvas, x1, y1, x1, y2);
		
		DrawLineCmd.drawLine(canvas, x1, y1, x2, y1);
		
		DrawLineCmd.drawLine(canvas, x1, y2, x2, y2);
		
		DrawLineCmd.drawLine(canvas, x2, y1, x2, y2);
		
	}
}
