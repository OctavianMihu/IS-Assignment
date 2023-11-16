package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Winter extends JFrame {

    private Map<String, CityInfo> cityInfoMap;

    public Winter() {
        setTitle("Winter Cities App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initCityInfo();

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Winter Cities", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.cyan);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.cyan);


        createCityButton("Austria", buttonPanel);
        createCityButton("Switzerland", buttonPanel);
        createCityButton("Canada", buttonPanel);
        createCityButton("Norway", buttonPanel);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(false);
    }

    private void initCityInfo() {
        cityInfoMap = new HashMap<>();
        cityInfoMap.put("Austria", new CityInfo("Austria.jpg", "Beautiful country known for winter resorts."));
        cityInfoMap.put("Switzerland", new CityInfo("Switzerland.jpg", "Scenic country famous for its ski resorts and landscapes."));
        cityInfoMap.put("Canada", new CityInfo("Canada.jpg", "Winter wonderland with stunning natural beauty."));
        cityInfoMap.put("Norway", new CityInfo("Norway.jpg", "Picturesque country with snowy landscapes and northern lights."));
    }

    private void createCityButton(String cityName, JPanel buttonPanel) {
        JButton button = new JButton(cityName);
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
}

class CityDetailsW extends JFrame {

    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 500;

    public CityDetailsW(Winter.CityInfo cityInfo) {
        setTitle("City Details - " + cityInfo.getImagePath());
        setSize(800, 500);
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
