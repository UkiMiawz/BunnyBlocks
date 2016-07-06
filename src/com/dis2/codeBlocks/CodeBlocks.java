package com.dis2.codeBlocks;

import com.dis2.cards2.Card;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

class DragListener extends MouseInputAdapter {

    Point location;
    MouseEvent pressed;
    CodeBlocks cb;
    Card targetCard = null;
    Card selectedCard = null;

    DragListener(CodeBlocks cb) {
        this.cb = cb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        selectedCard = (Card) e.getComponent();
        cb.bringToFront(selectedCard);
        selectedCard.setSelectedState();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        selectedCard = (Card) e.getComponent();
        if (targetCard != null) {
            targetCard.setDefaultState();
            if (isInsideCard(selectedCard, targetCard)) {
                selectedCard.setDefaultState();
                targetCard.add(selectedCard);
            }
        }
        cb.fixSize();
    }

    public void mousePressed(MouseEvent me) {
        cb.bringToFront((Card) me.getComponent());
        pressed = me;
    }

    public void mouseDragged(MouseEvent me) {

        targetCard = null;
        selectedCard = (Card) me.getComponent();
        cb.bringToFront(selectedCard);
        selectedCard.setDragState();
        location = selectedCard.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        selectedCard.setLocation(x, y);
        solveCollitions();
    }

    

    public void solveCollitions() {
        ArrayList<Card> collitions = new ArrayList<Card>();
        for (Card card : cb.getCards()) {
            if (!selectedCard.equals(card)) {
                if (isInsideCard(selectedCard, card)) {
                    collitions.add(card);
                } else {
                    card.setDefaultState();
                }
            }
        }
        double distance = -1;
        for (Card card : collitions) {
            Point sP = getMidPoint(selectedCard);
            Point cP = getMidPoint(card);
            if (getDistanceBetweenPoints(sP, cP) < distance || distance == -1) {
                targetCard = card;
                distance = getDistanceBetweenPoints(sP, cP);
            }
        }
        if (targetCard != null) {
            for (Card card : cb.getCards()) {
                if (!targetCard.equals(card)) {
                    card.setDefaultState();
                } else {
                    card.setDropState();
                }
            }
        }
    }

    public Card findTargetCards(ArrayList<Card> cards) {
        int target = 0;
        double distance = -1;
        for (int i = 0; i > cards.size(); i++) {
            Point sP = getMidPoint(selectedCard);
            Point cP = getMidPoint((Card) cards.get(i));

            if (i == 0) {
                distance = getDistanceBetweenPoints(sP, cP);
                target = 0;
            } else if (getDistanceBetweenPoints(sP, cP) < distance) {
                target = i;
            }
        }
        return cards.get(target);
    }

    public double getDistanceBetweenPoints(Point p1, Point p2) {
        double a = Math.pow((p1.x - p2.x), 2);
        double b = Math.pow((p1.y - p2.y), 2);
        double c = Math.sqrt(a + b);
        return c;
    }

    public Point getMidPoint(Card card) {
        return new Point(card.getX() + card.getWidth() / 2, card.getY() + card.getHeight() / 2);
    }

    public boolean isInsideCard(Card selected, Card target) {
        if (selected.equals(target)) {
            return false;
        }
        int xt = target.getX();
        int yt = target.getY();
        int wt = target.getWidth();
        int ht = target.getHeight();
        int xs = selected.getX();
        int ys = selected.getY();
        int ws = selected.getWidth();
        int hs = selected.getHeight();
        if ((xs < xt + wt && xs + ws > xt && ys < yt + ht && ys + hs > yt)) {
            return true;
        } else {
            return false;
        }
    }

}

public class CodeBlocks extends JPanel {

    DataFlavor dataFlavor = new DataFlavor(Card.class,
            Card.class.getSimpleName());

    public CodeBlocks(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        new DropTargetPanel(this);
    }

    public ArrayList<Card> getCards() {
        ArrayList<Card> cds = new ArrayList<Card>();
        for (Component c : this.getComponents()) {
            cds.add((Card) c);
        }
        return cds;
    }

    public void addCard(Card card) {
        DragListener drag = new DragListener(this);
        card.addMouseListener(drag);
        card.addMouseMotionListener(drag);
        card.setDefaultState();
       Component temp = this.getComponentAt(card.getX(), card.getY());
        if(temp.getClass().getSimpleName().equals("CodeBlocks")){
            this.add(card);
            this.bringToFront(card);
        }else{
            ((Card)temp).add(card);
            this.fixSize(); 
        } 
    }

    public void bringToFront(Card card) {
        this.setComponentZOrder(card, 0);
        for (Card c : this.getCards()) {
            c.setDefaultState();
        }
    }
    
    public void fixSize() {
        for (Card card : this.getCards()) {
            int h = 30;
            int w = 0;
            if (card.getComponents().length > 1) {
                for (Component child : card.getComponents()) {
                    if (!(child.getClass().getName().equals("java.awt.Label"))) {
                        child.setLocation(15, h);
                        h += child.getHeight() + 20;
                        if (w < child.getWidth()) {
                            w += child.getWidth() + 20;
                        }
                    }
                    card.setBounds(card.getX(), card.getY(), w, h);
                    card.setDefaultState();
                }
            } else {
                card.setBounds(card.getX(), card.getY(), card.getDefaultWidth(), card.getDefaultHeight());
            }
        }
    }

    class DropTargetPanel extends DropTargetAdapter implements
            DropTargetListener {

        private DropTarget dropTarget;
        final CodeBlocks cb;

        public DropTargetPanel(final CodeBlocks cb) {
            this.cb = cb;
            dropTarget = new DropTarget(cb, DnDConstants.ACTION_COPY, this,
                    true, null);
        }

        public void drop(DropTargetDropEvent e) {
            try {
                Transferable tr = e.getTransferable();
                Card card = (Card) tr.getTransferData(dataFlavor);
                card.setLocation(e.getLocation());

                if (e.isDataFlavorSupported(dataFlavor)) {
                    e.acceptDrop(DnDConstants.ACTION_COPY);
                    e.dropComplete(true);
                    this.cb.validate();
                    this.cb.addCard(card); 
                    repaint();
                    return;
                }
                e.rejectDrop();
            } catch (Exception ex) {
                ex.printStackTrace();
                e.rejectDrop();
            }
        }
    }
}
