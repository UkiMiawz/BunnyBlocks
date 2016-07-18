package com.dis2.shared;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.Border;

public class CustomDialog extends JDialog {

    private JButton okBtn = new JButton();
    private JLabel messageLbl = new JLabel("This is a message");
    private ComponentMover cm = new ComponentMover();

    public CustomDialog(String message, ImageIcon icon) {

        super(new JFrame(), true);
        cm.registerComponent(this);

        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        contentPanel.setBorder(padding);

        setUndecorated(true);
        contentPanel.setLayout(new BorderLayout());

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messageLbl.setText(message);
        messageLbl.setFont(new Font("ArialBlack", Font.PLAIN, 18));
        messageLbl.setBorder(padding);
        messagePanel.add(messageLbl, BorderLayout.CENTER);

        okBtn.addActionListener(new Close());
        URL urlCheck = CustomDialog.class.getResource(
                "/resources/check.png");
        ImageIcon iconCheck = new ImageIcon(urlCheck);
        okBtn.setIcon(iconCheck);
        okBtn.setFocusPainted(false);

        JLabel picLabel = new JLabel(icon);
        picLabel.setBorder(padding);

        contentPanel.add(messagePanel, BorderLayout.CENTER);
        contentPanel.add(okBtn, BorderLayout.SOUTH);
        contentPanel.add(picLabel, BorderLayout.WEST);

        setContentPane(contentPanel);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class Close implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

}