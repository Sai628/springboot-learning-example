package demo.springboot.service;

import java.util.List;

import demo.springboot.domain.Book;


/**
 * Book 业务层接口
 */
public interface BookService
{
    List<Book> findAll();

    Book insertByBook(Book book);

    Book update(Book book);

    Book delete(Long id);

    Book findById(Long id);
}
