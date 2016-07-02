package com.dis2.canvasExtended;

import javax.swing.JPanel;

import com.dis2.canvas.CanvasWidget;

import java.awt.Image;
import java.awt.Graphics;

/**
 * Created by woooowowowo.
 */
public class CanvasExtendedWidget extends JPanel {

    private CanvasWidget canvasWidget;
    private String logger = "Canvas Extended Widget: ";

    public CanvasExtendedWidget(Image backgroundImage) {
        System.out.println(logger + "Initiating extended canvas");
        canvasWidget = new CanvasWidget(backgroundImage);
        this.add(canvasWidget);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
