package com.autobots.bank_support_system;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public abstract class BankAccount {

    protected String accountNumber;
    protected double balance;
    protected final Currency currency;
    protected final Client owner;
    protected final List<Transaction> transactions = new ArrayList<>();

    public BankAccount(Client owner, Currency currency) {
        this.currency = currency;
        this.owner = owner;
        this.accountNumber = UUID.randomUUID().toString();
    }

    public abstract void deposit(double amount);

    public abstract boolean withDraw(double amount);

    public void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Client getOwner() {
        return owner;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
