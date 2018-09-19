package demo.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import demo.springboot.domain.User;
import demo.springboot.service.UserService;


/**
 * 用户控制层
 */
@Controller
@RequestMapping(value = "/users")
public class UserController
{
    @Autowired
    UserService userService;


    /**
     * 获取用户列表
     *
     * 处理 "/users" 的 GET 请求, 用来获取用户列表.
     * 通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map)
    {
        map.addAttribute("userList", userService.findAll());
        return "userList";
    }


    /**
     * 显示创建用户表单
     *
     * 处理 "/users/create" 的 GET 请求, 显示创建用户表单
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUserForm(ModelMap map)
    {
        map.addAttribute("user", new User());
        map.addAttribute("action", "create");
        return "userForm";
    }


    /**
     * 创建用户
     *
     * 处理 "/users/create" 的 POST 请求, 创建用户成功后, 跳转至用户列表页面.
     * 通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postUser(ModelMap map,
                           @ModelAttribute @Valid User user,
                           BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            map.addAttribute("action", "create");
            return "userForm";
        }

        userService.insertByUser(user);
        return "redirect:/users/";
    }


    /**
     * 显示需要更新用户表单
     *
     * 处理 "/user/update/{id}" 的 GET 请求, 通过 URL 中的 id 值获取 user 信息.
     * URL 中的 id, 通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map)
    {
        map.addAttribute("user", userService.findById(id));
        map.addAttribute("action", "update");
        return "userForm";
    }


    /**
     * 处理 "/users/update" 的 PUT 请求, 用来更新 User 信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putUser(ModelMap map,
                          @ModelAttribute @Valid User user,
                          BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            map.addAttribute("action", "update");
            return "userForm";
        }

        userService.update(user);
        return "redirect:/users/";
    }


    /**
     * 处理 "/users/delete/{id}" 的 GET 请求, 用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id)
    {
        userService.delete(id);
        return "redirect:/users/";
    }
}
