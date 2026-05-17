package com.ub.csi142;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    private Contributions contributions;
    private Tracker tracker;

    public Menu(Contributions contributions) {
        this.contributions = contributions;
        this.tracker       = new Tracker(contributions);
    }

    public void showMenu() {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("            MAIN MENU                   ");
            System.out.println("========================================");
            System.out.println("1. Members");
            System.out.println("2. Add Contribution");
            System.out.println("3. Account Activity");
            System.out.println("4. Search Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    Member.run();
                    break;

                case 2: {
                    input.nextLine();
                    System.out.print("Enter Member ID: ");
                    String id = input.nextLine();
                    Member target = null;
                    for (Member m : Member.members) {
                        if (m.getMemberId().equals(id)) { target = m; break; }
                    }
                    if (target == null) {
                        System.out.println("Member not found.");
                    } else {
                        System.out.print("Enter amount: ");
                        double amount = input.nextDouble();
                        String txnId = "TXN" + System.currentTimeMillis();
                        String date  = java.time.LocalDate.now().toString();
                        contributions.addTransaction(new Transaction(txnId, id, amount, "IN", date));
                        System.out.println("Contribution added.");
                    }
                    break;
                }

                case 3:
                    Account.run(Member.members, contributions);
                    break;

                case 4:
                    runTrackerMenu(input);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }

        } while (choice != 5);
    }

    private void runTrackerMenu(Scanner input) {
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("         SEARCH TRANSACTIONS            ");
            System.out.println("========================================");
            System.out.println("1. View All Transactions");
            System.out.println("2. Search by Member ID");
            System.out.println("3. Search by Type (IN / OUT)");
            System.out.println("4. Search by Date Range");
            System.out.println("5. Search by Minimum Amount");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    tracker.displayTransactions(tracker.getAllTransactions());
                    break;

                case 2: {
                    input.nextLine();
                    System.out.print("Enter Member ID: ");
                    String id = input.nextLine();
                    tracker.displayTransactions(tracker.findByMemberId(id));
                    break;
                }

                case 3: {
                    input.nextLine();
                    System.out.print("Enter type (IN / OUT): ");
                    String type = input.nextLine();
                    tracker.displayTransactions(tracker.findByType(type));
                    break;
                }

                case 4: {
                    input.nextLine();
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String start = input.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String end = input.nextLine();
                    tracker.displayTransactions(tracker.findByDateRange(start, end));
                    break;
                }

                case 5: {
                    System.out.print("Enter minimum amount: ");
                    double min = input.nextDouble();
                    tracker.displayTransactions(tracker.findByMinAmount(min));
                    break;
                }

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
