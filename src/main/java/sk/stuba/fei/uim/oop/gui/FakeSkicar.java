package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;
import sk.stuba.fei.uim.oop.shapes.Tree;

import javax.swing.*;
import java.awt.*;

public class FakeSkicar {
    private static final int SCREEN_SIZE = 700;
    public FakeSkicar() {
        JFrame frame = new JFrame("TURBO SKICAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SCREEN_SIZE, SCREEN_SIZE);

        GameLogic logic = new GameLogic();
        frame.setLayout(new BorderLayout());

        frame.add(logic.getDrawingPanel(),BorderLayout.CENTER);
        frame.add(new SideMenu(logic),BorderLayout.PAGE_END);

        frame.setFocusable(true);
        frame.setVisible(true);
    }
}
