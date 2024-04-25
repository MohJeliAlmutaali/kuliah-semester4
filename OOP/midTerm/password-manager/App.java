// Kelas utama
public class App {
    public static void main(String[] args) {
        // Membuat objek PasswordManager
        PasswordManager passwordManager = new PasswordManager();

        // Menambahkan beberapa akun
        WebsiteAccount websiteAccountFB = new WebsiteAccount("user123", "pass123", "https://facebook.com");
        AppAccount appAccountGoogle = new AppAccount("user456", "pass456", "Google");

        passwordManager.addAccount(websiteAccountFB);
        passwordManager.addAccount(appAccountGoogle);

        
        passwordManager.displayAccounts();

        System.out.println("Generated password for website account: " + websiteAccountFB.generatePassword());
        System.out.println("Generated password for app account: " + appAccountGoogle.generatePassword());

        passwordManager.displayAccounts();


    }
}
