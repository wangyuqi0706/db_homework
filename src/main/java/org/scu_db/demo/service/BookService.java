package org.scu_db.demo.service;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Title;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();
    List<Book> findBookById(Integer Id);
    List<Book> findBookByIdUseSql(Integer Id);

    List<Integer> findAllBorrowedBook();
    List<Title> findTargetTitle();
    Integer countCall123();
    List<String> findCallNumberLessThan2();

}
