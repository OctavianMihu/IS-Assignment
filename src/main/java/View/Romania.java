package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Romania {
    private JFrame frame;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Romania Map");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel mapPanel = createRomaniaMap();
            frame.getContentPane().add(mapPanel);

            frame.setVisible(true);
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    private static JPanel createRomaniaMap() {
        JPanel mapPanel = new JPanel(new GridLayout(8, 8, 5, 5)); // Adjust rows and columns based on your preference

        String[] countyNames = {
                "Alba", "Arad", "Argeș", "Bacău", "Bihor", "Bistrița-Năsăud", "Botoșani", "Brăila",
                "Brașov", "Buzău", "Călărași", "Caraș-Severin", "Cluj", "Constanța", "Covasna", "Dâmbovița",
                "Dolj", "Galați", "Giurgiu", "Gorj", "Harghita", "Hunedoara", "Ialomița", "Iași",
                "Ilfov", "Maramureș", "Mehedinți", "Mureș", "Neamț", "Olt", "Prahova", "Sălaj",
                "Satu Mare", "Sibiu", "Suceava", "Teleorman", "Timiș", "Tulcea", "Vâlcea", "Vaslui",
                "Vrancea"
        };

        for (String county : countyNames) {
            JButton countyButton = new JButton(county);
            countyButton.addActionListener(new CountyButtonListener(county));
            mapPanel.add(countyButton);
        }

        return mapPanel;
    }

    private static class CountyButtonListener implements ActionListener {
        private String countyName;

        public CountyButtonListener(String countyName) {
            this.countyName = countyName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "You clicked on: " + countyName);
        }
    }
}

