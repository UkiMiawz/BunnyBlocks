package com.dis2.menu;

import com.dis2.cards.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
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

    public void mousePressed(MouseEvent me) {
        pressed = me;
    }

    public void mouseDragged(MouseEvent me) {
        Component component = me.getComponent();
        location = component.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        component.setLocation(x, y);
    }
}

public class MenuWidget extends JPanel {

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel descGlobalLabel;
    private JPanel descGlobalCard;
    public ArrayList<cardWidget> cardContent;
    private JSplitPane container;
    private int selectedCard = 0;

    public MenuWidget(int width, int height) {
        descGlobalLabel = new JLabel();
        descGlobalCard = new JPanel();
        cardContent = new ArrayList<cardWidget>();
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

    public void addCard(cardWidget card) {
        cardContent.add(card);
        simpleCard simpC = new simpleCard(card);

        DragListener drag = new DragListener();
        simpC.addMouseListener(drag);
        simpC.addMouseMotionListener(drag);
        simpC.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedCard = cardContent.indexOf(card);
                updateCurrentCard(card);
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
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        topPanel.setPreferredSize(new Dimension(simpC.getHeight(), simpC.getHeight() * cardContent.size()));
        topPanel.add(simpC);
    }

    public JScrollPane setUpTopPanel() {
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
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

    private void updateCurrentCard(cardWidget card) {
        descGlobalLabel.setText(card.getText());
        simpleCard currentCard = new simpleCard(cardContent.get(selectedCard));
        descGlobalCard.removeAll();
        descGlobalCard.add(currentCard);
        container.setBottomComponent(setUpBottomPanel());
    }
}
