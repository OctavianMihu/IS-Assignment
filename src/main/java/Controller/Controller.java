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
    private Faimoase faimoase;
    private SixButtons sixButtons;
    private Summer summer;
    private Winter winter;
    private Romania romania;


    public Controller() {
        cityBreak = new CityBreak();
        logIn = new LogIn();
        sejur = new Sejur();
        faimoase = new Faimoase();
        sixButtons = new SixButtons();
        summer = new Summer();
        winter = new Winter();
        romania = new Romania();

        logIn.logInButtonAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn.setVisible(false);
                sixButtons.getFrame().setVisible(true);
            }
        });

        sejur.addBackButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sejur.getFrame().setVisible(false);
                sixButtons.getFrame().setVisible(true);
            }
        });
        sejur.addSearchButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(new JPanel(), "Zboruri gasite in specificatiile respective");
            }
        });

        sixButtons.addRomaniaButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                romania.getFrame().setVisible(true);
            }
        });

        sixButtons.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().dispose();
                logIn.setVisible(true);
            }
        });

        sixButtons.addSejurButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sixButtons.getFrame().setVisible(false);
                sejur.getFrame().setVisible(true);
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
                summer.getFrame().setVisible(true);
            }
        });
        sixButtons.addWinterButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               sixButtons.getFrame().setVisible(false);
                winter.getFrame().setVisible(true);
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
                sixButtons.getFrame().setVisible(false);
                faimoase.getFrame().setVisible(true);
            }
        });
        cityBreak.addSearchButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(new JPanel(), "Zboruri gasite in specificatiile respective");
            }
        });

        cityBreak.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cityBreak.getFrame().dispose();
                sixButtons.getFrame().setVisible(true);
            }
        });
        winter.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                winter.getFrame().dispose();
                sixButtons.getFrame().setVisible(true);
            }
        });

        summer.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                summer.getFrame().dispose();
                sixButtons.getFrame().setVisible(true);
            }
        });

        faimoase.addBackButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                faimoase.getFrame().dispose();
                sixButtons.getFrame().setVisible(true);
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
