package kata.lawnmower.domain.service;

import kata.lawnmower.domain.model.Lawn;
import kata.lawnmower.domain.model.Mower;

import java.util.List;
import java.util.Queue;

public interface LawnMowerService {
    String moveMowers(Lawn lawn , Queue<Mower> mowers) ;
}
