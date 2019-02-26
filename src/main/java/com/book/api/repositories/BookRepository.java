package com.book.api.repositories;

import com.book.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select  distinct b from Book b where  b.name like %:value% or b.price like %:value%")
    List<Book> findBooks(@Param("value") String value);
}
