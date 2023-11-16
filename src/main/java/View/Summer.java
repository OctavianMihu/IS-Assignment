package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Summer extends JFrame {
    private Map<String, Summer.CityInfo> cityInfoMap;

    public Summer() {
        setTitle("Summer Cities App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        initCityInfo();

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Summer Cities", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.YELLOW);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(Color.yellow);


        createCityButton("Greece", buttonPanel);
        createCityButton("Italy", buttonPanel);
        createCityButton("Indonesia", buttonPanel);
        createCityButton("Maldives", buttonPanel);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(false);
    }

    private void initCityInfo() {
        cityInfoMap = new HashMap<>();
        cityInfoMap.put("Greece", new Summer.CityInfo("Greece.jpg", "Beautiful country known for summer resorts."));
        cityInfoMap.put("Italy", new Summer.CityInfo("Italy.jpg", "A picturesque coastline with charming villages, beautiful beaches, and delicious Italian cuisine."));
        cityInfoMap.put("Indonesia", new Summer.CityInfo("Indonesia.jpg", "A tropical paradise with lush landscapes, beautiful beaches, and diverse outdoor activities."));
        cityInfoMap.put("Maldives", new Summer.CityInfo("Maldives.jpg", "A tropical paradise with overwater bungalows, clear turquoise waters, and vibrant coral reefs."));
    }

    private void createCityButton(String cityName, JPanel buttonPanel) {
        JButton button = new JButton(cityName);
        button.addActionListener(new Summer.CityButtonListener());
        buttonPanel.add(button);
        Font buttonFont = button.getFont();
        Font boldFont = new Font(buttonFont.getName(), Font.BOLD, buttonFont.getSize() + 2);
        button.setFont(boldFont);
    }

    private class CityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String cityName = sourceButton.getText();

            Summer.CityInfo cityInfo = cityInfoMap.get(cityName);
            if (cityInfo != null) {
                new CityDetailsS(cityInfo).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Summer.this, "City information not available.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Summer());
    }

    public static class CityInfo {
        private String imagePath;
        public String info;

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

class CityDetailsS extends JFrame {

    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 500;

    public CityDetailsS(Summer.CityInfo cityInfo) {
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
        mainPanel.setBackground(Color.yellow);


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
