import java.util.Scanner;

class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        this.balance = initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            System.out.println("Successfully deposited : $ " + amount);
        }
        else
        {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Successfully withdrawn : $" + amount);
        }
        else if (amount > balance)
        {
            System.out.println("Insufficient balance.");
        }
        else
        {
            System.out.println("Withdrawal amount must be positive.");
        }
    }
}

class ATM
{
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account)
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu()
    {
        int choice = 0;
        do
        {
            System.out.println("\n ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice)
            {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            }while(choice!=4);
        }


    private void checkBalance()
    {
        System.out.println("Current balance: $" + account.getBalance());
    }

    private void deposit()
    {
        System.out.println("Enter deposit amount:");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw()
    {
        System.out.println("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(1000.0);
        ATM atm1 = new ATM(account);
        atm1.showMenu();
    }
}
