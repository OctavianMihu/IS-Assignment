package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Faimoase extends JFrame {
    private JFrame frame;
    private JButton backButton;

    private Map<String, CityInfo> cityInfoMap;

    public Faimoase() {
        frame = new JFrame("Winter Cities");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);


        initCityInfo();

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Locatii faimoase", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.magenta);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(Color.magenta);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Color.magenta);
        mainPanel.add(backButton, BorderLayout.PAGE_END);

        String[] cities = {"Paris", "Rome", "New York", "Tokyo", "Barcelona", "Sydney"};

        for (String city : cities) {
            JButton button = new JButton(city);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(new Color(250, 200, 200));
            button.setForeground(Color.magenta);
            button.addActionListener(new CityButtonListener());
            buttonPanel.add(button);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.setVisible(false);
    }

    /*private void addActionListenerToBackButton() {
        backButton.addActionListener(e -> {
            frame.dispose();
        });
    }*/

    private void initCityInfo() {
        cityInfoMap = new HashMap<>();
        cityInfoMap = new HashMap<>();
        cityInfoMap.put("Paris", new CityInfo("Paris.jpg", "Beautiful city known for the Eiffel Tower.<br> Our offer: <br> * 4 Nights <br> * 2 Persons * All inclusive <br> * 4 star Hotel <br> * Total cost : 2500$"));
        cityInfoMap.put("Rome", new CityInfo("Rome.jpg", "Historic city with iconic landmarks like the Colosseum.<br> Our offer : <br> * 7 Nights <br> * Family of 4/5 <br> * 3 star Hotel <br> * Breakfast included <br> * Free tour of the city <br> *Total cost : 5000$ "));
        cityInfoMap.put("New York", new CityInfo("NewY.jpg", "The city that never sleeps, famous for its skyline. <br> Our offer : <br> * 4 Nights <br> * Close to the city center <br> * All inclusive <br> * Free tour of the Statue of liberty <br> * 5 star Hotel <br> Total cost : 7000$ "));
        cityInfoMap.put("Tokyo", new CityInfo("Tokyo.jpg", "Modern metropolis with a mix of traditional and futuristic elements. <br> Our offer: <br>  * All inclusive <br> * 5 Nights <br> * 2 Adults <br> * City tour with a guide <br> * 2 star Hotel <br> * Total cost : 6000$ "));
        cityInfoMap.put("Barcelona", new CityInfo("Barcelona.jpg", "Vibrant city known for its architecture and art. <br> Our offer : <br> * Family Pack <br> * 2 star Hotel <br> * 6 Nights <br> * Breakfast included <br> * Total cost : 900$"));
        cityInfoMap.put("Sydney", new CityInfo("Sydney.jpg", "Iconic city with landmarks like the Sydney Opera House. <br> Our offer : <br> * All inclusive <br> * 4 Nights <br> * 3 star Hotel close to the Opera <br> * Total cost :  1500$"));
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
                JOptionPane.showMessageDialog(Faimoase.this, "City information not available.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Faimoase());
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
    public JFrame getFrame() {
        return frame;
    }

    public void addBackButtonListener(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }
}

class CityDetails extends JFrame {
    private static final int IMAGE_WIDTH = 1000;
    private static final int IMAGE_HEIGHT = 600;

    public CityDetails(Faimoase.CityInfo cityInfo) {

        setTitle("City Details - " + cityInfo.getImagePath());
        setSize(800, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.setBackground(Color.magenta);

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
