package iwbcan.jobassist.domain;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: alexpilipenko
 * Date: 2/2/12
 * Time: 12:42 AM
 * To change this template use File | Settings | File Templates.
 */

public class UserRepository {
    private Long id;
    private String username;
    private String password;
    private boolean enabled;

    private Set<Authority> authorities = new HashSet<Authority>();
    private Set<Groups> groups = new HashSet<Groups>();


    public UserRepository() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }
}
