package org.example.model;

import org.example.Transaction;

import java.util.UUID;

public interface Seller {
    boolean registerSeller(UUID uuid, String name, int rating);
}
