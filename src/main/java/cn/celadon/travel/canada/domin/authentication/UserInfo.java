package cn.celadon.travel.canada.domin.authentication;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by empqqty on 7/29/2017.
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
    private Long id;
    private String userName;
    private String password;

    @Id
    @GeneratedValue(generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
