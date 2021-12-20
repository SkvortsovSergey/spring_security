package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
@Service("userDetailsServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDao dao;

    public UserDetailServiceImpl (UserDao dao) {
        this.dao = dao;
    }

    @Override
    public UserDetails loadUserByUsername (String s) throws UsernameNotFoundException {
        return dao.getUserByLogin(s);
    }
}
