package cn.celadon.travel.canada.domin.authentication;

import cn.celadon.travel.canada.domin.webTemplates.DynamicWebContentMapping;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by empqqty on 7/29/2017.
 */
@Entity
@Table(name = "user_role_info")
public class UserRoleInfo {
    private long id;
    private UserInfo userInfo;
    private RoleInfo roleInfo;

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,  targetEntity = UserInfo.class)
    @JoinColumn(name = "user_id")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER,  targetEntity = RoleInfo.class)
    @JoinColumn(name = "role_info")
    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo roleInfo) {
        this.roleInfo = roleInfo;
    }
}
