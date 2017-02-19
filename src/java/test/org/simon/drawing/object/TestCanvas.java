package org.simon.drawing.object;

import java.util.List;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCanvas {

	private static final Logger logger = Logger.getLogger(TestCanvas.class.getName());
	
	@Test
	public void testCreateRegularSize() {
		Canvas canvas = new Canvas();
		canvas.create(20, 4);
		logger.info("testCreateRegularSize passed");
		canvas.show();
		
		assertEquals("Width mismatch", 20, canvas.getCanvasWidth());
		assertEquals("Height mismatch", 4, canvas.getCanvasHeight());
		
		List<String> drawing = canvas.toStringArray();
		
		String[] expected = {
							"----------------------",
							"|                    |",
							"|                    |",
							"|                    |",
							"|                    |",
							"----------------------"							
							};	
		
		int pos=0;
		for (String txt : drawing)
		{
			assertEquals("Drawing mismatch",expected[pos++], txt);
		}
			
	}
	
	@Test
	public void testSetGet() {
		Canvas canvas = new Canvas();
		canvas.create(20, 4);
		
		canvas.setChar(2, 3, 'x');
		
		boolean res= canvas.isEmpty(2,3);
		
		assertEquals("Expected non-empty", false, res);
		
		res= canvas.isEmpty(2,4);
		
		assertEquals("Expected empty", true, res);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateExceeedMaxWidth() {
		
		Canvas canvas = new Canvas();
		canvas.create(1000, 150);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateExceeedMaxHeight() {
		
		Canvas canvas = new Canvas();
		canvas.create(150, 15000);
	}

}