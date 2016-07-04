package com.dis2.menuWidget;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.MouseInputAdapter;

class DragListener extends MouseInputAdapter {

    Point location;
    MouseEvent pressed;
    MenuWidget mw;
    JPanel itemCollided = new JPanel();
    Component targetComponet = new JPanel();
    Component selectedComponent = new JPanel();

    DragListener(MenuWidget mw) {
        this.mw = mw;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (JPanel panel : mw.getCards()) {  
            if(panel== targetComponet && isInsideComponet(selectedComponent.getX(),selectedComponent.getY(),panel)){
                panel.setBounds(panel.getX(),panel.getY(),
                        (int)panel.getBounds().getWidth(),
                        (int)panel.getBounds().getHeight()+ 100);
            }else{
                
            }
        }
      
    }

    public void mousePressed(MouseEvent me) {
        pressed = me;
    }

    public void mouseDragged(MouseEvent me) {
        selectedComponent = me.getComponent();
        location = selectedComponent.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();

        selectedComponent.setLocation(x, y);

        for (JPanel panel : mw.getCards()) {
            if(isInsideComponet(x,y,panel)){
                targetComponet = panel;
                panel.setBackground(Color.black);
            }else{ 
                panel.setBackground(Color.red);
            }
        }

    }

    public boolean isInsideComponet(int x, int y, JPanel panel) {
        int xPos = (int) panel.getBounds().getX();
        int yPos = (int) panel.getBounds().getY();
        int w = (int) panel.getBounds().getWidth();
        int h = (int) panel.getBounds().getHeight();

        if (x > xPos && x < xPos + w && y > yPos && y < yPos + h) {
            return true;
        } else {
            return false;
        }
    }
}

public class MenuWidget extends JPanel {

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel descGlobalLabel;
    private JPanel descGlobalCard;
    public ArrayList<JPanel> cardContent;
    private JSplitPane container;
    private int selectedCard = 0;

    public MenuWidget(int width, int height) {
        descGlobalLabel = new JLabel();
        descGlobalCard = new JPanel();
        cardContent = new ArrayList<JPanel>();
        bottomPanel = new JPanel();
        topPanel = new JPanel();
        container = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                setUpTopPanel(), setUpBottomPanel());
        container.setOneTouchExpandable(true);
        container.setDividerLocation(300);
        container.setResizeWeight(.5d);
        this.setLayout(new BorderLayout());
        this.add(container);
        this.setPreferredSize(new Dimension(width, height));
    }

    public void addCard(JPanel card) {
        cardContent.add(card);

        DragListener drag = new DragListener(this);
        card.addMouseListener(drag);
        card.addMouseMotionListener(drag);

        topPanel.setLayout(null);;
        topPanel.setPreferredSize(new Dimension(card.getHeight(), card.getHeight() * cardContent.size()));
        topPanel.add(card);
    }

    public ArrayList<JPanel> getCards() {
        return this.cardContent;
    }

    public JScrollPane setUpTopPanel() {
        JScrollPane scrollPane = new JScrollPane(topPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private JScrollPane setUpBottomPanel() {
        bottomPanel.setPreferredSize(new Dimension(240, 300));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bottomPanel.add(descGlobalCard);
        bottomPanel.add(descGlobalLabel);
        JScrollPane scrollPane = new JScrollPane(bottomPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private void updateCurrentCard(JPanel card) {
        //descGlobalLabel.setText(card.getBounds().getCenterX()); 
        descGlobalCard.removeAll();
        container.setBottomComponent(setUpBottomPanel());
    }
}
