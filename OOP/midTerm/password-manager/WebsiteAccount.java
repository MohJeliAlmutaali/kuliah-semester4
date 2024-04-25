import java.util.Random;;
class WebsiteAccount extends Account {
    private String url;

    public WebsiteAccount(String username, String password, String url) {
        super(username, password);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) { 
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        String newPassword = sb.toString();
        setPassword(newPassword); 
        return newPassword; 
    }
    
}