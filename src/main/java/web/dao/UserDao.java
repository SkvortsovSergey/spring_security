package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void update(User user,long id);
    User getUserById(long id);
    User getUserByLogin(String login);
}
