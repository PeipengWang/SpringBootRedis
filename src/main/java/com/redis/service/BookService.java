package com.redis.service;

import com.redis.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class BookService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String BOOK_KEY_PREFIX = "book:";

    public void saveBook(Book book) {
        redisTemplate.opsForValue().set(BOOK_KEY_PREFIX + book.getId(), book, 10, TimeUnit.MINUTES);
    }

    public Book getBook(String id) {
        return (Book) redisTemplate.opsForValue().get(BOOK_KEY_PREFIX + id);
    }

    public void deleteBook(String id) {
        redisTemplate.delete(BOOK_KEY_PREFIX + id);
    }
}
