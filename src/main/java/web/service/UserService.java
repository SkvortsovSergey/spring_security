package web.service;

import web.model.User;

import java.util.List;

public interface UserService {


    void addUser (User user);

    void removeUserById (long id);

    List<User> getAllUsers ();

    void update (User user,long id);

    User getUserById(long id);
}
