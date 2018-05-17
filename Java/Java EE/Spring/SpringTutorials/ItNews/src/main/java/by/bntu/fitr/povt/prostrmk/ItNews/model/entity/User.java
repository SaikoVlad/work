package by.bntu.fitr.povt.prostrmk.ItNews.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode() && obj instanceof User;
    }

    @Override
    public int hashCode() {
        final int hashConst = 31;
        int result = 1;
//        result = (int) (hashConst * result + id);
        result = hashConst * result + username.hashCode();
        result = hashConst * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("User{\n id= '%s', username= '%s' , password= '%s' }",id,username,password);
    }
}
