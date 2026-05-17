package com.ub.csi142;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private Contributions contributions;

    public Tracker(Contributions contributions) {
        this.contributions = contributions;
    }

    public List<Transaction> getAllTransactions() {
        return contributions.getTransactions();
    }

    public List<Transaction> findByMemberId(String memberId) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : contributions.getTransactions()) {
            if (t.getMemberID().equals(memberId)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Transaction> findByType(String type) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : contributions.getTransactions()) {
            if (t.getType().equalsIgnoreCase(type)) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Transaction> findByDateRange(String startDate, String endDate) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : contributions.getTransactions()) {
            if (t.getDate().compareTo(startDate) >= 0 &&
                t.getDate().compareTo(endDate)   <= 0) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Transaction> findByMinAmount(double minAmount) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : contributions.getTransactions()) {
            if (t.getAmount() >= minAmount) {
                result.add(t);
            }
        }
        return result;
    }

    public void displayTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
