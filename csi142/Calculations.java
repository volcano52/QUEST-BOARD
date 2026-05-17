package com.ub.csi142;

import java.util.ArrayList;

public class Calculations {

    public static double percentageIncrease(double oldTotal, double newAmount) {
        if (oldTotal <= 0) return 0.0;
        return (newAmount / oldTotal) * 100.0;
    }

    public static double getMemberTotal(Member member, Contributions contributions) {
        double total = 0.0;
        for (Transaction t : contributions.getTransactionsByMember(member.getMemberId())) {
            total += t.getAmount();
        }
        return total;
    }

    public static double totalContributions(ArrayList<Member> members, Contributions contributions) {
        double total = 0.0;
        for (Member m : members) {
            total += getMemberTotal(m, contributions);
        }
        return total;
    }

    public static double memberSharePercent(Member member, ArrayList<Member> members, Contributions contributions) {
        double groupTotal = totalContributions(members, contributions);
        if (groupTotal == 0) return 0.0;
        return (getMemberTotal(member, contributions) / groupTotal) * 100.0;
    }
}
