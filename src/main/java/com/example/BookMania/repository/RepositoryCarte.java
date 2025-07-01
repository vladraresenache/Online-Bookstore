/** Clasa pentru Repository pentru carti
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.repository;

import com.example.BookMania.model.Carte;
import com.example.BookMania.util.UtilitateJson;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositoryCarte {
    private List<Carte> carti;
    private final UtilitateJson utilitateJson;

    public RepositoryCarte(UtilitateJson utilitateJson) {
        this.utilitateJson = utilitateJson;
        this.carti = utilitateJson.citesteCarti();
    }

    public List<Carte> getAllCarti() {
        return carti;
    }

    public void adaugaCarte(Carte carte) {
        carte.setId(nextId());
        carti.add(carte);
        utilitateJson.scrieCarti(carti);
    }

    public void updateCarte(Long id, Carte carteActualizata) {
        carti.stream()
                .filter(carte -> carte.getId().equals(id))
                .findFirst()
                .ifPresent(carteExistenta -> {
                    if (carteActualizata.getTitlu() != null && !carteActualizata.getTitlu().isEmpty()) {
                        carteExistenta.setTitlu(carteActualizata.getTitlu());
                    }
                    if (carteActualizata.getAutor() != null && !carteActualizata.getAutor().isEmpty()) {
                        carteExistenta.setAutor(carteActualizata.getAutor());
                    }
                    if (carteActualizata.getPret() > 0) {
                        carteExistenta.setPret(carteActualizata.getPret());
                    }
                    if (carteActualizata.getDescriere() != null && !carteActualizata.getDescriere().isEmpty()) {
                        carteExistenta.setDescriere(carteActualizata.getDescriere());
                    }
                    utilitateJson.scrieCarti(carti);
                });
    }

    public void stergeCarte(Long id) {
        carti.removeIf(carte -> carte.getId().equals(id));
        utilitateJson.scrieCarti(carti);
    }

    public Optional<Carte> getCarteById(Long id) {
        return carti.stream()
                .filter(carte -> carte.getId().equals(id))
                .findFirst();
    }

    public List<Carte> searchCarti(String query) {
        String lowerCaseQuery = query.toLowerCase();
        return carti.stream()
                .filter(carte -> carte.getTitlu().toLowerCase().contains(lowerCaseQuery) ||
                        carte.getAutor().toLowerCase().contains(lowerCaseQuery) ||
                        (carte.getCategorie() != null && carte.getCategorie().getNume().toLowerCase().contains(lowerCaseQuery))) // Adjusted line
                .collect(Collectors.toList());
    }

    private Long nextId() {
        return carti.stream()
                .mapToLong(Carte::getId)
                .max()
                .orElse(0) + 1;
    }
}
