package kata.lawnmower.domain.service.impl;

import kata.lawnmower.domain.enums.Command;
import kata.lawnmower.domain.exception.InvalidCommandException;
import kata.lawnmower.domain.model.Lawn;
import kata.lawnmower.domain.model.Mower;
import kata.lawnmower.domain.service.LawnMowerService;
import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Queue;

@Slf4j
@RequiredArgsConstructor
public class LawnMowerServiceImpl implements LawnMowerService {

    @Override
    public String moveMowers(Lawn lawn , Queue<Mower> mowers) {
        StringBuilder result = new StringBuilder();

        for (Mower mower : mowers) {
            move(mower, lawn.width(), lawn.height());
            log.debug(mower.getState());
            result.append("\n").append(mower.getState());
        }
        return  result.toString().trim();

    }

    @Synchronized
    private void move(Mower mower, int lawnWidth, int lawnHeight) {
        while (!mower.getCommands().isEmpty()) {
            Command currentCommand = mower.getCommands().poll();
            switch (currentCommand) {
                case A:
                    mower.moveForward(lawnWidth, lawnHeight);
                    break;
                case G:
                    mower.turnLeft();
                    break;
                case D:
                    mower.turnRight();
                    break;
                default:
                    throw new InvalidCommandException("Invalid instruction: ");
            }
        }
        mower.applyCheckState();
    }
}
