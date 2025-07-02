package com.autobots.bankApplication;

import java.util.*;

public abstract class BankBase implements Bank {

    private String bankName;
    private long accountNumber;
    private long routingNumber;
    public static Map<String, Integer> numberOfClientsInEachBank = new HashMap<>(); // сюда добавлю название банка и кол-во
    public static int totalClients = 0;

    public static Set<BankBase> allBankRecords = new HashSet<>();
    // HW: нужно чтобы у каждого банка было своя база клиентов и добавить их в allBankRecords
    //     также необходимо определить кол-во клиентов в каждом банке.


    public BankBase(String bankName, long accountNumber, long routingNumber) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    public BankBase(long accountNumber, long routingNumber) {

        if (Long.toString(accountNumber).length() != 12) {
            throw new IllegalArgumentException("Account number must be 12 digits.");
        } else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("Routing number must be 9 digits.");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }

    }

    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase bankBase : allBankRecords) {
            if (bankBase.getAccountNumber() == bank.getAccountNumber()) {
                throw new Exception(bankBase.getAccountNumber() + ": account number already exist.");
            }
            if (bankBase.getRoutingNumber() == bank.getRoutingNumber()) {
                throw new Exception(bankBase.getRoutingNumber() + ": routing number already exist.");
            }
        }
        allBankRecords.add(bank);
    }

    public static void addClientToBank(String bankName) {
        numberOfClientsInEachBank.put(bankName,
                numberOfClientsInEachBank.getOrDefault(bankName, 0) + 1);
        totalClients++;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber && Objects.equals(bankName, bankBase.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankName, accountNumber, routingNumber);
    }

    @Override
    public String toString() {
        return  "Название Банка= " + bankName +
                ", расчетный счет= " + accountNumber +
                ", номера маршрутизации= " + routingNumber;
    }
}
