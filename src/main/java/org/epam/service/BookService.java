package org.epam.service;

import org.epam.dao.Dao;
import org.epam.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    Dao dao;

    public List<Book> getAllBooksService(){
        return dao.getListOfBooks();
    }

    public Book getBookByIdService(String book_id){
        int id = stringToIntId(book_id);

        Book book;
        if(dao.hasBookById(id)){
            book = dao.getBookById(id);
        } else{
            throw new IllegalArgumentException("Book Does Not Exist");
        }
        return book;
    }

    public Book addNewBookService(Book book){
        return dao.addBook(book);
    }

    public Book deleteBookService(String book_id){
        int id = stringToIntId(book_id);
        Book book;
        if(dao.hasBookById(id)){
            book = dao.deleteBook(id);
        } else{
            throw new IllegalArgumentException("Book Does Not Exist");
        }
        return book;
    }

    public Book updateBookService(String book_id, Book book){
        int id = stringToIntId(book_id);
        book.setBookId(id);
        dao.updateBook(id, book);
        return book;
    }

    public int stringToIntId(String book_id){
        int id;
        try{
            id = Integer.parseInt(book_id);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("Not a Number.");
        }
        return id;
    }


}
