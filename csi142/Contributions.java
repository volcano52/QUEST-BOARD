package com.ub.csi142;

import java.util.ArrayList;

public class Contributions {
    private ArrayList<Transaction> transactions;

    public Contributions() {
        this.transactions = new ArrayList<>();
    }

    public boolean addTransaction(Transaction t) {
        if (isDuplicate(t)) {
            System.out.println("Duplicate transaction detected. Skipped.");
            return false;
        }
        if (t.getAmount() <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        transactions.add(t);
        return true;
    }

    private boolean isDuplicate(Transaction t) {
        for (Transaction existing : transactions) {
            if (existing.getTransactionID().equals(t.getTransactionID())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public ArrayList<Transaction> getTransactionsByMember(String memberId) {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getMemberID().equals(memberId)) {
                result.add(t);
            }
        }
        return result;
    }
}
