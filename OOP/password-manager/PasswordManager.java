import java.util.ArrayList;
import java.util.List;


class PasswordManager {
    private List<Account> accounts;

    public PasswordManager() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            if (account instanceof WebsiteAccount) {
                WebsiteAccount websiteAccount = (WebsiteAccount) account;
                System.out.println("Website Account - Username: " + websiteAccount.getUsername() + ", URL: " + websiteAccount.getUrl() + ", Password: " + websiteAccount.getPassword());
            } else if (account instanceof AppAccount) {
                AppAccount appAccount = (AppAccount) account;
                System.out.println("App Account - Username: " + appAccount.getUsername() + ", App Name: " + appAccount.getAppName() + ", Password: " + appAccount.getPassword());
            }
        }
    }
    
}
