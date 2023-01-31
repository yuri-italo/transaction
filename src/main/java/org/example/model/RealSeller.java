package org.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.Transaction;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
public class RealSeller implements Seller {
    private UUID id;
    private String name;
    private int rating;

    @Override
    @Transaction
    public boolean registerSeller(UUID uuid, String name, int rating) {
        System.out.printf("Seller with id: %s, name: %s, rating: %s, successfully registered.\n", uuid,name,rating);
        return true;
    }
}
