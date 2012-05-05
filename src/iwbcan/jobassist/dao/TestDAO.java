package iwbcan.jobassist.dao;

import iwbcan.jobassist.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/18/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Transactional
public class TestDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Test> getTestList() {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createCriteria(Test.class).list();
    }
}
