import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        UserLogin frame = new UserLogin();
        frame.setVisible(true);
//        LoginGUI gui = new LoginGUI();
//        gui.createUI();
        int count = 0;
        int signal = 0;
        boolean isTrue = false;
        RunTimer time = new RunTimer(isTrue, count);
        HandleOperations main_op = new HandleOperations(isTrue, count);
        main_op.call_op(isTrue, count);

    }
}