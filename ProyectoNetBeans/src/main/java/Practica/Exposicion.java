/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

abstract class Handler {
    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(int amount) {
        if (next != null) {
            next.handle(amount);
        }
    }
}

class Supervisor extends Handler {
    @Override
    public void handle(int amount) {
        if (amount <= 500) {
            System.out.println("Supervisor aprobó: $" + amount);
        } else {
            super.handle(amount);
        }
    }
}

class Gerente extends Handler {
    @Override
    public void handle(int amount) {
        if (amount <= 5000) {
            System.out.println("Gerente aprobó: $" + amount);
        } else {
            super.handle(amount);
        }
    }
}

class Director extends Handler {
    @Override
    public void handle(int amount) {
        System.out.println("Director aprobó: $" + amount);
    }
}

public class Exposicion {
    public static void main(String[] args) {
        Handler supervisor = new Supervisor();
        Handler gerente = new Gerente();
        Handler director = new Director();

        supervisor.setNext(gerente).setNext(director);

        supervisor.handle(300);
        supervisor.handle(2000);
        supervisor.handle(10000);
    }
}
