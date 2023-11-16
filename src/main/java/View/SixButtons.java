package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SixButtons extends JFrame {

    private JFrame frame;
    private JButton sejur, cityBreak, summer, winter, romania, faimoase, back;


    public SixButtons() {
        frame = new JFrame("Six Buttons Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);


        JLabel labelT = new JLabel("Welcome pick your favorite : ", SwingConstants.CENTER);
        labelT.setFont(new Font("Arial", Font.BOLD, 20));
        labelT.setBackground(new Color(200, 238, 200));

        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        back = new JButton("Back");
        frame.add(back, BorderLayout.PAGE_END);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBackground(new Color(200, 238, 200));
        back.setForeground(Color.BLACK);

        sejur = new JButton("Sejur");
        sejur.setFont(new Font("Arial", Font.BOLD, 24));
        sejur.setBackground(new Color(144, 238, 144));
        panel.add(sejur);
        cityBreak = new JButton("City Break");
        cityBreak.setFont(new Font("Arial", Font.BOLD, 24));
        cityBreak.setBackground(new Color(144, 238, 144));
        panel.add(cityBreak);
        summer = new JButton("Summer");
        summer.setFont(new Font("Arial", Font.BOLD, 24));
        summer.setBackground(new Color(144, 238, 144));
        panel.add(summer);
        winter = new JButton("Winter");
        winter.setFont(new Font("Arial", Font.BOLD, 24));
        winter.setBackground(new Color(144, 238, 144));
        panel.add(winter);
        romania = new JButton("Romania");
        romania.setFont(new Font("Arial", Font.BOLD, 24));
        romania.setBackground(new Color(144, 238, 144));
        panel.add(romania);
        faimoase = new JButton("Faimoase");
        faimoase.setFont(new Font("Arial", Font.BOLD, 24));
        faimoase.setBackground(new Color(144, 238, 144));
        panel.add(faimoase);


       /* String[] buttonLabels = {"winter", "summer", "cityBreak", "famous", "Romania", "sejur"};
        for (
                String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 24));
            button.setBackground(new Color(144, 238, 144));
            button.setFocusPainted(false);
            panel.add(button);
            panel.setBackground(new Color(200, 238, 200));
        }*/

        frame.getContentPane().add(panel);
        frame.add(labelT, BorderLayout.PAGE_START);
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

    public void addBackButtonListener(ActionListener actionListener) {
        back.addActionListener(actionListener);
    }
    public JFrame getFrame() {
        return frame;
    }
}