import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.Scanner;

public class LoginInterface extends JDialog{
    private JFrame frame;
    private JPanel LoginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signInButton;
    Telegram bot = new Telegram();

    public LoginInterface(JFrame parent){
        super(parent);
        setTitle("Authorization");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(450, 430));
        setModal(true);
        setLocationRelativeTo(parent);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    handlelogin();
                } catch (SQLException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        setVisible(true);
    }

    private void handlelogin() throws SQLException, NoSuchAlgorithmException, InterruptedException {
        String login = textField1.getText();
        String pass = new String(passwordField1.getPassword());
        CheckInfo CheckInfo = new CheckInfo(login, pass);
        CheckFunct CheckFunct = new CheckFunct(login, pass);
        if (!CheckFunct.checklogin(login)) {
            JOptionPane.showMessageDialog(frame, "Login must contain uppercase and lowercase letter, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            String text = "The user entered the wrong login without capital letters.";
            SendMessage message = new SendMessage("682958008", text);
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (CheckFunct.checklength(pass)) {
            JOptionPane.showMessageDialog(frame, "Password must be at least 6, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            String text = "The user entered a password of short length";
            SendMessage message = new SendMessage("682958008", text);
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (CheckInfo.data_check()) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
            String text = "User successfully authorized!";
            SendMessage message = new SendMessage("682958008", text);
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid data, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            String text = "User entered incorrect data.";
            SendMessage message = new SendMessage("682958008", text);
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args){
        LoginInterface myGUI = new LoginInterface(null);

    }
}
