HI,

This Java project is the implementation by Simon Ho for CS Code Challenge on Drawing Program.

The kick start program on org.simon.drawing.CodeChallengeMain.

You can simply run it in Eclipse

The design is that.
1.	Main entrance point is CodeChallengeMain, which coordinate across components.
2.	CommandParser, to read command from console and route to appropriate drawing command.
3.	Canvas object encapsulate the canvas and provide necessary functions to write on canvas.
4.	Objects under org.simon.drawing.command provide commands for drawing.
a.	IDrawCommand – tagging interface
b.	CreateCmd – Create canvas command
c.	DrawLineCmd – Draw line
d.	DrawRecentageCmd – Draw rectangle.
e.	BucketFillCmd – Fill the drawing
5.	Unit test class
a.	TestCanvas – validate canvas related functions
b.	TestCommand – validate all drawing-related command/functions.

Rooms for improvements:
Some areas can be improved:
1.	CommandParser routing logic can refine more structural rather than a set of switch-case command.
2.	Command argument parsing not yet fine implemented. Invalid argument may cause RunTimeException and break the code.
3.	As of this moment, reasonable validation implemented to check command arguments. However, it may not fully. E.g. a negative argument for canvas will be input, which cause error.
