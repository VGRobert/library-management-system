package com.example.library_management_system;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.model.Category;
import com.example.library_management_system.repository.BookRepository;
import com.example.library_management_system.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(CategoryRepository categoryRepository, BookRepository bookRepository) {
        return args -> {
            // Clear existing data
            bookRepository.deleteAll();
            categoryRepository.deleteAll();

            // Insert new data
            Category sciFi = new Category("Science Fiction");
            Category fantasy = new Category("Fantasy");
            Category nonFiction = new Category("Non-Fiction");

            // Save categories and obtain their IDs
            sciFi = categoryRepository.save(sciFi);
            fantasy = categoryRepository.save(fantasy);
            nonFiction = categoryRepository.save(nonFiction);

            // Now create and save books with the correct category IDs
            bookRepository.save(new Book("Dune", "Frank Herbert", "9780441172719", 5, sciFi));
            bookRepository.save(new Book("The Hobbit", "J.R.R. Tolkien", "9780345339683", 3, fantasy));
            bookRepository.save(new Book("Sapiens", "Yuval Noah Harari", "9780062316097", 7, nonFiction));
        };
    }
}
