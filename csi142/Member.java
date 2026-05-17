package com.ub.csi142;

import java.util.Scanner;
import java.util.ArrayList;

public class Member {
    private String memberId;   // changed from int to String to match MainApp
    private String name;
    private String joinDate;   // renamed from contact to joinDate to match MainApp
    private double totalContributed;
    private ArrayList<Double> transactions;

    // Shared list used across Menu, Account, etc.
    public static ArrayList<Member> members = new ArrayList<>();

    public Member(String memberId, String name, String joinDate) {
        this.memberId         = memberId;
        this.name             = name;
        this.joinDate         = joinDate;
        this.totalContributed = 0.0;
        this.transactions     = new ArrayList<>();
    }

    public void addContribution(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0.");
            return;
        }
        totalContributed += amount;
        transactions.add(amount);
    }

    // Getters
    public String getMemberId()         { return memberId; }
    public String getName()             { return name; }
    public String getJoinDate()         { return joinDate; }
    public double getTotalContributed() { return totalContributed; }
    public ArrayList<Double> getTransactions() { return transactions; }

    // Static menu runner
    public static void run() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("             MEMBER MENU                ");
            System.out.println("========================================");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter join date (YYYY-MM-DD): ");
                    String joinDate = sc.nextLine();
                    members.add(new Member(id, name, joinDate));
                    System.out.println("Member added: " + name);
                    break;
                }
                case 2: {
                    if (members.isEmpty()) {
                        System.out.println("No members found.");
                    } else {
                        System.out.println("\n--- All Members ---");
                        for (Member m : members) {
                            System.out.println("ID: "        + m.getMemberId()
                                    + " | Name: "      + m.getName()
                                    + " | Join Date: " + m.getJoinDate());
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Returning to Main Menu...");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
