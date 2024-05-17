package kata.lawnmower.domain.model;

import kata.lawnmower.domain.enums.Command;
import kata.lawnmower.domain.enums.Orientation;
import kata.lawnmower.domain.exception.InvalidOrientationException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.util.Queue;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class Mower {
    @NonNull
    private Position position;
    @NonNull
    private Orientation orientation;
    private final Queue<Command> commands;
    private MowerState checkedState;

    public void moveForward(int lawnWidth, int lawnHeight) {
        switch (orientation) {
            case N:
                if (position.y() < lawnHeight) position = new Position(position.x(),position.y()+1);
                break;
            case E:
                if (position.x() < lawnWidth) position = new Position(position.x()+1,position.y());
                break;
            case S:
                if (position.y() > 0) position = new Position(position.x(),position.y()-1);
                break;
            case W:
                if (position.x() > 0) position = new Position(position.x()-1,position.y());
                break;
            default:
                throw new InvalidOrientationException("Invalid orientation: " + orientation);
        }
    }
    public void turnLeft() {
        switch (orientation) {
            case N:
                orientation = Orientation.W;
                break;
            case E:
                orientation = Orientation.N;
                break;
            case S:
                orientation = Orientation.E;
                break;
            case W:
                orientation = Orientation.S;
                break;
            default:
                throw new InvalidOrientationException("Invalid  value for orientation: " + orientation);
        }
    }

    public void turnRight() {
        switch (orientation) {
            case N:
                orientation = Orientation.E;
                break;
            case E:
                orientation = Orientation.S;
                break;
            case S:
                orientation = Orientation.W;
                break;
            case W:
                orientation = Orientation.N;
                break;
            default:
                throw new InvalidOrientationException("Invalid value for orientation: " + orientation);
        }
    }

    public String getState(){
        return String.format("%d %d %s",getCheckedState().position().x() , getCheckedState().position().y(),getCheckedState().orientation().name());
    }
    public void applyCheckState(){
        this.checkedState = new MowerState(position,orientation);
    }
}
