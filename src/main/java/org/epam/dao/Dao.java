package org.epam.dao;

import org.epam.entity.Book;

import java.util.HashMap;
import java.util.List;

public interface Dao {

    List<Book> getListOfBooks();
    Book getBookById(int id);
    Book addBook(Book book);
    Book deleteBook(int id);
    void updateBook(int id, Book updatedBook);
    boolean hasBookById(int id);

}
