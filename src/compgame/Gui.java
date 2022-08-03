/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compgame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author keita
 */
public class Gui {

    private int count;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton gayButton;

    public Gui() {
        frame = new JFrame();
        panel = new JPanel();
        gayButton = new JButton("Click if gay");
        
        gayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                count++;
                System.out.println("gay" + count);
            }
        });
        
        label = new JLabel("Gay button");

        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(gayButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Comp Game GUI");
        frame.pack();
        frame.setVisible(true);
    }

}
