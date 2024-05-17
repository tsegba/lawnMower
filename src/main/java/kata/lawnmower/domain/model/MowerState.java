package kata.lawnmower.domain.model;

import kata.lawnmower.domain.enums.Orientation;

public record MowerState(Position position, Orientation orientation) {
}
