package com.autobots.bankApplication;

import java.util.Arrays;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank aliya = new MBank("MBank", 123456789123L, 123456789);
        MBank murat = new MBank("MBank", 855226987453L, 131313113);
        MBank almaz = new MBank("MBank", 654782345621L, 141414141);
        MBank saadat = new MBank("MBank", 198564785143L, 15151515);
        MBank daniyar = new MBank("MBank", 333333333333L, 121212121);

        Optima ulugbek = new Optima("OptimaBank", 555555555555L, 444444444);
        Optima emil = new Optima("OptimaBank", 111111111111L, 222222222);
        Optima esen = new Optima("OptimaBank", 567469523146L, 161616166);
        Optima samat = new Optima("OptimaBank", 212121212122L, 177171717);

        DemirBank zinaida = new DemirBank("DemirBank", 666666666666L, 777777777);
        DemirBank hasan = new DemirBank("DemirBank", 585296374112L, 665874235);
        DemirBank ahmed = new DemirBank("DemirBank", 987455553212L, 789456123);

        List<BankBase> clients = Arrays.asList(aliya, murat, almaz, saadat, daniyar, ulugbek, emil
                , esen, samat, zinaida, hasan, ahmed);

        for (BankBase client : clients) {
            BankBase.addClientToBank(client.getBankName());
        }
        System.out.println("Количество клиентов в каждом банке " + BankBase.numberOfClientsInEachBank +
                            ". \nВсего количество клиентов: "+ BankBase.totalClients);

        System.out.println("\nОбщая база данных по банкам: ");
        int count = 0;
        for (BankBase allClient : BankBase.allBankRecords) {
            count++;
            System.out.println(count + " - " + allClient);
        }


//        aliya.deposit(100000);
//        Bank.transferFunds(aliya, ulugbek, 500);
//
//        System.out.println(aliya.getBalance());
//        System.out.println(ulugbek.getBalance());
//
//
//
//        // Bank.transferFunds(zinaidaDemir,ulugbekOptima, 1000);
//
//        System.out.println(zinaida.getBalance());
//
//        BankBase.allBankRecords.stream()
//                .filter(n -> n.getBalance() > 100)
//                .forEach(System.out::println);

    }
}
