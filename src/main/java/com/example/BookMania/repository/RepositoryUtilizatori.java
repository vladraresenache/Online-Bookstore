/** Clasa pentru Repository de Utilizator
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */

package com.example.BookMania.repository;

import com.example.BookMania.model.Utilizator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryUtilizatori {
    private final List<Utilizator> utilizatori = new ArrayList<>();

    public RepositoryUtilizatori() {

        utilizatori.add(new Utilizator("admin", "admin123", "ADMIN"));
        utilizatori.add(new Utilizator("user", "user123", "USER"));
    }

    public Utilizator gasesteDupaUsername(String username) {
        return utilizatori.stream()
                .filter(utilizator -> utilizator.getNumeUtilizator().equals(username))
                .findFirst()
                .orElse(null);
    }
}
