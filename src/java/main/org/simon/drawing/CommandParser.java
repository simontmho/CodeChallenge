package org.simon.drawing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.simon.drawing.command.BucketFillCmd;
import org.simon.drawing.command.CreateCmd;
import org.simon.drawing.command.DrawLineCmd;
import org.simon.drawing.command.DrawRectangleCmd;
import org.simon.drawing.object.Canvas;

/**
 * this is the entrance point for command parser to accept command from user
 * and pass the command detail to appropriate commands for action
 * @author Simon
 *
 */
public class CommandParser {
	
	private Canvas canvas = null;
	
	public CommandParser(Canvas canvas)
	{
		this.canvas = canvas;
	}
	
	/**
	 * Entrance point
	 */
	public void start()
	{
		boolean isStop = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String command;
		
		System.out.println("Welcome to use Drawing Program...");
		
		while (! isStop)
		{
			try {
				System.out.print("enter command: ");
			
				command = reader.readLine();
				
				isStop = handle(command);
				
				canvas.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Thanks for using drawing");
	}
	
	private  boolean handle(String command)
	{
		boolean isStop = false;
		System.out.println("Command received..." + command);
		
		String[] commandArg = command.split(" ");
		
		if (commandArg.length == 0)
		{
			System.out.println("** Invalid command...");
		}
		else
		{
			switch (commandArg[0].toUpperCase())
			{
			case "C":
				System.out.println("Create command");
				CreateCmd.createCanvas(canvas, Integer.parseInt(commandArg[1]), Integer.parseInt(commandArg[2]));
				break;
			case "L":
				System.out.println("Line command");
				DrawLineCmd.drawLine(canvas, Integer.parseInt(commandArg[1]), Integer.parseInt(commandArg[2]), Integer.parseInt(commandArg[3]), Integer.parseInt(commandArg[4]));
				break;
			case "R":
				System.out.println("Recentangle command");
				DrawRectangleCmd.drawRecentage(canvas, Integer.parseInt(commandArg[1]), Integer.parseInt(commandArg[2]), Integer.parseInt(commandArg[3]), Integer.parseInt(commandArg[4]));
				break;
			case "B":
				System.out.println("Bucket fill command");
				BucketFillCmd.fillColor(canvas, Integer.parseInt(commandArg[1]),  Integer.parseInt(commandArg[2]), commandArg[3].charAt(0));
				break;
			case "Q":
				System.out.println("Quite command");
				isStop = true;
				break;
			default:
				System.out.println("** Invalid command...");
			}
		}
		
		return isStop;
	}
}
