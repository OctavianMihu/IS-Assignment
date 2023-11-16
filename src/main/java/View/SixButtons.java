package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SixButtons extends JFrame {
    JFrame frame;
    JPanel panel;
    JButton sejur;
    JButton cityBreak;
    JButton summer;
    JButton winter;
    JButton romania;
    JButton faimoase;


    public SixButtons() {
        frame = new JFrame("Three By Two Buttons With Space And Border");
        panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        sejur = new JButton("Sejur");
        panel.add(sejur);
        cityBreak = new JButton("City Break");
        panel.add(cityBreak);
        summer = new JButton("Summer");
        panel.add(summer);
        winter = new JButton("Winter");
        panel.add(winter);
        romania = new JButton("Romania");
        panel.add(romania);
        faimoase = new JButton("Faimoase");
        panel.add(faimoase);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(false);
    }

    public void addSejurButtonListener(ActionListener actionListener) {
        sejur.addActionListener(actionListener);
    }
    public void addCityBreakButtonListener(ActionListener actionListener) {
        cityBreak.addActionListener(actionListener);
    }
    public void addSummerButtonListener(ActionListener actionListener) {
        summer.addActionListener(actionListener);
    }
    public void addWinterButtonListener(ActionListener actionListener) {
        winter.addActionListener(actionListener);
    }
    public void addRomaniaButtonListener(ActionListener actionListener) {
        romania.addActionListener(actionListener);
    }
    public void addFaimoaseButtonListener(ActionListener actionListener) {
        faimoase.addActionListener(actionListener);
    }
    public JFrame getFrame() {
        return frame;
    }
}