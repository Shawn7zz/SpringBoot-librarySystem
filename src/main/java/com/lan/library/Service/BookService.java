package com.lan.library.Service;

import com.lan.library.Entity.Book;
import com.lan.library.Entity.User;
import com.lan.library.api.request.BookCriteria;

import java.util.List;

/**
 * @author Xiang Lan
 * Created on 2019-07-01 10:09
 */
public interface BookService {

    List<Book> getAllBookList();

    Boolean addBook(Book book);

    Boolean borrowBook(Integer userId, Integer bookId);

    Book searchBook(BookCriteria bookCriteria);
}
