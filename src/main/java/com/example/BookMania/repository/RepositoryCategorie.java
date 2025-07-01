/** Clasa pentru Repository pentru categorii
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.repository;

import com.example.BookMania.model.Categorie;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryCategorie {
    private final List<Categorie> categorii = new ArrayList<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "categorii.json";

    public RepositoryCategorie() {
        loadCategories();
    }

    public void adaugaCategorie(Categorie categorie) {
        categorie.setId((long) (categorii.size() + 1));
        categorii.add(categorie);
        saveCategories();
    }

    public List<Categorie> getAllCategorii() {
        return categorii;
    }

    public Optional<Categorie> getCategorieById(Long id) {
        return categorii.stream()
                .filter(categorie -> categorie.getId().equals(id))
                .findFirst();
    }

    private void saveCategories() {
        try {
            objectMapper.writeValue(new File(filePath), categorii);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadCategories() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                List<Categorie> loadedCategories = objectMapper.readValue(file, new TypeReference<List<Categorie>>() {});
                categorii.addAll(loadedCategories);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
