package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class SideMenu extends JPanel {
    private JButton tree;
    private JButton move;
    private JButton nextColor;
    public SideMenu(GameLogic logic) {
        this.tree = createButton(GameLogic.TREE_BUTTON_TEXT,logic);
        this.move = createButton(GameLogic.MOVE_BUTTON_TEXT,logic);
        this.nextColor = createButton(GameLogic.NEXT_COLOR_BUTTON_TEXT,logic);

        this.setLayout(new GridLayout(1,4));
        this.add(this.tree);
        this.add(this.move);
        this.add(this.nextColor);
        this.add(logic.getInfoLabel());
    }

    private JButton createButton(String text,GameLogic logic) {
        JButton button = new JButton(text);
        button.addActionListener(logic);
        button.addMouseListener(logic);
        button.setFocusable(false);
        return button;
    }
}
