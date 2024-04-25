import java.util.Random;
class AppAccount extends Account {
    private String appName;

    public AppAccount(String username, String password, String appName) {
        super(username, password);
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    @Override
    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) { 
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        String newPassword = sb.toString();
        setPassword(newPassword); 
        return newPassword; 
    }
}
