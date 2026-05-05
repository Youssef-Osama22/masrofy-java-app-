import java.util.*;
import java.io.*;

/** 1. User Class */
class User {
    String username;

    public User(String name) {
        this.username = name;
    }
}

/** 2. Category Class */
class Category {
    String name;

    public Category(String name) {
        this.name = name;
    }
}

/** 3. Expense Class */
class Expense {
    Category category;
    double amount;
    String date;

    public Expense(Category cat, double amt, String d) {
        this.category = cat;
        this.amount = amt;
        this.date = d;
    }

    @Override
    public String toString() {
        return date + " | " + category.name + " | $" + amount;
    }
}

/** 4. BudgetCycle Class */
class BudgetCycle {
    double limit;

    public double getDailyLimit() {
        return limit / 30;
    }
}

/** 5. NotificationService Class */
class NotificationService {
    public void check(double total, double limit) {
        if (limit > 0 && total >= limit * 0.8)
            System.out.println("\n⚠️ Warning: You exceeded 80% of your budget!");
    }
}

/** 6. HistoryManager Class */
class HistoryManager {
    public void show(List<Expense> list) {
        System.out.println("\n--- Expense History ---");
        if (list.isEmpty())
            System.out.println("No expenses found.");
        else
            for (int i = 0; i < list.size(); i++)
                System.out.println(i + ": " + list.get(i));
    }
}

/** 7. Dashboard Class */
class Dashboard {
    public void display(double total, double limit) {
        System.out.println("\n--- Dashboard ---");
        System.out.println("Total Spent: $" + total);
        System.out.println("Remaining Budget: $" + (limit - total));
    }
}

/** 8. Database Class */
class Database {
    static final String FILE = "masroofy_data.txt";

    public static void save(List<Expense> list, double limit) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            pw.println(limit);
            for (Expense e : list)
                pw.println(e.category.name + "," + e.amount + "," + e.date);
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }
}

/** Main Application */
public class MasroofyApp {
    static List<Expense> expenses = new ArrayList<>();
    static BudgetCycle cycle = new BudgetCycle();

    public static void main(String[] args) {
        loadData();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        User user = new User(sc.nextLine());
        System.out.println("Welcome to Masroofy, " + user.username + "!");

        NotificationService notify = new NotificationService();
        HistoryManager history = new HistoryManager();
        Dashboard dash = new Dashboard();

        while (true) {
            System.out.println("\n===== Masroofy System =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View History");
            System.out.println("3. Edit Category");
            System.out.println("4. Set Budget");
            System.out.println("5. Calculate Daily Limit");
            System.out.println("6. View Dashboard");
            System.out.println("7. Save & Exit");
            System.out.print("Choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }
            int c = sc.nextInt();
            sc.nextLine();

            if (c == 1) {
                System.out.print("Category: ");
                String cat = sc.nextLine();
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                expenses.add(new Expense(new Category(cat), amt, new Date().toString()));
                notify.check(getTotal(), cycle.limit);
            } else if (c == 2)
                history.show(expenses);
            else if (c == 3) {
                System.out.print("Index to edit: ");
                int id = sc.nextInt();
                sc.nextLine();
                if (id >= 0 && id < expenses.size()) {
                    System.out.print("New Category Name: ");
                    expenses.get(id).category.name = sc.nextLine();
                    System.out.println("Updated!");
                }
            } else if (c == 4) {
                System.out.print("Set Budget Limit: ");
                cycle.limit = sc.nextDouble();
            } else if (c == 5) {
                System.out.println("Your Daily Limit: $" + cycle.getDailyLimit());
            } else if (c == 6)
                dash.display(getTotal(), cycle.limit);
            else if (c == 7) {
                Database.save(expenses, cycle.limit);
                System.out.println("Data Saved. Goodbye " + user.username);
                break;
            }
        }
        sc.close();
    }

    static double getTotal() {
        return expenses.stream().mapToDouble(e -> e.amount).sum();
    }

    static void loadData() {
        try {
            File f = new File(Database.FILE);
            if (!f.exists())
                return;
            Scanner fs = new Scanner(f);
            if (fs.hasNextLine())
                cycle.limit = Double.parseDouble(fs.nextLine());
            while (fs.hasNextLine()) {
                String[] p = fs.nextLine().split(",");
                expenses.add(new Expense(new Category(p[0]), Double.parseDouble(p[1]), p[2]));
            }
            fs.close();
        } catch (Exception e) {
        }
    }
}
