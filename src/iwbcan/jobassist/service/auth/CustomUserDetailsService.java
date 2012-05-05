package iwbcan.jobassist.service.auth;

import org.apache.log4j.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import iwbcan.jobassist.dao.UserDAO;
import iwbcan.jobassist.domain.UserRepository;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/20/12
 * Time: 1:35 AM
 * To change this template use File | Settings | File Templates.
 */
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
    private Logger logger = Logger.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserDAO userDAO;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UserDetails userDetails = null;

        try {
            UserRepository userRepository = userDAO.getUserByUsername(username);

            userDetails = new User(
                userRepository.getUsername(),
                userRepository.getPassword(),
                userRepository.isEnabled(),
                true,
                true,
                true,
                userRepository.getAuthorities()
            );
        }
        catch(Exception e){

        }

        return userDetails;
    }
}
