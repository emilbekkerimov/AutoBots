package com.autobots.bankApplication;

public class DemirBank extends BankBase{
    private double balance = 500;

    public DemirBank(String bankName, long accountNumber, long routingNumber) throws Exception {
        super(bankName, accountNumber, routingNumber);
        addToAllBankRecords(this);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount >= 500000) {
            throw new IllegalArgumentException("Invalid amount can not be deposit");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {
        if (amount < 0 || amount >= 450000) {
            throw new IllegalArgumentException("Invalid amount can not be withdraw");
        } else {
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            } else {
                balance -= amount;
            }
        }
    }
}
