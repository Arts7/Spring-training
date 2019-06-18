package com.wildcodeschool.library.controller;

import java.util.List;
import java.util.Map;

import com.wildcodeschool.library.entities.Book;
import com.wildcodeschool.library.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @DeleteMapping("/books/{id}")
    public boolean deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
        return true;
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        Book bookToUpdate = bookRepository.findById(id).get();
        if (book.getTitle() != null) {
            bookToUpdate.setTitle(book.getTitle());
        }

        if (book.getAuthor() != null) {
            bookToUpdate.setAuthor(book.getAuthor());
        }

        if (book.getDescription() != null) {
            bookToUpdate.setDescription(book.getDescription());
        }
        return bookRepository.save(book);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    
    
}