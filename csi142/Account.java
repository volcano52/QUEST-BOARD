package com.ub.csi142;

import java.util.ArrayList;

public class Account {
    private String accountName;
    private ArrayList<Member> members;
    private Contributions contributions;

    public Account(String accountName, ArrayList<Member> members, Contributions contributions) {
        this.accountName   = accountName;
        this.members       = members;
        this.contributions = contributions;
    }

    public void showMemberActivity(String memberId) {
        Member found = findMember(memberId);
        if (found == null) { System.out.println("Member not found."); return; }

        ArrayList<Transaction> transactions = contributions.getTransactionsByMember(memberId);

        System.out.println("\n========================================");
        System.out.println("  Account : " + accountName);
        System.out.println("  Member  : " + found.getName() + " (ID: " + memberId + ")");
        System.out.println("========================================");
        System.out.printf("  %-5s %-15s %-10s %-15s%n", "No.", "Amount", "Type", "Date");
        System.out.println("  -----------------------------------------------");

        if (transactions.isEmpty()) { System.out.println("  No transactions yet."); return; }

        double runningTotal = 0.0;
        for (int i = 0; i < transactions.size(); i++) {
            Transaction t = transactions.get(i);
            runningTotal += t.getAmount();
            System.out.printf("  %-5d $%-14.2f %-10s %-15s%n",
                    (i + 1), t.getAmount(), t.getType(), t.getDate());
        }

        System.out.println("  -----------------------------------------------");
        System.out.printf("  %-21s $%.2f%n", "Total:", runningTotal);
    }

    public void showAllMembersActivity() {
        if (members.isEmpty()) { System.out.println("No members found."); return; }
        for (Member m : members) showMemberActivity(m.getMemberId());
    }

    public void showSummary() {
    if (members.isEmpty()) { System.out.println("No members found."); return; }

    double groupTotal = Calculations.totalContributions(members, contributions);
    System.out.println("\n========================================");
    System.out.println("   " + accountName + " — Members Summary");
    System.out.println("========================================");
    System.out.printf("%-12s %-25s %-15s %-10s%n", "ID", "Name", "Total", "Share");
    System.out.println("------------------------------------------------------------");

    for (Member m : members) {
        double memberTotal = Calculations.getMemberTotal(m, contributions);
        double share       = Calculations.memberSharePercent(m, members, contributions);
        System.out.printf("%-12s %-25s $%-14.2f %.2f%%%n",
                m.getMemberId(), m.getName(), memberTotal, share);
    }

    System.out.println("------------------------------------------------------------");
    System.out.printf("%-38s $%.2f%n", "Group Total:", groupTotal);
}
    private Member findMember(String memberId) {
        for (Member m : members) {
            if (m.getMemberId().equals(memberId)) return m;
        }
        return null;
    }

    public static void run(ArrayList<Member> members, Contributions contributions) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        Account account = new Account("Group Savings", members, contributions);
        boolean running = true;

        while (running) {
            System.out.println("\n========================================");
            System.out.println("           ACCOUNT MENU                 ");
            System.out.println("========================================");
            System.out.println("1. View My Transaction Activity");
            System.out.println("2. View All Members Activity");
            System.out.println("3. View Group Summary");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    sc.nextLine();
                    System.out.print("Enter your Member ID: ");
                    String id = sc.nextLine();
                    account.showMemberActivity(id);
                    break;
                }
                case 2: account.showAllMembersActivity(); break;
                case 3: account.showSummary(); break;
                case 4: System.out.println("Returning to Main Menu..."); running = false; break;
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }
}
