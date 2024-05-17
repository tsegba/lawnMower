package kata.lawnmower.domain.model;

import kata.lawnmower.domain.enums.Command;
import kata.lawnmower.domain.enums.Orientation;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class MowerTest {

// Mower moves forward when facing North and position is not at the top edge of the lawn
    @Test
    public void test_mower_moves_forward_when_facing_north_and_position_is_not_at_top_edge_of_lawn() {
        // Arrange
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.N;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.moveForward(5, 5);

        // Assert
        assertEquals(new Position(0, 1), mower.getPosition());
    }

    // Mower turns left when facing North
    @Test
    public void test_mower_turns_left_when_facing_north() {
        // Arrange
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.N;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.turnLeft();

        // Assert
        assertEquals(Orientation.W, mower.getOrientation());
    }

    // Mower turns right when facing North
    @Test
    public void test_mower_turns_right_when_facing_north() {
        // Arrange
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.N;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.turnRight();

        // Assert
        assertEquals(Orientation.E, mower.getOrientation());
    }

    // Mower moves forward when facing East and position is not at the right edge of the lawn
    @Test
    public void test_mower_moves_forward_when_facing_east_and_position_is_not_at_right_edge_of_lawn() {
        // Arrange
        Position position = new Position(0, 0);
        Orientation orientation = Orientation.E;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.moveForward(5, 5);

        // Assert
        assertEquals(new Position(1, 0), mower.getPosition());
    }

    // Mower moves forward when facing South and position is not at the bottom edge of the lawn
    @Test
    public void test_mower_moves_forward_when_facing_south_and_position_is_not_at_bottom_edge_of_lawn() {
        // Arrange
        Position position = new Position(0, 1);
        Orientation orientation = Orientation.S;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.moveForward(5, 5);

        // Assert
        assertEquals(new Position(0, 0), mower.getPosition());
    }

    // Mower moves forward when facing West and position is not at the left edge of the lawn
    @Test
    public void test_mower_moves_forward_when_facing_west_and_position_is_not_at_left_edge_of_lawn() {
        // Arrange
        Position position = new Position(1, 0);
        Orientation orientation = Orientation.W;
        Queue<Command> commands = new LinkedList<>();
        Mower mower = new Mower(position, orientation, commands);

        // Act
        mower.moveForward(5, 5);

        // Assert
        assertEquals(new Position(0, 0), mower.getPosition());
    }

}