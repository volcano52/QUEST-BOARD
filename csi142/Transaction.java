package com.ub.csi142;

public class Transaction {
    private String transactionID; // What kind of transaction it is
    private String memberID; // The number assigned to a member
    private double amount; // AMount sent/recieved in the transaction
    private String type; // contribution, Payout and the like
    private String date; // When it took place

    public Transaction(String transactionID, String memberID, double amount, String type, String date) {
        this.transactionID = transactionID;
        this.memberID = memberID;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }
    public String getTransactionID() { return transactionID; }
    public String getMemberID() { return memberID; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getDate() { return date; }

// Readable summary of a transaction
@Override
public String toString() {
    return "[" + transactionID + "] " + memberID + " | " + type + " | " + amount + " | " + date;
   }
}

