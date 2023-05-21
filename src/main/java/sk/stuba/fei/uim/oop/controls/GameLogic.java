package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.ActionType;
import sk.stuba.fei.uim.oop.board.Colors;
import sk.stuba.fei.uim.oop.shapes.Tree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GameLogic extends UniversalAdapter {
    public static final String MOVE_BUTTON_TEXT = "Presun";
    public static final String TREE_BUTTON_TEXT = "Strom";
    public static final String NEXT_COLOR_BUTTON_TEXT = "Dalšia farba";
    @Getter
    private JLabel infoLabel;
    private ActionType action;
    private Colors activeColor;
    private boolean actionActive;
    @Getter
    private JPanel drawingPanel;
    private ArrayList<JPanel> shapes;
    private JPanel activeShape;

    public GameLogic() {
        this.shapes = new ArrayList<>();
        this.drawingPanel = new JPanel();
        this.drawingPanel.addMouseListener(this);
        this.drawingPanel.setLayout(null);

        this.actionActive = false;
        this.activeColor = Colors.GREEN;
        this.action = ActionType.MOVE;
        this.infoLabel = new JLabel(action.getButtonLabel());
        this.infoLabel.setFocusable(false);
    }
    
    private void nextColor() {
        if(this.activeColor.getIndex() > 2) {
            this.activeColor = Colors.GREEN;
        } else {
            this.activeColor = colorOnPossition(this.activeColor.getIndex()+1);
        }
    }
    
    private Colors colorOnPossition(int x) {
        return Arrays.stream(Colors.values()).filter(color -> color.getIndex() == x).findFirst().get();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton jButton = (JButton) e.getSource();
            switch (jButton.getText()) {
                case MOVE_BUTTON_TEXT:
                    this.action = ActionType.MOVE;
                    break;
                case TREE_BUTTON_TEXT:
                    this.action = ActionType.DRAW;
                    this.actionActive = true;
                    this.drawingPanel.repaint();
                    break;
                case NEXT_COLOR_BUTTON_TEXT:
                    nextColor();
                    break;
            }
            this.infoLabel.setText(action.getButtonLabel());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton jButton = (JButton) e.getSource();
            if (Objects.equals(jButton.getText(), TREE_BUTTON_TEXT)) {
                this.action = ActionType.DRAW;
                this.actionActive = true;
            }
            this.infoLabel.setText(action.getButtonLabel());
        } else if(action == ActionType.MOVE){
            this.actionActive = true;
            for (JPanel shape : this.shapes) {
                if( e.getX() >= shape.getX() && (e.getX()  <= shape.getX()+shape.getWidth()) &&
                    e.getY() >= shape.getY() && (e.getY() <= shape.getY()+shape.getHeight())) {
                    this.drawingPanel.remove(shape);
                    this.activeShape = shape;
                    return;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (action == ActionType.DRAW && this.actionActive) {
            JPanel shape = new Tree(activeColor.getColor());
            this.shapes.add(shape);
            shape.setBounds(e.getX()-50, e.getY()-50, 100, 100);
            this.drawingPanel.add(shape);
            this.drawingPanel.repaint();
            this.actionActive = false;
        } else if(this.actionActive && action == ActionType.MOVE) {
            this.activeShape.setBounds(e.getX()-50, e.getY()-50, 100, 100);
            this.drawingPanel.add(this.activeShape);
            this.drawingPanel.repaint();
            this.activeShape = null;
            this.actionActive = false;
        }
    }
}
