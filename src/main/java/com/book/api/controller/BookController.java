package com.book.api.controller;

import com.book.api.entities.Book;
import com.book.api.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getListBook()
    {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@RequestParam Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>("Delete", HttpStatus.OK);
    }
}
