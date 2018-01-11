import java.util.HashMap;

public class Bank {
    HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();

    //Dictionary<int, Account> accounts = new Dictionary<int, Account>();
    //Random random = new Random();

    public int CreateAccount(int initialBalance)
    {
        int number;//choose an nonexistent random account number
        do {
            number = (int)Math.floor(Math.random() * 10000);
        } while (accounts.containsKey(number));
        Account newAccount = new Account(number, initialBalance);
        accounts.put(number, newAccount);
        return number; //return account number of created account
    }

    public void TransferMoney(int source, int destination, int amount)
    {
        Account s = accounts.get(source);
        Account d = accounts.get(source);

        //Press 'enter' to run the program:

        // Change for exercise part b):
        /*
         * The if-clause prevents a circular-wait. By comparing accountnumbers and inverting the order of locks we
         * make a circular-wait impossible.
         *
         */

        if (source<destination){
            s.doLock();
            d.doLock();
        } else{
            d.doLock();
            s.doLock();
        }

        /*
         *  TODO: Eigenen Code hier einf?gen!
         */

        if (s.getBalance() >= amount) {
            try {
                int balance;
                Thread.sleep((int)(Math.random() * 50)); //Waiting some time for other threads
                balance = s.getBalance();
                Thread.sleep((int)(Math.random() * 50));
                s.setBalance(balance - amount);
                balance = d.getBalance();
                Thread.sleep((int)(Math.random() * 50));
                d.setBalance(balance + amount);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getId() + ": Transfer of " + amount + " money from " + source + " to " + destination + " failed, balance only: " + s.getBalance());
        }
        if (s.getBalance() < 0) {
            System.out.println("Something must be wrong, balance of " + source + " is negative");
        }

        // Change for exercise-part b)
        s.doUnlock();
        d.doUnlock();
    }

    public int GetTotalMoney()
    {
        int total = 0;
        System.out.println("Total accounts: " + accounts.size());
        for (Integer key: accounts.keySet()) {
            total += accounts.get(key).getBalance();
        }
        return total;
    }

    public void PrintAccountBalances()
    {
        for (Integer key: accounts.keySet()) {
            Account a = accounts.get(key);
            System.out.println("Account " + a.getNumber() + " has a balance of " + a.getBalance());
        }
        System.out.println("Total money on bank: " + GetTotalMoney());
    }
}
