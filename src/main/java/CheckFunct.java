public class CheckFunct extends HandleAuth{
    String regex = "\\d+";
    public CheckFunct (String login, String pass){
        super(login, pass);

    }
    public boolean checklogin(String login) {
        for (char i : this.getLogin().toCharArray()) {
            if (Character.isUpperCase(i)) {
                this.count++;
            } else if (Character.isLowerCase(i)) {
                this.count2++;
            } else if (this.getLogin().matches(regex)) {
                this.count3++;
            }
        }
        if (count > 0 && count2 > 0) {
            return true;
        }
        else if (count3 > 0){
            return true;
        }
        else{System.out.println("Login must contain uppercase and lowercase letter, please try again.");
            return false;}
    }
    public boolean checklength(String pass) {
        if (this.getPass().length() < 6) {
            System.out.println("Password must be at least 6, please try again.");
            return true;
        }
        else {
            return false;
        }
    }
}