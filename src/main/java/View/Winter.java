package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Winter extends JFrame {
    private JFrame frame;
    private JButton backButton;
    private SixButtons sixButtons;
    private Winter w;
    private Map<String, CityInfo> cityInfoMap;

    public Winter() {

        frame = new JFrame("Winter Cities");
        frame.setTitle("Winter Cities App");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);

        initCityInfo();

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Winter Cities", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.cyan);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.cyan);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Color.cyan);
        mainPanel.add(backButton, BorderLayout.PAGE_END);


        createCityButton("Austria", buttonPanel);
        createCityButton("Switzerland", buttonPanel);
        createCityButton("Canada", buttonPanel);
        createCityButton("Norway", buttonPanel);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.setVisible(false);

    }
    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

   /* private void addActionListenerToBackButton() {
        backButton.addActionListener(e -> {
            sixButtons.getFrame().setVisible(true);
            frame.dispose();
            frame.setVisible(false);
        });
    }*/

    private void initCityInfo() {
        cityInfoMap = new HashMap<>();
        cityInfoMap.put("Austria", new CityInfo("Austria.jpg", "Beautiful country known for winter resorts. <br> Our offer : <br> * 3 Nights <br> * 2 star Hotel <br> * Sky pass for all day <br> Total cost : 800$ "));
        cityInfoMap.put("Switzerland", new CityInfo("Switzerland.jpg", "Scenic country famous for its ski resorts and landscapes. <br> * All inclusive <br> * 4 Nights <br> * 5 star Hotel <br> * Spa and Pool pass included <br> Total cost : 6900$"));
        cityInfoMap.put("Canada", new CityInfo("Canada.jpg", "Winter wonderland with stunning natural beauty. <br> Our offer : <br> * 5 Nights <br> * 3 star Hotel <br> * Tour of the shy slopes <br> * Total cost : 3000$"));
        cityInfoMap.put("Norway", new CityInfo("Norway.jpg", "Picturesque country with snowy landscapes and northern lights. <br> Our offer : <br> * 5 Nights <br> * Alone cabin <br> * Guided walk on the nights with Aurora borealis <br> * Total cost : 4500$ "));
    }

    private void createCityButton(String cityName, JPanel buttonPanel) {
        JButton button = new JButton(cityName);
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(new Color(0, 150, 255));
        button.setForeground(Color.white);
        button.addActionListener(new CityButtonListener());
        buttonPanel.add(button);
    }

    private class CityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String cityName = sourceButton.getText();

            CityInfo cityInfo = cityInfoMap.get(cityName);
            if (cityInfo != null) {
                new CityDetailsW(cityInfo).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Winter.this, "City information not available.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Winter());
    }

    public static class CityInfo {
        private String imagePath;
        public String info; // Make info public

        public CityInfo(String imagePath, String info) {
            this.imagePath = imagePath;
            this.info = info;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getInfo() {
            return info;
        }
    }
    public JFrame getFrame() {
        return frame;
    }
}

class CityDetailsW extends JFrame {

    private static final int IMAGE_WIDTH = 1000;
    private static final int IMAGE_HEIGHT = 600;

    public CityDetailsW(Winter.CityInfo cityInfo) {
        setTitle("City Details - " + cityInfo.getImagePath());
        setSize(1000, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel contentPanel = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(cityInfo.getImagePath());
        Image image = imageIcon.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        contentPanel.add(imageLabel, BorderLayout.CENTER);

        JLabel label = new JLabel("Information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.cyan);


        JEditorPane infoEditorPane = new JEditorPane();
        infoEditorPane.setContentType("text/html"); // Set content type to HTML
        infoEditorPane.setText("<html><b><i>" + cityInfo.info + "</i></b></html>");
        infoEditorPane.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(infoEditorPane);
        contentPanel.add(scrollPane, BorderLayout.SOUTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Thank you for purchasing a trip to " + cityInfo.getImagePath());
        });
        mainPanel.add(purchaseButton, BorderLayout.PAGE_END);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);
    }
}
