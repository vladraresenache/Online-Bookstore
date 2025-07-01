/** Clasa pentru Controller-ul pagini de conectare
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.controller;

import com.example.BookMania.model.Utilizator;
import com.example.BookMania.repository.RepositoryUtilizatori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private RepositoryUtilizatori userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(String username, String password, HttpSession session, Model model) {
        // Validare că username și password nu sunt goale
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            model.addAttribute("error", "Username și parola nu pot fi goale");
            return "login";
        }

        Utilizator user = userRepository.gasesteDupaUsername(username);

        if (user != null && user.getParola().equals(password)) {
            session.setAttribute("user", user); // Salvăm utilizatorul în sesiune
            return user.getRol().equals("ADMIN") ? "redirect:/admin/dashboard" : "redirect:/";
        }

        model.addAttribute("error", "Username sau parolă incorecte");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
