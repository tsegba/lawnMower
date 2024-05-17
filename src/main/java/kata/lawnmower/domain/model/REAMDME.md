
### Summary
The Mower class represents a lawn mower in a lawn mowing system. It contains methods to move the mower forward, turn it left or right, and get its current state.
>Example Usage
>>// Create a new mower with initial position (0, 0), orientation N, and a list of commands
Mower mower = new Mower(new Position(0, 0), Orientation.N, List.of(Command.A, Command.G, Command.D));

>>// Move the mower forward in the lawn with width 5 and height 5
mower.moveForward(5, 5);

>>// Turn the mower left
mower.turnLeft();

>>// Turn the mower right
>>mower.turnRight();

>>// Get the current state of the mower
String state = mower.getState();

>>// Apply the current state as the checked state
mower.applyCheckState();

### Methods
> * moveForward(int lawnWidth, int lawnHeight): Moves the mower forward in the lawn based on its current orientation. The lawn width and height are provided as parameters to ensure the mower stays within the bounds of the lawn. 
> * turnLeft(): Turns the mower 90 degrees to the left. 
> * turnRight(): Turns the mower 90 degrees to the right. 
> * getState(): Returns a string representation of the current state of the mower, including its position and orientation. 
> * applyCheckState(): Sets the current state of the mower as the checked state.

### Fields
>* position: The current position of the mower.
>* orientation: The current orientation of the mower.
>* commands: A list of commands to be executed by the mower.
>* checkedState: The checked state of the mower, which is used for comparison or validation purposes.
 