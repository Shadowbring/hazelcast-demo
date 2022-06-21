package com.dbezruk.hzdemo;

import com.dbezruk.hzdemo.domain.Book;
import com.dbezruk.hzdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;
import java.util.UUID;

@EnableCaching
@SpringBootApplication
@RequiredArgsConstructor
public class HazelcastDemoApplication implements CommandLineRunner {

    private static final List<Book> INITIAL_BOOKS = List.of(
            new Book(UUID.randomUUID().toString(), "Me", "About me", 100500L),
            new Book(UUID.randomUUID().toString(), "Someone else", "About someone else", 1050L),
            new Book(UUID.randomUUID().toString(), "Me", "Rusni pizda!", 1000050000L)
    );

    private final BookRepository bookRepository;

    public static void main(String[] args) {
        System.setProperty("hazelcast.jcache.provider.type", "member");
        SpringApplication.run(HazelcastDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        bookRepository.saveAll(INITIAL_BOOKS);
    }
}
