/** Clasa pentru Categorie
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private Long id;
    private String nume;

    // Constructori, getteri și setteri
    public Categorie() {
    }

    public Categorie(Long id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

}
