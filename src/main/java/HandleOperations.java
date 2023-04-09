import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class HandleOperations{
    public boolean isTrue;
    public int count;
    RunTimer time = new RunTimer(isTrue, count);
    UserInputHandler userInputHandler = new UserInputHandler();
    public HandleOperations()
    {

    }

    public HandleOperations(boolean isTrue, int count) throws SQLException {
        this.isTrue = isTrue;
        this.count = count;
    }
    public void call_op(boolean isTrue, int count) throws SQLException, NoSuchAlgorithmException {
        while (!isTrue){
            String login = userInputHandler.getLogin();
            String pass = userInputHandler.getPassword();
            CheckInfo CheckInfo = new CheckInfo(login, pass);
            CheckFunct CheckFunctionality = new CheckFunct(login, pass);
            if(!CheckFunctionality.checklogin(login)){
                isTrue = false;
            }
            else{
                if(CheckFunctionality.checklength(pass)){
                }
                else {
                    if (CheckInfo.data_check()) {
                        isTrue = true;
                    } else {
                        count++;
                        time.timeRun(count);
                    }
                }
            }
        }
    }
}