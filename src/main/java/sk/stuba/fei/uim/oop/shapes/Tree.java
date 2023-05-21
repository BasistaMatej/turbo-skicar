package sk.stuba.fei.uim.oop.shapes;

import sk.stuba.fei.uim.oop.board.Colors;

import javax.swing.*;
import java.awt.*;

public class Tree extends JPanel {
    private Color color;

    public Tree(Color color) {
        this.color = color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(0, 0,this.getWidth(),this.getHeight()/3*2);
        int[] x = {(this.getWidth()/6*2),(this.getWidth()/6*2),this.getWidth()/6*4,this.getWidth()/6*4};
        int[] y = {this.getHeight(),this.getHeight()/5,getHeight()/5,this.getHeight()};
        g.fillPolygon(x,y,4);
        //g.drawRect(0,this.getHeight(),this.getWidth()/3,this.getHeight()/4*3);
    }
}
