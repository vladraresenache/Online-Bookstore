/** Clasa pentru Carti
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.model;

public class Carte {
    private Long id;
    private String titlu;
    private String autor;
    private double pret;
    private String descriere;
    private int stoc;
    private Categorie categorie;

    public Carte() {
    }

    public Carte(String titlu, String autor, double pret, String descriere, int stoc, Categorie categorie) {
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
        this.descriere = descriere;
        this.stoc = stoc;
        this.categorie = categorie;
    }

    public Carte(Long id, String titlu, String autor, double pret, String descriere, int stoc) {
        this.id = id;
        this.titlu = titlu;
        this.autor = autor;
        this.pret = pret;
        this.descriere = descriere;
        this.stoc = stoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public boolean esteStocCritic() {
        return stoc < 5;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

}
