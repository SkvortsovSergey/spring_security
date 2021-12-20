package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Autowired
    public UserServiceImpl (UserDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void addUser (User user) {
        dao.addUser(user);
    }

    @Override
    public void removeUserById (long id) {
        dao.removeUserById(id);
    }

    @Transactional
    @Override
    public List<User> getAllUsers () {
        return dao.getAllUsers();
    }

    @Transactional
    @Override
    public void update (User user, long id) {
        dao.update(user, id);
    }

    @Transactional
    @Override
    public User getUserById (long id) {
        return dao.getUserById(id);
    }


    }
