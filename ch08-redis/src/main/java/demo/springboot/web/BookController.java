package demo.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;


/**
 * Book 控制层
 */
@Controller
@RequestMapping(value = "/book")
public class BookController
{
    private static final String BOOK_FORM_PATH_NAME = "bookForm";
    private static final String BOOK_LIST_PATH_NAME = "bookList";
    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";


    @Autowired
    BookService bookService;


    /**
     * 获取 Book 列表
     *
     * 处理 "/book" 的 GET 请求, 用来获取 Book 列表.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map)
    {
        map.addAttribute("bookList", bookService.findAll());
        return BOOK_LIST_PATH_NAME;
    }


    /**
     * 获取创建 Book 表单
     *
     * 处理 "/book/create" 的 GET 请求, 显示创建 Book 表单
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap map)
    {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return BOOK_FORM_PATH_NAME;
    }


    /**
     * 创建 Book
     *
     * 处理 "/book/create" 的 POST 请求, 创建 Book 成功后, 跳转至 Book 列表页面.
     * 通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@ModelAttribute Book book)
    {
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }


    /**
     * 显示更新 Book 表单
     *
     * 处理 "/book/update/{id}" 的 GET 请求, 通过 URL 中的 id 值获取 Book 信息.
     * URL 中的 id, 通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable Long id, ModelMap map)
    {
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return BOOK_FORM_PATH_NAME;
    }


    /**u
     * 更新 Book 信息
     *
     * 处理 "/book/update" 的 PUT 请求, 用来更新 Book 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBook(@ModelAttribute Book book)
    {
        bookService.update(book);
        return REDIRECT_TO_BOOK_URL;
    }


    /**
     * 删除 Book
     *
     * 处理 "/book/delete/{id}" 的 GET 请求, 用来删除 Book 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable Long id)
    {
        bookService.delete(id);
        return REDIRECT_TO_BOOK_URL;
    }
}
