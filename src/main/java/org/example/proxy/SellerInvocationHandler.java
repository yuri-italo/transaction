package org.example.proxy;

import org.example.Transaction;
import org.example.exceptions.TransactionAnnotationIsNotPresent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;

public class SellerInvocationHandler implements InvocationHandler {

    private final Object object;

    public SellerInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object registered;

        try {
            if(object.getClass().getMethod(method.getName(), UUID.class, String.class, int.class)
                    .isAnnotationPresent(Transaction.class)
            ) {
                System.out.printf("Iniciando execução do método %s.%s\n", method.getName(), object.getClass().getName());
                registered = method.invoke(object,args);
                System.out.printf("Finalizando execução do método %s.%s com sucesso\n", method.getName(), object.getClass().getName());
                return registered;
            } else {
                throw new TransactionAnnotationIsNotPresent();
            }
        } catch (TransactionAnnotationIsNotPresent e) {
            System.out.printf("Finalizando execução do método %s.%s com erro\n", method.getName(), object.getClass().getName());
            return false;
        }

    }
}