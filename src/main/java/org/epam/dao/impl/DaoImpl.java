package org.epam.dao.impl;

import org.epam.dao.Dao;
import org.epam.entity.Book;
import org.epam.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class DaoImpl implements Dao {

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getListOfBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        Book book = null;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        System.out.println("DAO" + book.toString());
        return bookRepo.save(book);
    }

    @Override
    public Book deleteBook(int id) {
        Book tempBook = getBookById(id);
        if (tempBook != null) {
            bookRepo.delete(tempBook);
        }
        return tempBook;
    }

    @Override
    public void updateBook(int id, Book updatedBook) {
        bookRepo.save(updatedBook);
    }

    @Override
    public boolean hasBookById(int id){
        return bookRepo.existsById(id);
    }
}