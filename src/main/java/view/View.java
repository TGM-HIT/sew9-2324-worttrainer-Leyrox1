package view;

import model.Worttrainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class View {
    private Worttrainer worttrainer;
    public View(Worttrainer worttrainer) {
        this.worttrainer = worttrainer;

        JFrame frame = new JFrame("model.Worttrainer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        panel.add(imageLabel, BorderLayout.CENTER);

        JTextField input = new JTextField();
        panel.add(input, BorderLayout.NORTH);

        JButton enterButton = new JButton("Check");
        panel.add(enterButton, BorderLayout.EAST);

        JButton saveButton = new JButton("Save");
        panel.add(saveButton, BorderLayout.SOUTH);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredName = input.getText();
                worttrainer.check(enteredName);

                try {
                    URL imageUrl = new URL(worttrainer.getAktWort().getUrl()); // Replace with your image URL
                    ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageUrl));
                    imageLabel.setIcon(imageIcon);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform action when the Save button is clicked
                // Implement your save functionality here
                JOptionPane.showMessageDialog(frame, "Saved!");
            }
        });

        try {
            URL imageUrl = new URL(worttrainer.getAktWort().getUrl()); // Replace with your image URL
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageUrl));
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setSize(300, 300);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);

    }
}
