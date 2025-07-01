/** Clasa pentru ElementCos
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */

package com.example.BookMania.model;

public class ElementCos {
    private Long idCarte;
    private String titlu;
    private String autor;
    private double pret;
    private int cantitate;

    // Constructor
    public ElementCos(Long idCarte, String titlu, String autor, double pret, int cantitate) {
        this.idCarte = idCarte;
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    // Getters și Setters
    public Long getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(Long idCarte) {
        this.idCarte = idCarte;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
