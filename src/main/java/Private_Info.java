import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Private_Info extends PasswordHasher{
    private String login1 = "Se2214";
    private String pass1 = "se2214";
    private String iin1 = "123456789012";
    private String login;
    private String pass;
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "jailaybai";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
    protected String password = hashPassword(pass1);
    protected String sql = "UPDATE users SET password = ?, login = ?, iin = ? WHERE id = 1";


    public Private_Info(String login, String pass) throws SQLException {
        this.login = login;
        this.pass = pass;
    }
    public String getLogin1(){
        return login1;
    }
    public void setLogin1(String login1){
        this.login1 = login1;
    }
    public String getPass1() {
        return pass1;
    }
    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getIin1() {
        return iin1;
    }
    public void setIin1(String iin1) {
        this.iin1 = iin1;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

