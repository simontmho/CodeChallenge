package org.simon.drawing.object;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.simon.drawing.command.BucketFillCmd;
import org.simon.drawing.command.CreateCmd;
import org.simon.drawing.command.DrawLineCmd;
import org.simon.drawing.command.DrawRectangleCmd;

public class TestCommand {

	private static final Logger logger = Logger.getLogger(TestCommand.class.getName());
	
	@Test
	public void testCreate() {
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 4);
		
		canvas.show();
		
		List<String> drawing = canvas.toStringArray();
		
		String[] expected = {
							"----------------------",
							"|                    |",
							"|                    |",
							"|                    |",
							"|                    |",
							"----------------------"							
							};	
		
		compare(drawing, expected);
	}
	
	
	@Test
	public void testDrawLine() {
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 4);
		
		DrawLineCmd.drawLine(canvas, 1, 2, 6, 2);
		
		canvas.show();
		
		List<String> drawing = canvas.toStringArray();
		
		String[] expected = {
							"----------------------",
							"|                    |",
							"|xxxxxx              |",
							"|                    |",
							"|                    |",
							"----------------------"							
							};	
		
		compare(drawing, expected);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDrawInvalidLine() {
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 10);
		
		DrawLineCmd.drawLine(canvas, 5, 5, 8, 9);
		
		canvas.show();
	}
	
	
	@Test
	public void testDrawRecentage() {
		
		logger.info("Draw recentage...");
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 4);
		
		DrawRectangleCmd.drawRecentage(canvas, 14, 1, 18, 3);
		
		canvas.show();
		
		List<String> drawing = canvas.toStringArray();
		
		String[] expected = {
							"----------------------",
							"|             xxxxx  |",
							"|             x   x  |",
							"|             xxxxx  |",
							"|                    |",
							"----------------------"							
							};	
		
		compare(drawing, expected);
	}
	
//	@Test
//	public void testBucketFill() {
//		
//		logger.info("Draw recentage...");
//		Canvas canvas = new Canvas();
//		
//		CreateCmd.createCanvas(canvas, 20, 10);
//		
//		BucketFillCmd.fillColor(canvas, 6, 6, '*');
//		
//		canvas.show();
//	}
	
	@Test
	public void testBucketFillInWithRecentangle() {
		
		logger.info("Draw recentage...");
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 4);
		
		DrawRectangleCmd.drawRecentage(canvas, 14, 1, 18, 3);
		
		BucketFillCmd.fillColor(canvas, 10, 3, 'o');
		
		canvas.show();
		
		List<String> drawing = canvas.toStringArray();
		
		String[] expected = {
							"----------------------",
							"|oooooooooooooxxxxxoo|",
							"|ooooooooooooox   xoo|",
							"|oooooooooooooxxxxxoo|",
							"|oooooooooooooooooooo|",
							"----------------------"						
							};	
		
		compare(drawing, expected);
	}
	
	@Test
	public void testBucketFillOutWithRecentangle() {
		
		logger.info("Draw recentage...");
		Canvas canvas = new Canvas();
		
		CreateCmd.createCanvas(canvas, 20, 10);
		
		DrawRectangleCmd.drawRecentage(canvas, 2, 8, 9, 3);
		
		BucketFillCmd.fillColor(canvas, 3, 2, '*');
		
		canvas.show();
	}
	
	private void compare(List<String> drawing, String[] expected)
	{
		int pos=0;
		for (String txt : drawing)
		{
			assertEquals("Drawing mismatch",expected[pos++], txt);
		}
	}
	
}
