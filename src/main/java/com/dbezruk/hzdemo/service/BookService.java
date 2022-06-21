package com.dbezruk.hzdemo.service;

import com.dbezruk.hzdemo.domain.Book;
import com.dbezruk.hzdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Cacheable("books")
    public List<Book> findAll() throws InterruptedException {
        Thread.sleep(5000);
        return bookRepository.findAll();
    }

    @Cacheable("books")
    public Book findOne(String isbn) {
        var optionalBook = bookRepository.findById(isbn);
        return optionalBook.orElse(null);
    }

    @CacheEvict("books")
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
