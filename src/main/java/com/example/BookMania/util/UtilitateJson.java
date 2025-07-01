/** Clasa de utilitate pentru parsarea si memorarea in documente JSON
 * @author Enache Vlad-Rares
 * @version 6 ianuarie 2025
 */
package com.example.BookMania.util;

import com.example.BookMania.model.Carte;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UtilitateJson {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String filePath = "books.json";

    public List<Carte> citesteCarti() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Carte.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void scrieCarti(List<Carte> carti) {
        try {
            objectMapper.writeValue(new File(filePath), carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
