# BookMania

BookMania is a web application for managing and viewing books, categories, and the shopping cart. The project is developed in Java using Spring Boot.

## Project Structure

```
src/main/java/com/example/BookMania/
├── controller/       # Application controllers (Admin, Auth, Books)
├── model/            # Data models (Book, Category, User, etc.)
├── repository/       # Data access classes (BookRepository, etc.)
└── util/             # Utilities (e.g., JsonUtility)

src/main/resources/
├── templates/        # HTML templates for the web interface
└── static/css/       # CSS files for styling

books.json            # Book data
categories.json       # Category data
```

## Installation and Running

### Requirements

- Java 17+
- Maven

### Clone and Build

```bash
git clone <repo>
cd BookMania
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```
or
```bash
./mvnw spring-boot:run
```

### Access the Application

Open your browser at: [http://localhost:8080](http://localhost:8080)

## Main Features

- User authentication
- Book and category management
- View and add to shopping cart

## Note

This project uses JSON files for data storage. To ensure data persistence, make sure that the `books.json` and `categories.json` files exist in the main directory.

---

> For further details or questions, please open an issue or contact the author.