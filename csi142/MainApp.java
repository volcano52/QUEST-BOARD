package com.ub.csi142;

public class MainApp {
    public static void main(String[] args) {

        // ── Pre-load members ─────────────────────────────────────────────────
        Member m1  = new Member("38946543", "Volcano Kgaboitsile",    "2026-01-01");
        Member m2  = new Member("10375356", "Constanance Xhosi",      "2026-01-01");
        Member m3  = new Member("32753457", "Reverence Sechele",      "2026-01-01");
        Member m4  = new Member("01653658", "Zambanzi Rotholi",       "2026-01-01");
        Member m5  = new Member("98467690", "Justice Ngabe",          "2026-01-01");
        Member m6  = new Member("12345678", "Elijah Ambonosee",       "2026-01-01");
        Member m7  = new Member("57896278", "Police Kelechi",         "2026-01-01");
        Member m8  = new Member("43979873", "Terrence Lethonogonolo", "2026-01-01");
        Member m9  = new Member("28756839", "Miracle Obane",          "2026-01-01");
        Member m10 = new Member("91863514", "Faith Ndobe",            "2026-01-01");

        // Add all members to the shared list
        Member.members.add(m1);
        Member.members.add(m2);
        Member.members.add(m3);
        Member.members.add(m4);
        Member.members.add(m5);
        Member.members.add(m6);
        Member.members.add(m7);
        Member.members.add(m8);
        Member.members.add(m9);
        Member.members.add(m10);

        // ── Pre-load transactions ────────────────────────────────────────────
        Contributions contributions = new Contributions();

        contributions.addTransaction(new Transaction("TXN914763202", "38946543", 412.62,  "IN",  "2026-01-31"));
        contributions.addTransaction(new Transaction("TXN176228245", "10375356", 368.53,  "OUT", "2026-01-31"));
        contributions.addTransaction(new Transaction("TXN358633898", "32753457", 1920.42, "IN",  "2026-02-07"));
        contributions.addTransaction(new Transaction("TXN532311310", "01653658", 377.70,  "IN",  "2026-02-07"));
        contributions.addTransaction(new Transaction("TXN652070932", "10375356", 157.10,  "OUT", "2026-02-09"));
        contributions.addTransaction(new Transaction("TXN126855092", "38946543", 383.70,  "IN",  "2026-02-14"));
        contributions.addTransaction(new Transaction("TXN501486939", "98467690", 8229.01, "IN",  "2026-02-19"));
        contributions.addTransaction(new Transaction("TXN536383774", "12345678", 268.54,  "IN",  "2026-02-21"));
        contributions.addTransaction(new Transaction("TXN819595113", "57896278", 7184.28, "IN",  "2026-02-26"));
        contributions.addTransaction(new Transaction("TXN208449460", "43979873", 221.06,  "OUT", "2026-03-01"));

        contributions.addTransaction(new Transaction("TXN899925830", "28756839", 6676.69, "OUT", "2026-03-03"));
        contributions.addTransaction(new Transaction("TXN341266931", "10375356", 6431.37, "IN",  "2026-03-03"));
        contributions.addTransaction(new Transaction("TXN528414718", "32753457", 5504.80, "OUT", "2026-03-11"));
        contributions.addTransaction(new Transaction("TXN624636385", "32753457", 1893.65, "IN",  "2026-03-13"));
        contributions.addTransaction(new Transaction("TXN209747451", "38946543", 8779.95, "OUT", "2026-03-15"));
        contributions.addTransaction(new Transaction("TXN335493870", "28756839", 498.80,  "IN",  "2026-03-18"));
        contributions.addTransaction(new Transaction("TXN102314313", "12345678", 897.80,  "OUT", "2026-03-20"));
        contributions.addTransaction(new Transaction("TXN387484583", "57896278", 6537.44, "OUT", "2026-03-23"));
        contributions.addTransaction(new Transaction("TXN601463916", "01653658", 7227.64, "IN",  "2026-03-24"));
        contributions.addTransaction(new Transaction("TXN847959430", "12345678", 6446.15, "OUT", "2026-03-26"));

        contributions.addTransaction(new Transaction("TXN250519597", "12345678", 239.85,  "OUT", "2026-03-29"));
        contributions.addTransaction(new Transaction("TXN675770529", "43979873", 1883.44, "OUT", "2026-03-30"));
        contributions.addTransaction(new Transaction("TXN103484630", "98467690", 4107.11, "IN",  "2026-03-30"));
        contributions.addTransaction(new Transaction("TXN967043303", "01653658", 641.49,  "OUT", "2026-04-01"));
        contributions.addTransaction(new Transaction("TXN214257751", "98467690", 7111.60, "IN",  "2026-04-05"));
        contributions.addTransaction(new Transaction("TXN369953851", "91863514", 2091.85, "IN",  "2026-04-08"));
        contributions.addTransaction(new Transaction("TXN751325257", "32753457", 6314.37, "IN",  "2026-04-08"));
        contributions.addTransaction(new Transaction("TXN882893941", "57896278", 4159.58, "IN",  "2026-04-09"));
        contributions.addTransaction(new Transaction("TXN922308461", "32753457", 106.59,  "OUT", "2026-04-09"));
        contributions.addTransaction(new Transaction("TXN205128697", "12345678", 72.76,   "IN",  "2026-04-11"));

        contributions.addTransaction(new Transaction("TXN313500298", "38946543", 1551.99, "OUT", "2026-04-12"));
        contributions.addTransaction(new Transaction("TXN306468299", "43979873", 568.74,  "IN",  "2026-04-14"));
        contributions.addTransaction(new Transaction("TXN553035110", "38946543", 3861.29, "IN",  "2026-04-16"));
        contributions.addTransaction(new Transaction("TXN271779360", "91863514", 1133.24, "OUT", "2026-04-21"));
        contributions.addTransaction(new Transaction("TXN636045484", "28756839", 1871.82, "IN",  "2026-04-24"));
        contributions.addTransaction(new Transaction("TXN448195935", "57896278", 429.28,  "OUT", "2026-04-28"));
        contributions.addTransaction(new Transaction("TXN676567501", "91863514", 1652.90, "OUT", "2026-04-28"));

        // ── Launch the app ───────────────────────────────────────────────────
        Menu menu = new Menu(contributions);
        menu.showMenu();
    }
}
