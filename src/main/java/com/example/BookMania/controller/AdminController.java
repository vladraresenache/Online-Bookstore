/** Clasa pentru Controller-ul de Admin
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.controller;

import com.example.BookMania.model.Carte;
import com.example.BookMania.model.Categorie;
import com.example.BookMania.repository.RepositoryCarte;
import com.example.BookMania.repository.RepositoryCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RepositoryCarte repoCarte;
    private final RepositoryCategorie repoCategorie;

    @Autowired
    public AdminController(RepositoryCarte repoCarte, RepositoryCategorie repoCategorie) {
        this.repoCarte = repoCarte;
        this.repoCategorie = repoCategorie;
    }

    @GetMapping("/dashboard")
    public String dashboardAdmin(@RequestParam(required = false) String query, Model model) {
        List<Carte> carti;
        if (query != null && !query.isBlank()) {
            carti = repoCarte.searchCarti(query);
        } else {
            carti = repoCarte.getAllCarti();
        }
        model.addAttribute("carti", carti);
        List<Carte> cartiCritice = repoCarte.getAllCarti().stream()
                .filter(Carte::esteStocCritic)
                .collect(Collectors.toList());
        model.addAttribute("cartiCritice", cartiCritice);
        model.addAttribute("categorii", repoCategorie.getAllCategorii());
        return "admin-dashboard";
    }


    @GetMapping("/search")
    public String searchCarti(@RequestParam String query, Model model) {
        List<Carte> cartiGasite = repoCarte.searchCarti(query);
        model.addAttribute("carti", cartiGasite);
        model.addAttribute("categorii", repoCategorie.getAllCategorii());
        return "admin-dashboard";
    }


    @PostMapping("/adauga")
    public String adaugaCarte(@RequestParam String titlu,
                              @RequestParam String autor,
                              @RequestParam double pret,
                              @RequestParam String descriere,
                              @RequestParam int stoc,
                              @RequestParam Long categorieId) {
        Optional<Categorie> optionalCategorie = repoCategorie.getCategorieById(categorieId);
        if (optionalCategorie.isPresent()) {
            Carte carteNoua = new Carte(titlu, autor, pret, descriere, stoc, optionalCategorie.get());
            repoCarte.adaugaCarte(carteNoua);
        }
        return "redirect:/admin/dashboard";
    }


    @PostMapping("/update")
    public String updateCarte(@RequestParam Long id,
                              @RequestParam(required = false) String titlu,
                              @RequestParam(required = false) String autor,
                              @RequestParam(required = false) String descriere,
                              @RequestParam(required = false) Integer stoc,
                              @RequestParam(required = false) Long categorieId) {
        Optional<Carte> optionalCarte = repoCarte.getCarteById(id);
        if (optionalCarte.isPresent()) {
            Carte carteActualizata = optionalCarte.get();
            if (titlu != null && !titlu.isBlank()) carteActualizata.setTitlu(titlu);
            if (autor != null && !autor.isBlank()) carteActualizata.setAutor(autor);
            if (descriere != null && !descriere.isBlank()) carteActualizata.setDescriere(descriere);
            if (stoc != null) carteActualizata.setStoc(stoc);
            if (categorieId != null) {
                Optional<Categorie> optionalCategorie = repoCategorie.getCategorieById(categorieId);
                optionalCategorie.ifPresent(carteActualizata::setCategorie);
            }
            repoCarte.updateCarte(id, carteActualizata);
        }
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/adauga-categorie")
    public String adaugaCategorie(@RequestParam String nume) {
        Categorie categorieNoua = new Categorie(null, nume);
        repoCategorie.adaugaCategorie(categorieNoua);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/sterge/{id}")
    public String stergeCarte(@PathVariable Long id) {
        repoCarte.stergeCarte(id);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/carte/{id}")
    public String getCarte(@PathVariable Long id, Model model) {
        Optional<Carte> optionalCarte = repoCarte.getCarteById(id);
        optionalCarte.ifPresent(carte -> model.addAttribute("carte", carte));
        model.addAttribute("categorii", repoCategorie.getAllCategorii());
        return "detaliu-carte";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
