package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

public enum ActionType {
    DRAW("KRESLENIE"),
    MOVE("PRESUVANIE");

    @Getter
    private String buttonLabel;

    private ActionType(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }
}
