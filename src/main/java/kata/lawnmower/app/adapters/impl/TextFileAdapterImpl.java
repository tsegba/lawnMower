package kata.lawnmower.app.adapters.impl;

import kata.lawnmower.app.adapters.TextFileAdapter;
import kata.lawnmower.app.parsers.CommandParser;
import kata.lawnmower.domain.enums.Orientation;
import kata.lawnmower.domain.model.Lawn;
import kata.lawnmower.domain.model.Mower;
import kata.lawnmower.domain.model.Position;
import kata.lawnmower.domain.service.LawnMowerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
public class TextFileAdapterImpl implements TextFileAdapter {

    private final LawnMowerService lawnMowerService;

    @Override
    public String moveMowers(InputStream input) throws Exception {

        List<String> inputString = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8))
                .lines().toList();
        log.info("Input : \n{}", String.join("\n", inputString));
        Lawn lawn = readLawn(inputString);
        Queue<Mower> mowers = readMowers(inputString);
        return lawnMowerService.moveMowers(lawn, mowers);
    }

    private Lawn readLawn(List<String> input) {
        final String[] inputParts = input.get(0).split(" ");
        final var width = Integer.parseInt(inputParts[0]);
        final var height = Integer.parseInt(inputParts[1]);
        return new Lawn(width, height);
    }


    private Queue<Mower> readMowers(List<String> input) {
        final var mowers = new LinkedList<Mower>();
        for (int i = 1; i < input.size(); i = i + 2) {
            final var initPosition = input.get(i).split(" ");
            final var position = new Position(Integer.parseInt(initPosition[0]), Integer.parseInt(initPosition[1]));
            final var actions = new CommandParser(input.get(i + 1)).getCommands();
            mowers.add(new Mower(
                    position,
                    Orientation.valueOf(initPosition[2]),
                    actions));
        }
        return mowers;
    }

}
