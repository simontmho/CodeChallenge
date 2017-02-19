package org.simon.drawing.command;

import org.simon.drawing.object.Canvas;

/**
 * This class implement the bucket fill logic.
 * Command 		Description
 * B x y c      Should fill the entire area connected to (x,y) with "colour" c. The
 *              behaviour of this is the same as that of the "bucket fill" tool in paint
 *              programs.
 * @author Simon
 *
 */
public class BucketFillCmd implements IDrawCommand{
	
	private BucketFillCmd() {}
	
	/**
	 * This function fill canvas with provided color until it hit a boundary or another drawings
	 * @param canvas
	 * @param x
	 * @param y
	 * @param color
	 */
	public static void fillColor(Canvas canvas, int x, int y, char color)
	{
		if ( canvas.isEmpty(x, y))
		{
			// current spot is NOT empty.
			// 1. Fill current spot
			// 2. Extend to all surrounding cell on recursive basis
			canvas.setChar(x, y, color);
			
			if (x > 0)
				BucketFillCmd.fillColor(canvas, x-1, y, color);
			
			if (x < (canvas.getCanvasWidth()))
				BucketFillCmd.fillColor(canvas, x+1, y, color);
			
			if (y > 0)
				BucketFillCmd.fillColor(canvas, x, y-1, color);
			
			if (y < (canvas.getCanvasHeight()))
				BucketFillCmd.fillColor(canvas, x, y+1, color);		
		}
	}
}
