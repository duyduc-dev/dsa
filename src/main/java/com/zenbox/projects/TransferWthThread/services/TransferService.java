package com.zenbox.projects.TransferWthThread.services;

import com.zenbox.projects.TransferWthThread.entities.BankAccount;

public class TransferService {

    public void transfer(BankAccount from, BankAccount to, long amount) {
        System.out.println(Thread.currentThread().getName() +
                " trying to lock FROM " + from.getId());

        var first = from.getId() < to.getId() ? from : to;
        var second = from.getId() < to.getId() ? to : from;

        synchronized (first) {
            System.out.println(Thread.currentThread().getName() +
                    " locked FROM " + from.getId());

            try { Thread.sleep(100); } catch (Exception ignored) {}

            System.out.println(Thread.currentThread().getName() +
                    " trying to lock TO " + to.getId());

            synchronized (second) {
                System.out.println(Thread.currentThread().getName() +
                        " locked TO " + to.getId());

                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                }
            }
        }
    }
}
