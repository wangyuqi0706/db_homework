package org.scu_db.demo.Repository;

import org.scu_db.demo.model.Book;
import org.scu_db.demo.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //继承于JpaRepository,其中Title为对应的实体类，String为实体类主键属性

    List<Book> findBooksByBookId(Integer bookId);

    @Query(value = "select * from book where book_id =?1", nativeQuery = true)
    List<Book> findBookByIdUseSql(Integer bookId);

    @Query(value = "select book_id from Book where borrowermemno is not null", nativeQuery = true)
    List<Integer> findAllBorrowedBook();

    @Query(value = "SELECT * FROM Title WHERE CallNumber in (SELECT CallNumber FROM Book WHERE Name = 'Iliad' OR Name = 'Odyssey')", nativeQuery = true)
    List<Title> findTargetTitle();

    @Query(value = "SELECT COUNT(callnumber) FROM Book WHERE callnumber = 'Call123'")
    Integer countCall123();

    @Query(value = "SELECT callnumber FROM Book GROUP BY callnumber HAVING COUNT(callnumber)<=2")
    List<String> findCallNumberLessThan2();

}
