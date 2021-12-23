package web.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;

public interface UserDao  {

    void addUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void update(User user,long id);
    User getUserById(long id);
    User getUserByUsername (String login);
}
