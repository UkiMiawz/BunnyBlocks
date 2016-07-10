package com.dis2.menuWidget;
 
import com.dis2.cards2.Card; 
import java.awt.BorderLayout; 
import java.awt.Cursor; 
import java.awt.Dimension;
import java.awt.FlowLayout;  
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource; 
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;  

public class MenuWidget extends JPanel {

    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel descGlobalLabel;
    private JPanel descGlobalCard;
    public ArrayList<JPanel> cardContent;
    private JSplitPane container;
    private int selectedCard = 0; 
    
    DataFlavor dataFlavor = new DataFlavor(Card.class,
            Card.class.getSimpleName());

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
        this.dataFlavor = dataFlavor;
    }

    public void addCard(JPanel card) {
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS)); 
        topPanel.setPreferredSize(new Dimension(card.getHeight(), card.getHeight() * cardContent.size()));
        topPanel.add(card);
        cardContent.add(card);  
         DragSource ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(card,
                DnDConstants.ACTION_COPY, new DragGesture());
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
    
    class DragGesture implements DragGestureListener { 
        @Override
        public void dragGestureRecognized(DragGestureEvent event) {
            Cursor cursor = null;
            Card card = (Card) event.getComponent(); 
            if (event.getDragAction() == DnDConstants.ACTION_COPY) {
                cursor = DragSource.DefaultCopyDrop;
            } 
            event.startDrag(cursor, new MenuWidget.TransferableCard(card));
        }
    }
    
    class TransferableCard implements Transferable {

        private Card card;

        public TransferableCard(Card card) {
            this.card = card;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{dataFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(dataFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor)
                throws UnsupportedFlavorException, IOException { 
            if (flavor.equals(dataFlavor)) {
                return card;
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
        }
    }
    
}