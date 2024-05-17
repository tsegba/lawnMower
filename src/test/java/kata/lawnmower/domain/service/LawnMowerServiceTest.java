package kata.lawnmower.domain.service;

import kata.lawnmower.domain.enums.Command;
import kata.lawnmower.domain.enums.Orientation;
import kata.lawnmower.domain.exception.InvalidCommandException;
import kata.lawnmower.domain.model.Lawn;
import kata.lawnmower.domain.model.Mower;
import kata.lawnmower.domain.model.Position;
import kata.lawnmower.domain.service.impl.LawnMowerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LawnMowerServiceTest {
    LawnMowerService lawnMowerService;

    @BeforeEach
    void initParameter() {
        lawnMowerService = new LawnMowerServiceImpl();
    }

    // should move all mowers according to their commands and return their final positions
    @Test
    void test_moveMowers() {
        // Arrange
        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower1 = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.A)));
        Mower mower2 = new Mower(new Position(3, 3), Orientation.E, new LinkedList<>(Arrays.asList(Command.A, Command.A, Command.D, Command.A, Command.A, Command.D, Command.A, Command.D, Command.D, Command.A)));
        mowers.add(mower1);
        mowers.add(mower2);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("1 3 N\n5 1 E", result);
    }

    // should handle multiple mowers with different commands and return their final positions
    @Test
    void test_multiple_mowers_with_different_commands() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower1 = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.A)));
        Mower mower2 = new Mower(new Position(3, 3), Orientation.E, new LinkedList<>(Arrays.asList(Command.A, Command.A, Command.D, Command.A, Command.A, Command.D, Command.A, Command.D, Command.D, Command.A)));
        mowers.add(mower1);
        mowers.add(mower2);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("1 3 N\n5 1 E", result);
    }

    // should handle multiple mowers with the same commands and return their final positions
    @Test
    void test_multiple_mowers_with_same_commands() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower1 = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.A, Command.A, Command.D)));
        Mower mower2 = new Mower(new Position(3, 3), Orientation.N, new LinkedList<>(Arrays.asList(Command.A, Command.A, Command.D)));
        mowers.add(mower1);
        mowers.add(mower2);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("1 4 E\n3 5 E", result);
    }

    // should handle a single mower with a single command and return its final position
    @Test
    void test_single_mower_with_single_command() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.A)));
        mowers.add(mower);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("1 3 N", result);
    }

    // should handle a single mower with multiple commands and return its final position
    @Test
    void test_single_mower_with_multiple_commands() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.G, Command.A, Command.A)));
        mowers.add(mower);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("1 3 N", result);
    }

    // should handle a mower with commands that make it go out of bounds and return its last valid position
    @Test
    void test_mower_go_out_of_bounds() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower = new Mower(new Position(3, 3), Orientation.E, new LinkedList<>(Arrays.asList(Command.A, Command.A, Command.D, Command.A, Command.A, Command.D, Command.A, Command.D, Command.D, Command.A)));
        mowers.add(mower);

        // Act
        String result = lawnMowerService.moveMowers(lawn, mowers);

        // Assert
        assertEquals("5 1 E", result);
    }

    // should handle a mower with invalid commands and throw an InvalidCommandException
    @Test
    void test_mower_with_invalid_commands() {
        // Arrange

        Lawn lawn = new Lawn(5, 5);
        Queue<Mower> mowers = new LinkedList<>();
        Mower mower = new Mower(new Position(1, 2), Orientation.N, new LinkedList<>(Arrays.asList(Command.G, Command.A, Command.valueOf("X")))); // Invalid command 'X'
        mowers.add(mower);

        // Act & Assert
        assertThrows(InvalidCommandException.class, () -> lawnMowerService.moveMowers(lawn, mowers));
    }
}
