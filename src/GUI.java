// Program: GUI.java
// author: T-Kalv
// email:
// student number:

/*
A GUI Time Machine Java program that opens a website from the past using the Wayback Machine where the user enters the website URL, date and time
*/
//
// Time Machine GUI Program
//
////////////////////////////////////////////////////////////////////////////////////////////////////////
// Libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

////////////////////////////////////////////////////////////////////////////////////////////////////////
//Code
public class GUI implements ActionListener {
    private static JLabel websiteURLLabel;
    private static JTextField websiteURLText;
    private static JLabel dateLabel;
    private static JPasswordField dateText;
    private static JLabel timeLabel;
    private static JPasswordField timeText;
    private static JButton button;
    private static JLabel success;

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("\uD83D\uDD70\uFE0F Time Machine");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        websiteURLLabel = new JLabel("Enter Website URL: ");
        websiteURLLabel.setBounds(10, 20, 150, 25);
        panel.add(websiteURLLabel);

        websiteURLText = new JTextField();
        websiteURLText.setBounds(150, 20, 165, 25);
        panel.add(websiteURLText);

        dateLabel = new JLabel("Enter Date (YYYYMMDD): ");
        dateLabel.setBounds(10, 50, 150, 25);
        panel.add(dateLabel);

        dateText = new JPasswordField();
        dateText.setBounds(150, 50, 165, 25);
        panel.add(dateText);

        timeLabel = new JLabel("Enter Time (hhmmss): ");
        timeLabel.setBounds(10, 80, 150, 25);
        panel.add(timeLabel);

        timeText = new JPasswordField();
        timeText.setBounds(150, 80, 165, 25);
        panel.add(timeText);

        button = new JButton("Activate Time Machine!");
        button.setBounds(10, 110, 200, 25);
        button.addActionListener(new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 140, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String websiteURL = websiteURLText.getText();
        String date = new String(dateText.getPassword());
        String time = new String(timeText.getPassword());
        System.out.println(websiteURL + ", " + date + ", " + time);
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                URI url = new URI("https://web.archive.org/web/" + date + time + "/" + websiteURL);
                desktop.browse(url);
                success.setText("Travelling Back In Time...");
            } catch (URISyntaxException ex) {
                success.setText("Invalid URL Format!");
            } catch (IOException ex) {
                success.setText("No Internet Connection!");
            }
        } else {
            success.setText("Current Desktop Platform Not Supported!");
        }
    }

    public void createGUI() {

    }
}
