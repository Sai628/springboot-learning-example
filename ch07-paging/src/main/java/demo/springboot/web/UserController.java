package demo.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.springboot.domain.User;
import demo.springboot.service.UserService;


/**
 * 用户控制层
 */
@RestController
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    UserService userService;


    /**
     * 获取用户分页列表
     *
     * 处理 "/users" 的 GET 请求, 用来获取用户分页列表
     * 通过 @RequestParam 传递参数, 进一步实现条件查询或者分页查询
     *
     * @param pageable 支持的分页参数如下:
     *                 page - 当前页 从0开始
     *                 size - 每页大小. 默认值在 application.properties 配置
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> getUserPage(Pageable pageable)
    {
        return userService.findByPage(pageable);
    }


    /**
     * 创建用户
     *
     * 处理 "/users/create" 的 POST 请求, 用来新增用户
     * 通过 @RequestBody 绑实体类参数
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User postUser(@RequestBody User user)
    {
        return userService.insertByUser(user);
    }
}
