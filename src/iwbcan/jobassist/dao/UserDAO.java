package iwbcan.jobassist.dao;

import iwbcan.jobassist.domain.UserRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/19/12
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public UserRepository getUserByUsername(String username) {
        return (UserRepository)hibernateTemplate.getSessionFactory().getCurrentSession()
                .createCriteria(UserRepository.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult();
    }


}
