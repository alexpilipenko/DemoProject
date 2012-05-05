package iwbcan.jobassist.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/2/12
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Groups {
    private Long id;
    private String name;

    private Set<UserRepository> users = new HashSet<UserRepository>();
    private Set<Authority> authorities = new HashSet<Authority>();


    public Groups() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRepository> getUsers() {
        return users;
    }

    public void setUsers(Set<UserRepository> users) {
        this.users = users;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
