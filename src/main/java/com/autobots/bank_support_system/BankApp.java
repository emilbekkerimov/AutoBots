package com.autobots.bank_support_system;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankApp {

    private static final Map<String, Client> clients = new HashMap<>();

    public static void main(String[] args) {

        Client asan = new Client("Asan Uson", "123");

        DepositAccount asanDepAcc = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCredAcc = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanDepAcc);
        asan.addAccount(asanCredAcc);

        clients.put(asan.getClientID(), asan);

    }
}
