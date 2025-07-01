/** Clasa pentru Utilizator
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */

package com.example.BookMania.model;

public class Utilizator {
    private String numeUtilizator;
    private String parola;
    private String rol; // "UTILIZATOR" sau "ADMIN"

    public Utilizator(String numeUtilizator, String parola, String rol) {
        this.numeUtilizator = numeUtilizator;
        this.parola = parola;
        this.rol = rol;
    }

    public String getNumeUtilizator() {
        return numeUtilizator;
    }

    public void setNumeUtilizator(String numeUtilizator) {
        this.numeUtilizator = numeUtilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
