import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckInfo extends Private_Info{
    PasswordChecker checker = new PasswordChecker();

    public CheckInfo(String login, String pass) throws SQLException {
        super(login, pass);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, getLogin1());
        preparedStatement.setString(3, getIin1());
        preparedStatement.executeUpdate();

    }
    public boolean data_check() throws SQLException, NoSuchAlgorithmException {

        boolean iin2 = this.getLogin().equals(this.getIin1());
        boolean login2 = this.getLogin().equals(this.getLogin1());
        Statement statement = connection.createStatement();
        String sqlFind = "select password from users";
        ResultSet resultSet = statement.executeQuery(sqlFind);
        while (resultSet.next()){

            if (checker.checkPassword(resultSet.getString("password").toString(), this.getPass())){
                break;
            }
            break;
        }
        boolean pass2 = checker.checkPassword(resultSet.getString("password").toString(), this.getPass());


        if(login2 & pass2) {
            System.out.println("You successfully logged in.");
            return true;
        }
        else if(iin2 & pass2) {
            System.out.println("You successfully logged in.");
            return true;
        }
        else{
            System.out.println("Invalid data, please try again.");
            return false;
        }
    }
}