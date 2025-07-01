/** Clasa pentru Repository pentru elemente din cos
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.repository;

import com.example.BookMania.model.ElementCos;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCos {
    private final List<ElementCos> elementeCos = new ArrayList<>();

    public void adaugaInCos(Long idCarte, String titlu, String autor, double pret) {

        for (ElementCos item : elementeCos) {
            if (item.getIdCarte().equals(idCarte)) {
                item.setCantitate(item.getCantitate() + 1);
                return;
            }
        }
        elementeCos.add(new ElementCos(idCarte, titlu, autor, pret, 1));
    }

    public List<ElementCos> getElementeCos() {
        return elementeCos;
    }

    public void stergeDinCos(Long idCarte) {
        elementeCos.removeIf(item -> item.getIdCarte().equals(idCarte));
    }

    public void golesteCos() {
        elementeCos.clear();
    }

    public void actualizeazaCantitate(Long idCarte, int cantitate) {
        for (ElementCos item : elementeCos) {
            if (item.getIdCarte().equals(idCarte)) {
                item.setCantitate(cantitate);
                return;
            }
        }
    }

    public int getNumarElementeCos() {
        int count = 0;
        for (ElementCos item : elementeCos) {
            count += item.getCantitate();
        }
        return count;
    }

    public double getTotalCos() {
        double total = 0;
        for (ElementCos item : elementeCos) {
            total += item.getPret() * item.getCantitate();
        }
        return total;
    }
}
