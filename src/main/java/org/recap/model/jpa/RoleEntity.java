package org.recap.model.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by dharmendrag on 29/11/16.
 */
@Entity
@Table(name="roles_t",schema="recap",catalog="")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Integer roleId;

    @Column(name="role_name")
    private String roleName;

    @Column(name="role_description")
    private String roleDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @ElementCollection(targetClass = PermissionEntity.class)
    @JoinTable(name="role_permission_t",joinColumns = {
            @JoinColumn(name="role_id",referencedColumnName = "role_id")},
            inverseJoinColumns = {
                    @JoinColumn(name="permission_id",referencedColumnName = "permission_id")
            })
    private Set<PermissionEntity> permissions;


    @ElementCollection(targetClass = UsersEntity.class)
    @JoinTable(name="user_role_t",joinColumns = {
            @JoinColumn(name="role_id",referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id",referencedColumnName = "user_id")})
    private Set<UsersEntity> users;

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<UsersEntity> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<UsersEntity> users) {
        this.users = users;
    }

    /**
     * Gets role id.
     *
     * @return the role id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Gets permissions.
     *
     * @return the permissions
     */
    public Set<PermissionEntity> getPermissions() {
        return permissions;
    }

    /**
     * Sets permissions.
     *
     * @param permissions the permissions
     */
    public void setPermissions(Set<PermissionEntity> permissions) {
        this.permissions = permissions;
    }
}
