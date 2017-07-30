package cn.celadon.travel.canada.domin.authentication;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by empqqty on 7/29/2017.
 */
@Entity
@Table(name = "role_info")
public class RoleInfo {
    private long id;
    private String roleName;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
