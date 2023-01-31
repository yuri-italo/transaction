package org.example.proxy;

import org.example.Transaction;
import org.example.exceptions.TransactionAnnotationIsNotPresent;
import org.example.model.Seller;

import java.lang.reflect.Method;
import java.util.UUID;

public class ProxyPatternSeller implements Seller {
    private final Seller seller;

    public ProxyPatternSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public boolean registerSeller(UUID uuid, String name, int rating) {
        Method method = null;

        try {
            method = seller.getClass().getMethod("registerSeller", UUID.class, String.class, int.class);
            if (method.isAnnotationPresent(Transaction.class)) {
                System.out.printf("Iniciando execução do método %s.%s\n", method.getName(), seller.getClass().getName());
                boolean registered = seller.registerSeller(uuid, name, rating);
                System.out.printf("Finalizando execução do método %s.%s com sucesso\n", method.getName(), seller.getClass().getName());
                return registered;
            } else {
                throw new TransactionAnnotationIsNotPresent();
            }
        } catch (TransactionAnnotationIsNotPresent | NoSuchMethodException e) {
            System.out.printf("Finalizando execução do método %s.%s com erro\n", method.getName(), seller.getClass().getName());
            return false;
        }
    }


}
