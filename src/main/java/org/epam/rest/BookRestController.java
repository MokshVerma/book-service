package org.epam.rest;

import org.epam.entity.Book;
import org.epam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    BookService bookService;

    // books       GET       List of all books      GENERAL
    @GetMapping("books")
    public ResponseEntity<List<Book>> getAllBooksRest(){
        ResponseEntity<List<Book>> listResponseEntity;

        try{
            List<Book> list = bookService.getAllBooksService();
            listResponseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return listResponseEntity;
    }

    @GetMapping("books/{book_id}")
    public ResponseEntity<Book> getBookByIdRest(@PathVariable String book_id){
        ResponseEntity<Book> bookResponseEntity;

        try{
            Book book = bookService.getBookByIdService(book_id);
            bookResponseEntity = new ResponseEntity<>(book, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return bookResponseEntity;
    }

    @PostMapping("books")
    public ResponseEntity<Book> addNewBookRest(@RequestBody Book book){
        ResponseEntity<Book> responseEntity;

        try{
            bookService.addNewBookService(book);
            responseEntity = new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return responseEntity;
    }

    @DeleteMapping("books/{book_id}")
    public ResponseEntity<Book> deleteBookRest(@PathVariable String book_id){
        ResponseEntity<Book> bookResponseEntity;

        try{
            Book book = bookService.deleteBookService(book_id);
            bookResponseEntity = new ResponseEntity<>(book, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return bookResponseEntity;
    }

    @PutMapping("books/{book_id}")
    public ResponseEntity<Book> updateBookRest(@PathVariable String book_id, @RequestBody Book book){
        ResponseEntity<Book> bookResponseEntity;
        try{
            Book newBook = bookService.updateBookService(book_id, book);
            bookResponseEntity = new ResponseEntity<>(newBook, HttpStatus.OK);
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return bookResponseEntity;
    }




}
