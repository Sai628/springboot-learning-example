package demo.springboot.service;

import java.util.List;

import demo.springboot.domain.User;


/**
 * User 业务层接口
 */
public interface UserService
{
    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
