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

    @CrossOrigin
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getListBook()
    {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED    );
    }

    @CrossOrigin
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookRepository.deleteById(id);
        return new ResponseEntity<>("Delete", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "/{id}", method = RequestMethod.GET  )
    public ResponseEntity<?> findBook(@PathVariable("id") Long id){
        return new ResponseEntity<>(bookRepository.findById(id),HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(path = "/edit", method = RequestMethod.PUT  )
    public ResponseEntity<?> editBook(@RequestBody Book book){
        return new ResponseEntity<>(bookRepository.save(book),HttpStatus.OK);
    }
}
