package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import java.awt.*;

public enum Colors {
    GREEN(Color.GREEN,1),
    BLUE(Color.BLUE,2),
    RED(Color.RED,3);

    @Getter
    private int index;
    @Getter
    private Color color;

    private Colors(Color color,int index) {
        this.index = index;
        this.color = color;
    }
}
