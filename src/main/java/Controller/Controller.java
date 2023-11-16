package Controller;

import View.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller {
    private CityBreak cityBreak;
    private LogIn logIn;
    private Sejur sejur;
    private SixButtons sixButtons;
    private Summer summer;
    private Winter winter;


    public Controller() {
        cityBreak = new CityBreak();
        logIn = new LogIn();
        sejur = new Sejur();
        sixButtons = new SixButtons();
        summer = new Summer();
        winter = new Winter();

        logIn.logInButtonAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn.setVisible(false);
                sixButtons.getFrame().setVisible(true);
            }
        });

        sixButtons.addSejurButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                sejur.setVisible(true);
            }
        });
        sixButtons.addCityBreakButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                cityBreak.getFrame().setVisible(true);
            }
        });
        sixButtons.addSummerButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                summer.setVisible(true);
            }
        });
        sixButtons.addWinterButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                winter.setVisible(true);
            }
        });
        sixButtons.addRomaniaButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JPanel(), "Informatii despre vacante in Romania");
            }
        });
        sixButtons.addFaimoaseButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JPanel(), "Informatii despre vacante in locuri faimoase");
            }
        });
        cityBreak.addSearchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JPanel(), "Zboruri gasite in specificatiile respective");
            }
        });
    }
    /*private class CityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String cityName = sourceButton.getText();

            Sejur.CityInfo cityInfo = cityInfoMap.get(cityName);
            if (cityInfo != null) {
                new CityDetails(cityInfo).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Sejur.this, "City information not available.");
            }
        }
    }*/


    public static void main(String[] args) {
        Controller controller = new Controller();
    }

}
