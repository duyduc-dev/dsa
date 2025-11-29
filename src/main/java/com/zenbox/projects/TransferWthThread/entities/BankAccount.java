package com.zenbox.projects.TransferWthThread.entities;

public class BankAccount {
    private final int id;
    private long balance;

    public BankAccount(int id, long balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() { return id; }
    public long getBalance() { return balance; }

    public void withdraw(long amount) {
        balance -= amount;
    }

    public void deposit(long amount) {
        balance += amount;
    }
}

