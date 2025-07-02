package com.autobots.bank_support_system;

public class DepositAccount extends BankAccount{

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }

    @Override
    public boolean withDraw(double amount) {
        if (amount <= balance){
            balance -= amount;
            addTransaction("WithDraw", amount);
            return true;
        }
        return false;
    }
}