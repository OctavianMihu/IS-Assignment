package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Sejur extends JFrame {

    private Map<String, CityInfo> cityInfoMap;

    public Sejur() {
        setTitle("City Buttons App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);


        initCityInfo();

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Locatii faimoase", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.pink);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(Color.pink);

        String[] cities = {"Paris", "Rome", "New York", "Tokyo", "Barcelona", "Sydney"};

        for (String city : cities) {
            JButton button = new JButton(city);
            button.addActionListener(new CityButtonListener());
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(false);
    }

    private void initCityInfo() {
        cityInfoMap = new HashMap<>();
        cityInfoMap.put("Paris", new CityInfo("Paris.jpg", "Beautiful city known for the Eiffel Tower."));
        cityInfoMap.put("Rome", new CityInfo("Rome.jpg", "Historic city with iconic landmarks like the Colosseum."));
        cityInfoMap.put("New York", new CityInfo("NewY.jpg", "The city that never sleeps, famous for its skyline."));
        cityInfoMap.put("Tokyo", new CityInfo("Tokyo.jpg", "Modern metropolis with a mix of traditional and futuristic elements.\n Our offer: \n" +
                " *All inclusive \n * 5 Nights \n * 2 Adults \n * City tour with a guide. "));
        cityInfoMap.put("Barcelona", new CityInfo("Barcelona.jpg", "Vibrant city known for its architecture and art."));
        cityInfoMap.put("Sydney", new CityInfo("Sydney.jpg", "Iconic city with landmarks like the Sydney Opera House."));
    }

    private class CityButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            String cityName = sourceButton.getText();

            CityInfo cityInfo = cityInfoMap.get(cityName);
            if (cityInfo != null) {
                new CityDetails(cityInfo).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(Sejur.this, "City information not available.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sejur());
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

class CityDetails extends JFrame {
    private static final int IMAGE_WIDTH = 800;
    private static final int IMAGE_HEIGHT = 500;

    public CityDetails(Sejur.CityInfo cityInfo) {
        setTitle("City Details - " + cityInfo.getImagePath());
        setSize(800, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.pink);

        JPanel contentPanel = new JPanel(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon(cityInfo.getImagePath());
        Image image = imageIcon.getImage().getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        contentPanel.add(imageLabel, BorderLayout.CENTER);

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
