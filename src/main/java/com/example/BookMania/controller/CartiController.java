/** Clasa pentru Controller-ul pentru pagina principala
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.controller;

import com.example.BookMania.model.Carte;
import com.example.BookMania.model.ElementCos;
import com.example.BookMania.repository.RepositoryCarte;
import com.example.BookMania.repository.RepositoryCos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CartiController {

    private final RepositoryCarte repositoryCarte;
    private final RepositoryCos repositoryCos;

    @Autowired
    public CartiController(RepositoryCarte repositoryCarte, RepositoryCos repositoryCos) {
        this.repositoryCarte = repositoryCarte;
        this.repositoryCos = repositoryCos;
    }

    @GetMapping("/")
    public String index(Model model) {
        int numarArticoleCos = repositoryCos.getNumarElementeCos();
        model.addAttribute("numarArticoleCos", numarArticoleCos);
        List<Carte> carti = repositoryCarte.getAllCarti();
        model.addAttribute("carti", carti);
        return "index";
    }

    @GetMapping("/cart")
    public String vizualizareCos(Model model) {
        List<ElementCos> articoleCos = repositoryCos.getElementeCos();
        model.addAttribute("articoleCos", articoleCos);
        model.addAttribute("totalCos", repositoryCos.getTotalCos());
        return "cart-view";
    }

    @PostMapping("/cart/add")
    public String adaugaInCos(@RequestParam Long idCarte, Model model) {
        Optional<Carte> carteOpt = repositoryCarte.getCarteById(idCarte);
        if (carteOpt.isPresent()) {
            Carte carte = carteOpt.get();
            repositoryCos.adaugaInCos(carte.getId(), carte.getTitlu(), carte.getAutor(), carte.getPret());
        } else {
            model.addAttribute("eroare", "Cartea nu a fost găsită.");
        }
        return "redirect:/";
    }

    @PostMapping("/cart/remove")
    public String eliminaDinCos(@RequestParam Long idCarte) {
        repositoryCos.stergeDinCos(idCarte);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String actualizeazaCos(@RequestParam Long idCarte, @RequestParam int cantitate, Model model) {
        if (cantitate < 1) {
            model.addAttribute("eroare", "Cantitatea trebuie să fie cel puțin 1.");
            return "redirect:/cart";
        }
        repositoryCos.actualizeazaCantitate(idCarte, cantitate);
        return "redirect:/cart";
    }

    @PostMapping("/cart/clear")
    public String golesteCos() {
        repositoryCos.golesteCos();
        return "redirect:/cart";
    }


    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        List<Carte> carti = repositoryCarte.searchCarti(query);
        int numarArticoleCos = repositoryCos.getNumarElementeCos();
        model.addAttribute("numarArticoleCos", numarArticoleCos);
        model.addAttribute("carti", carti);
        return "index";
    }
}
