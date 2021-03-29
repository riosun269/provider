package de.kreuzwerker.cdc.userservice;

import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class User {

    private String id;
    private String legacyId;
    private String name;
    private UserRole role;
    private Date lastLogin;
    @Singular
    private List<Friend> friends;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(String legacyId) {
        this.legacyId = legacyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public User(String id, String legacyId, String name, UserRole role, Date lastLogin, List<Friend> friends) {
        this.id = id;
        this.legacyId = legacyId;
        this.name = name;
        this.role = role;
        this.lastLogin = lastLogin;
        this.friends = friends;
    }
}
