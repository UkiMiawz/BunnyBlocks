package com.dis2.codeBlocks;

import com.dis2.cards.cardWidget;
import com.dis2.cards.complexCard;
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
    complexCard targetCard = null;
    complexCard selectedCard = null;

    DragListener(CodeBlocks cb) {
        this.cb = cb;
    }

    @Override
    public void mouseClicked(MouseEvent e) { 
        selectedCard = (complexCard) e.getComponent();
        cb.bringToFront(selectedCard);
        selectedCard.setHighlight();
    }

    @Override
    public void mouseReleased(MouseEvent e) { 
        selectedCard = (complexCard) e.getComponent(); 
        if (targetCard != null) {
            targetCard.setDefaultState();
            if (isInsideCard(selectedCard, targetCard)
                    && (targetCard.getCardWidget().getCardType()) == 1
                    && (selectedCard.hasChildren() && selectedCard.getCardWidget().getCardType() == 1)
                    || selectedCard.getCardWidget().getCardType() != 1) { //only when card is type for (loop)
                
                
                System.out.println("Esta dentro del contenedor?: " +isInsideCard(selectedCard, targetCard));
                System.out.println("Target es tipo loop: "+ targetCard.getCardWidget().getCardType());
                System.out.println("Selected Card tiene hijos es de tipo loop: "+ (selectedCard.hasChildren() && selectedCard.getCardWidget().getCardType() == 1));
                System.out.println("Selected Card no es Lopp:" + selectedCard.getCardWidget().getCardType());
                
                selectedCard.setDefaultState();
                targetCard.addChild(selectedCard);
                targetCard.getCardWidget().setInStack(true);
                targetCard.repaint();
                cb.updateScroll();
                 
            } else {
                cb.bringToFront(selectedCard);
            }
            //just test of functio getCode
            //cb.getCode();

        } else {//if released card is out of container

            // fix size of the previos container
        }
        
        cb.repaint();
    }

    public boolean insertCard(complexCard selected, complexCard target) {
        if (isInsideCard(selected, target)
                && (target.getCardWidget().getCardType()) == 1
                && (selected.hasChildren() && selected.getCardWidget().getCardType() == 1)
                || selected.getCardWidget().getCardType() != 1) { //only when card is type for (loop)
            selected.setDefaultState();
            target.addChild(selected);
            target.getCardWidget().setInStack(true);
            target.repaint();
            return true;
        }
        return false;
    }

    public void mousePressed(MouseEvent me) {
        cb.bringToFront((complexCard) me.getComponent());
        pressed = me;
    }

    public void mouseDragged(MouseEvent me) { 
        selectedCard = (complexCard) me.getComponent();
        targetCard = null;
        cb.bringToFront(selectedCard);
        selectedCard.setHighlight();
        location = selectedCard.getLocation(location);
        int x = location.x - pressed.getX() + me.getX();
        int y = location.y - pressed.getY() + me.getY();
        
        if(x < 0){ 
            x= 0; 
        }
        if(y < 0){
            y=0; 
        }
        
        selectedCard.setLocation(x, y);
        cb.updateScroll();
        solveCollitions();
    }

    public void solveCollitions() {
        ArrayList<complexCard> collitions = new ArrayList<complexCard>();
        for (complexCard card : cb.getCards()) {

            if (!selectedCard.equals(card)) {
                if (isInsideCard(selectedCard, card)) {
                    collitions.add(card);
                } else {
                    card.setDefaultState();
                }
            }
        }
        double distance = -1;
        for (complexCard card : collitions) {
            Point sP = selectedCard.getMidPoint();
            Point cP = card.getMidPoint();
            if (getDistanceBetweenPoints(sP, cP) < distance || distance == -1) { 
                if(card.getCardWidget().getCardType()==1 
                        && (selectedCard.hasChildren()||selectedCard.getCardWidget().getCardType()!=1)){
                    targetCard = card;
                } 
                distance = getDistanceBetweenPoints(sP, cP);
            }
        }
        if (targetCard != null) {
            for (complexCard card : cb.getCards()) {
                if (!targetCard.equals(card)) {
                    card.setDefaultState();
                } else {
                    card.setHighlight();
                }
            }
        }
    }

    public complexCard findTargetCards(ArrayList<complexCard> cards) {
        int target = 0;
        double distance = -1;
        for (int i = 0; i > cards.size(); i++) {
            Point sP = selectedCard.getMidPoint();
            Point cP = cards.get(i).getMidPoint();
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

    public boolean isInsideCard(complexCard selected, complexCard target) {

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

    int originalH, originalW;
    DataFlavor dataFlavor = new DataFlavor(cardWidget.class,
            cardWidget.class.getSimpleName());

    public CodeBlocks(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        originalH = height;
        originalW = width;

        this.setLayout(null);
        new DropTargetPanel(this);
    }

    public ArrayList<complexCard> getCode() {
        ArrayList<complexCard> code = new ArrayList();
        if (this.getCards().size() == 1) {
            complexCard mainCard = new complexCard();
            mainCard.add(this.getCards().get(0).clone());
            code = this.buildTree(mainCard, 0);
            System.out.println("****");
            repaint();
        } else {
            System.out.println("In order to generate the code it must be only one super card Conteiners. now there are " + this.getCards().size() + " single Cards in the Code");
        }
        return code;
    }

    public ArrayList<complexCard> buildTree(complexCard card, int level) {
        ArrayList<complexCard> compList = new ArrayList();

        //loop-for only for print the card tree  
        String tap = "";
        for (int i = 0; i < level; i++) {
            tap += " ";
        }

        for (complexCard child : card.getChildren()) {
            System.out.println(tap + child.getCardWidget().getCardType());
            complexCard c = child;
            compList.add(c);
            if (c.hasChildren()) {
                compList.addAll(buildTree(c, level + 1));
            }
        }
        return compList;
    }

    public ArrayList<complexCard> getCards() {
        ArrayList<complexCard> children = new ArrayList<complexCard>();
        for (Component c : this.getComponents()) {
            if (c.getClass().getSimpleName().equals("complexCard")) {
                children.add((complexCard) c);
            }
        }
        return children;
    }

    public void addCard(complexCard c, Point OldPoint) {
        complexCard card = c.clone();
        DragListener drag = new DragListener(this);
        card.addMouseListener(drag);
        card.addMouseMotionListener(drag);
        card.setDefaultState();
        card.setDefaultBounds();
        Component temp = this.getComponentAt(card.getX(), card.getY());
        if (temp.getClass().getSimpleName().equals("CodeBlocks")) {
            card.setLocation(new Point(card.getX() - OldPoint.x, card.getY() - OldPoint.y));
            this.add(card);
            this.bringToFront(card); 
        } else if (((complexCard) temp).getCardWidget().getCardType() == 1
                && card.getCardWidget().getCardType() != 1) {
            ((complexCard) temp).getCardWidget().setInStack(true);
            ((complexCard) temp).addChild(card); 
        } else {
            card.setLocation(new Point(card.getX() - OldPoint.x, card.getY() - OldPoint.y));
            this.add(card);
            this.bringToFront(card); 
        } 
        updateScroll();
        card.repaint();
        repaint();
    }
    
     

    public void bringToFront(complexCard card) {
        this.setComponentZOrder(card, 0);
        for (complexCard c : this.getCards()) {
            c.setDefaultState();
        }
    }

    public void updateScroll() {
        int refH = this.getHeight();
        int refW = this.getWidth();
        for (complexCard c : this.getCards()) {
            int tempH = c.getBounds().y + c.getBounds().height;
            if (tempH > refH) {
                refH = tempH;
            } else {
                refH = originalH;
            }
        }

        for (complexCard c : this.getCards()) {
            int tempW = c.getBounds().x + c.getBounds().width;
            if (tempW > refW) {
                refW = tempW;
            } else {
                refW = originalW;
            }
        }
        this.setPreferredSize(new Dimension(refW, refH));
        this.revalidate(); 
    }

    class DropTargetPanel extends DropTargetAdapter implements DropTargetListener {

        private DropTarget dropTarget;
        final CodeBlocks cb;

        public DropTargetPanel(final CodeBlocks cb) {
            this.cb = cb;
            dropTarget = new DropTarget(cb, DnDConstants.ACTION_COPY, this,
                    true, null);
        }

        @Override
        public void drop(DropTargetDropEvent e) {

            try {
                Transferable tr = e.getTransferable();
                cardWidget card = ((cardWidget) tr.getTransferData(dataFlavor)).clone();

                if (e.isDataFlavorSupported(dataFlavor)) {
                    e.acceptDrop(DnDConstants.ACTION_COPY);
                    e.dropComplete(true);
                    this.cb.validate();
                    card.setSimpleCard(false);
                    Point oldcoordinates = new Point(card.getLocation());
                    card.setLocation(e.getLocation());
                    this.cb.addCard(new complexCard(card.clone()), oldcoordinates);

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
