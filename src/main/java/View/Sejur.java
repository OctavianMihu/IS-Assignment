package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sejur extends JFrame{

    JFrame frame;
    JPanel panel;
    JPanel ButtonPanel;
    ButtonGroup oneWayTwoWayButtonGroup;
    JRadioButton oneWayRadioButton;
    JRadioButton twoWayRadioButton;

    JPanel datePanel;

    JPanel departureDatePanel;
    JPanel returnDatePanel;
    JLabel departureDateLabel;
    JTextField departureDateTextField;
    JLabel returnDateLabel;
    JTextField returnDateTextField;

    JPanel passengerPanel;

    JPanel panelback;
    JPanel adultPanel;
    JPanel childPanel;
    JPanel infantPanel;
    JLabel adultLabel;
    JLabel childLabel;
    JLabel infantLabel;

    JComboBox<Integer> adultComboBox;
    JComboBox<Integer> childComboBox;
    JComboBox<Integer> infantComboBox;

    JButton searchButton;
    JButton backButton;

    JPanel locatiiPanel;
    JPanel labelPanel;
    JLabel locatiiSejur;
    JPanel locationsPanel;
    JRadioButton sejurRadioButtonLocation1;
    JRadioButton sejurRadioButtonLocation2;
    JRadioButton sejurRadioButtonLocation3;
    JRadioButton sejurRadioButtonLocation4;

    ButtonGroup sejurRadioLocationGroup = new ButtonGroup();

    public Sejur() {
        frame = new JFrame("Flight Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 500));
        panel.setLayout(new GridLayout(5, 1, 10, 0));

        // Create the one-way/two-way flight radio buttons
        ButtonPanel = new JPanel();
        oneWayTwoWayButtonGroup = new ButtonGroup();
        oneWayRadioButton = new JRadioButton("One-way flight", true);
        oneWayTwoWayButtonGroup.add(oneWayRadioButton);
        twoWayRadioButton = new JRadioButton("Two-way flight");
        oneWayTwoWayButtonGroup.add(twoWayRadioButton);
        ButtonPanel.add(oneWayRadioButton);
        ButtonPanel.add(twoWayRadioButton);
        panel.add(ButtonPanel);


        // Create the text fields for the city of origin and city of destination

        locatiiPanel = new JPanel();
        locatiiPanel.setLayout(new GridLayout(2, 1, 10, 10));
        labelPanel = new JPanel();
        locatiiSejur = new JLabel("Locatii posibile");
        labelPanel.add(locatiiSejur);
        locatiiPanel.add(labelPanel);
        locationsPanel = new JPanel();
        locationsPanel.setLayout(new GridLayout(1,4,20,0));
        sejurRadioButtonLocation1 = new JRadioButton("Malta");
        sejurRadioButtonLocation2 = new JRadioButton("Turcia");
        sejurRadioButtonLocation3 = new JRadioButton("Franta");
        sejurRadioButtonLocation4 = new JRadioButton("Portugalia");
        sejurRadioLocationGroup = new ButtonGroup();
        sejurRadioLocationGroup.add(sejurRadioButtonLocation1);
        sejurRadioLocationGroup.add(sejurRadioButtonLocation2);
        sejurRadioLocationGroup.add(sejurRadioButtonLocation3);
        sejurRadioLocationGroup.add(sejurRadioButtonLocation4);
        locationsPanel.add(sejurRadioButtonLocation1);
        locationsPanel.add(sejurRadioButtonLocation2);
        locationsPanel.add(sejurRadioButtonLocation3);
        locationsPanel.add(sejurRadioButtonLocation4);
        locatiiPanel.add(locationsPanel);
        panel.add(locatiiPanel);


        /*flightPathPanel = new JPanel();
        cityOfOriginPanel = new JPanel();

        cityOfOriginTextField = new JTextField(20);
        cityOfDestinationTextField = new JTextField(20);

        // Create the labels for the text fields
        cityOfOriginLabel = new JLabel("City of origin:");
        cityOfDestinationLabel = new JLabel("City of destination:");

        // Add the labels and text fields to the panel
        cityOfOriginPanel.setLayout(new GridLayout(2, 1));
        cityOfOriginPanel.add(cityOfOriginLabel);
        cityOfOriginPanel.add(cityOfOriginTextField);
        flightPathPanel.setLayout(new FlowLayout());
        flightPathPanel.add(cityOfOriginPanel);

        cityOfDestinationPanel = new JPanel();
        cityOfDestinationPanel.setLayout(new GridLayout(2, 1));
        cityOfDestinationPanel.add(cityOfDestinationLabel);
        cityOfDestinationPanel.add(cityOfDestinationTextField);
        flightPathPanel.add(cityOfDestinationPanel);

        panel.add(flightPathPanel);*/

        datePanel = new JPanel();
        departureDatePanel = new JPanel();
        returnDatePanel = new JPanel();
        departureDateLabel = new JLabel("Departure date:");
        departureDateTextField = new JTextField(10);
        returnDateLabel = new JLabel("Return date:");
        returnDateTextField = new JTextField(10);
        datePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        departureDatePanel.setLayout(new GridLayout(2, 1));
        departureDatePanel.add(departureDateLabel);
        departureDatePanel.add(departureDateTextField);
        datePanel.add(departureDatePanel);
        returnDatePanel.setLayout(new GridLayout(2, 1));
        returnDatePanel.add(returnDateLabel);
        returnDatePanel.add(returnDateTextField);
        datePanel.add(returnDatePanel);
        //datePanel.setBackground(Color.BLUE);

        adultPanel = new JPanel();
        childPanel = new JPanel();
        infantPanel = new JPanel();
        Integer[] adults = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] children = {1, 2, 3, 4, 5, 6};
        Integer[] infants = {1, 2, 3, 4};
        adultComboBox = new JComboBox<Integer>(adults);
        childComboBox = new JComboBox<Integer>(children);
        infantComboBox = new JComboBox<Integer>(infants);
        adultLabel = new JLabel("Adults:");
        childLabel = new JLabel("Children:");
        infantLabel = new JLabel("Infants:");
        adultPanel.setLayout(new GridLayout(2, 1));
        adultPanel.add(adultLabel);
        adultPanel.add(adultComboBox);
        childPanel.setLayout(new GridLayout(2, 1));
        childPanel.add(childLabel);
        childPanel.add(childComboBox);
        infantPanel.setLayout(new GridLayout(2, 1));
        infantPanel.add(infantLabel);
        infantPanel.add(infantComboBox);
        passengerPanel = new JPanel();
        passengerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        passengerPanel.add(adultPanel);
        passengerPanel.add(childPanel);
        passengerPanel.add(infantPanel);
        searchButton = new JButton("Search Flight");
        passengerPanel.add(searchButton);
        panel.add(datePanel);
        panel.add(passengerPanel);

        panelback = new JPanel();
        backButton = new JButton("Back");
        panelback.add(backButton);
        panel.add(panelback);
        frame.add(panel);


        // Add the panel to the frame
        //panel.setBackground(Color.BLUE);
        frame.getContentPane().add(panel);

        // Size and display the frame
        frame.pack();
        frame.setVisible(false);
    }
    public void addSearchButtonActionListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }
    public void addBackButtonActionListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public static void main(String[] args) {
        Sejur sejur = new Sejur();
    }

    public Component getFrame() {
        return frame;
    }
}
