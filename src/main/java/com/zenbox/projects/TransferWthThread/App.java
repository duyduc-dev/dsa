package com.zenbox.projects.TransferWthThread;

import com.zenbox.projects.TransferWthThread.entities.BankAccount;
import com.zenbox.projects.TransferWthThread.services.TransferService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        BankAccount A = new BankAccount(1, 1000);
        BankAccount B = new BankAccount(2, 1000);

        TransferService service = new TransferService();

        // Thread 1: A → B
        Thread t1 = new Thread(() -> {
            service.transfer(A, B, 100);
        }, "T1");

        // Thread 2: B → A
        Thread t2 = new Thread(() -> {
            service.transfer(B, A, 100);
        }, "T2");

        t1.start();
        t2.start();
    }
}
