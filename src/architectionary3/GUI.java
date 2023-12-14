package architectionary3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JLabel themeLabel;
    private static JTextField userText;
    private static JButton button;
    private static JLabel matches1;
    private JPanel panel1;

    public static void main(String[] args) {

        // Basic frame and panel setup
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // Setup for "Theme" prompt
        themeLabel = new JLabel("Theme");
        themeLabel.setBounds(10, 20, 80, 25);
        panel.add(themeLabel);

        // Setup for theme guessing searchbar
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Setup for "guess" button
        button = new JButton("Guess");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        // Setup for results printing
        matches1  = new JLabel("");
        matches1.setBounds(10, 110, 500, 200);
        panel.add(matches1);

        // Visibility setup
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // What happens when we click the "guess" button
        String guess = userText.getText();
        matches1.setText("");
        //Main.main(guess);
        String results = Main.getResults();
        matches1.setText(results);
    }
}
