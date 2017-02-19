package org.simon.drawing.object;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class encapsulate a canvas for drawing.
 * @author Simon
 *
 */
public class Canvas {
	private static Logger logger = Logger.getLogger(Canvas.class.getName());
	
	private int canvasWidth;
	private int canvasHeight;
	
	private int fullCanvasWidth;
	private int fullCanvasHeight;
	
	private boolean isInit = false;
	
	private static final int MAX_WIDTH=200;
	private static final int MAX_HEIGHT=300;
	
	private char[][] canvas;		// (x,y)
	
	private static char EMPTY_CHAR = ' ';
	
	public Canvas() {
		
	}
	
	public void create(int width, int height) {
		
		isInit = true;
		
		logger.info("Canvas created");
		if (width > MAX_WIDTH) 
			throw new IllegalArgumentException("Width exceed limit " + MAX_WIDTH);
		if (height > MAX_HEIGHT) 
			throw new IllegalArgumentException("Height exceed limit " + MAX_HEIGHT);
		
		this.canvasWidth = width;			
		this.canvasHeight = height;		
		
		this.fullCanvasWidth = width+2;			
		this.fullCanvasHeight = height+2;			
		
		canvas = new char[fullCanvasWidth][fullCanvasHeight];	// scale size from internal size to full size (i.e. including border)
		
		init();
	}
	
	/*
	 * Init the canvas.. draw a border
	 */
	private void init()
	{
		
		for (int y = 0; y < fullCanvasHeight; y++)
		{
			for (int x=0; x < fullCanvasWidth; x++)
			{
				canvas[x][y] = EMPTY_CHAR;	
			}
			
		}
		
		for (int y = 0; y < fullCanvasHeight; y++)
		{
			if ((y == 0) || (y == (fullCanvasHeight-1)))
			{
				for (int x = 0; x < fullCanvasWidth ; x++)
				{	
					canvas[x][y] = '-';				
				}
			}
			else
			{
				canvas[0][y] = '|';	
				canvas[fullCanvasWidth-1][y] = '|';	
			}
		}
	}
	
	public int getWidth() {
		return canvasWidth;
	}
	public void setWidth(int width) {
		this.canvasWidth = width;
	}
	public int getHeight() {
		return canvasHeight;
	}
	public void setHeight(int height) {
		this.canvasHeight = height;
	}
	
	/**
	 * Fill by position starting from 1
	 * @param x
	 * @param y
	 * @param fillChar
	 */
	public void setChar(int x, int y,  char fillChar)
	{
		if ( (y <0) || (y > canvasHeight) )
			throw new IllegalArgumentException("Row " + y + " update out of boundary");
		
		if ( (x <0) || (x > canvasWidth) )
			throw new IllegalArgumentException("Col " + x+ " update out of boundary");
		
//		System.out.println("setChar - x: " + x + "\t y: " + y + "\tChar: " + fillChar);
		canvas[x][y] = fillChar;			
	}
	
	public boolean isEmpty(int x, int y)
	{
		return (canvas[x][y] == EMPTY_CHAR);
	}
	
	public int getCanvasWidth() {
		return canvasWidth;
	}

	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}

	/**
	 * Show the current carnvas
	 */
	public void show()
	{
		List<String> lines = toStringArray();
		
		for (String line : lines)
			System.out.println(line);
		
	}
	
	public List<String> toStringArray()
	{
		List<String> result = new LinkedList<>();
		StringBuffer sBuf = null;
		
		for (int y = 0; y < fullCanvasHeight; y++)
		{
			sBuf = new StringBuffer();
			for (int x = 0; x < fullCanvasWidth ; x++)
			{
				sBuf.append(canvas[x][y]);
			}
			result.add(sBuf.toString());
		}
		
		return result;
	}
}