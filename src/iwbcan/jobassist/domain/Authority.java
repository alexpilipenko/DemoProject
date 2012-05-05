package iwbcan.jobassist.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/2/12
 * Time: 11:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Authority implements GrantedAuthority {
    private Long id;
    private String name;

    private Set<UserRepository> users = new HashSet<UserRepository>();
    private Set<Groups> groups = new HashSet<Groups>();

    public Authority() {}

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

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }

    public Set<UserRepository> getUsers() {

        return users;
    }

    public void setUsers(Set<UserRepository> users) {
        this.users = users;
    }

    public String getAuthority() {
        return getName();
    }
}
