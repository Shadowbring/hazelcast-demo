package com.dbezruk.hzdemo.repository;

import com.dbezruk.hzdemo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, String> {
}
