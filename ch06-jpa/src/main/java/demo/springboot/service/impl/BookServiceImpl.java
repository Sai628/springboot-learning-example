package demo.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;


/**
 * Book 业务层实现
 */
@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }


    @Override
    public Book insertByBook(Book book)
    {
        return bookRepository.save(book);
    }


    @Override
    public Book update(Book book)
    {
        return bookRepository.save(book);
    }


    @Override
    public Book delete(Long id)
    {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }


    @Override
    public Book findById(Long id)
    {
        return bookRepository.findById(id).get();
    }
}
