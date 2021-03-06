/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dis2.colorPicker;

import com.dis2.shared.Util;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
class Character {

    private Color color = Color.BLACK;
    private Image character = null;

    public Character(Color color, URL character) {
        this.color = color;
        this.character = new ImageIcon(character).getImage();
    }

    public Character(Color color, Image character) {
        this.color = color;
        this.character = character;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Image getCharacter() {
        return character;
    }

    public void setCharacter(Image character) {
        this.character = character;
    }

    public void setCharacter(String imgPath) {
        this.character = new ImageIcon(imgPath).getImage();
    }

    public int getCharacterHeight() {
        return this.character.getHeight(null);
    }

    public int getCharacterWidth() {
        return this.character.getWidth(null);
    }
}

public class WheelColor extends JPanel {

    private ArrayList<Character> characters = new ArrayList<Character>();
    private int wheelRadius = 50;
    private int selectedCharacter = 0;
    private Point coordinates = new Point(0, 0);

    private boolean characterClicked = false;

    public WheelColor(int width, int height) {

        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (isInsideCharecter(e.getPoint()) && !isInsideWheelColor(e.getPoint()) && !isTransparent(e.getPoint())) {
                    setCharacterClicked(true);
                    coordinates = e.getPoint();
                } else if (isInsideWheelColor(e.getPoint())) {
                    setCharacterClicked(true);
                    updateSelectedCharacter(e.getPoint());
                } else {
                    setCharacterClicked(false);
                }
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {

                if (isInsideCharecter(e.getPoint()) && !isInsideWheelColor(e.getPoint()) && !isTransparent(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else if (isInsideWheelColor(e.getPoint())) {
                    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }
        });
    }

    public boolean isTransparent(Point p) {
        p.x -= Util.getImagenCenterX(this, characters.get(selectedCharacter).getCharacter());
        p.y -= Util.getImagenCenterY(this, characters.get(selectedCharacter).getCharacter());
        if (Util.isPixelTransparent(characters.get(selectedCharacter).getCharacter(), p)) {
            return true;
        }
        return false;
    }

    public boolean isInsideCharecter(Point p) {
        int xIni = Util.getImagenCenterX(this, characters.get(selectedCharacter).getCharacter());
        int yIni = Util.getImagenCenterY(this, characters.get(selectedCharacter).getCharacter());
        int xEnd = xIni + characters.get(selectedCharacter).getCharacterWidth();
        int yEnd = yIni + characters.get(selectedCharacter).getCharacterHeight();
        if (p.x >= xIni && p.x <= xEnd && p.y >= yIni && p.y <= yEnd) {
            return true;
        }
        return false;
    }

    public void updateSelectedCharacter(Point p) {
        int auxCharacter = selectedCharacter;
        double angle = Math.atan2((double) (p.y - coordinates.y), (double) (p.x - coordinates.x));
        angle = (angle > 0 ? angle : (2 * Math.PI + angle)) * 360 / (2 * Math.PI);
        selectedCharacter = Math.abs(characters.size() - (int) Math.floor(angle / (360 / characters.size()))) - 1;
        selectedCharacter = (selectedCharacter == -1) ? auxCharacter : selectedCharacter;
    }

    public boolean isInsideWheelColor(Point p) {
        if (!isCharacterClicked()) {
            return false;
        }
        int distancesquared = (p.x - coordinates.x) * (p.x - coordinates.x) + (p.y - coordinates.y) * (p.y - coordinates.y);
        return distancesquared <= wheelRadius * wheelRadius;
    }

    public int getWheelRadius() {
        return wheelRadius;
    }

    public void setWheelRadius(int wheelRadius) {
        this.wheelRadius = wheelRadius;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public boolean isCharacterClicked() {
        return characterClicked;
    }

    public void setCharacterClicked(boolean characterClicked) {
        this.characterClicked = characterClicked;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Character c = characters.get(this.selectedCharacter);
        g.drawImage(c.getCharacter(),
                Util.getImagenCenterX(this, c.getCharacter()),
                Util.getImagenCenterY(this, c.getCharacter()), this);

        if (isCharacterClicked()) {
            int centerX = coordinates.x - this.wheelRadius;
            int centerY = coordinates.y - this.wheelRadius;
            g.setColor(Color.BLACK);
            g.fillOval(centerX - 2, centerY - 2, this.wheelRadius * 2 + 4, this.wheelRadius * 2 + 4);
            for (int i = 0; i < characters.size(); i++) {
                g.setColor(characters.get(i).getColor());
                g.fillArc(centerX, centerY, this.wheelRadius * 2, this.wheelRadius * 2, 360 / characters.size() * i, 360 / characters.size());
            }
        }
    }

}
