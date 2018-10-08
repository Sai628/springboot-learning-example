package demo.springboot.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;


/**
 * Book 业务层实现
 */
@Service
public class BookServiceImpl implements BookService
{

    // 模拟数据库, 存储 Book 信息
    private static Map<Long, Book> BOOK_DB = new HashMap<>();


    @Override
    public List<Book> findAll()
    {
        return new ArrayList<>(BOOK_DB.values());
    }


    @Override
    public Book insertByBook(Book book)
    {
        book.setId(BOOK_DB.size() + 1L);
        BOOK_DB.put(book.getId(), book);
        return book;
    }


    @Override
    public Book update(Book book)
    {
        BOOK_DB.put(book.getId(), book);
        return book;
    }


    @Override
    public Book delete(Long id)
    {
        return BOOK_DB.remove(id);
    }


    @Override
    public Book findById(Long id)
    {
        return BOOK_DB.get(id);
    }
}
