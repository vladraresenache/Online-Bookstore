# BookMania

BookMania este o aplicație web pentru gestionarea și vizualizarea cărților, categoriilor și a coșului de cumpărături. Proiectul este realizat în Java folosind Spring Boot.

## Structura proiectului

- `src/main/java/com/example/BookMania/` - Codul sursă principal
  - `controller/` - Controlerele aplicației (Admin, Auth, Carti)
  - `model/` - Modele de date (Carte, Categorie, Utilizator, etc.)
  - `repository/` - Clase pentru accesul la date (RepositoryCarte, etc.)
  - `util/` - Utilitare (ex: UtilitateJson)
- `src/main/resources/`
  - `templates/` - Șabloane HTML pentru interfața web
  - `static/css/` - Fișiere CSS pentru stilizare
- `books.json`, `categorii.json` - Datele aplicației

## Instalare și rulare

1. **Cerințe:**
   - Java 17+
   - Maven

2. **Clonare și build:**
   ```bash
   git clone <repo>
   cd BookMania
   mvn clean install
   ```

3. **Rulare aplicație:**
   ```bash
   mvn spring-boot:run
   ```
   sau
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Accesare aplicație:**
   Deschide browserul la: [http://localhost:8080](http://localhost:8080)

## Funcționalități principale
- Autentificare utilizator
- Administrare cărți și categorii
- Vizualizare și adăugare în coș

## Notă
Acest proiect folosește fișiere JSON pentru stocarea datelor. Pentru date persistente, asigură-te că fișierele `books.json` și `categorii.json` există în directorul principal.

---

> Pentru detalii suplimentare sau întrebări, te rog să deschizi un issue sau să contactezi autorul. 