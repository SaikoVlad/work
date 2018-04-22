package by.bntu.fitr.povt.prostrmk.ItNews.model.entity.beans;

import org.springframework.context.annotation.Bean;

public class UserRoles {

    @Bean
    public static UserRoles initUser(Role role){
        switch (role){
            case ANON:return new UserRoles(0);
            case USER:return new UserRoles(1);
            case ADMIN:return new UserRoles(2);
        }
        return null;
    }

    private int role;
    private String username;


    private UserRoles() {
    }

    private UserRoles(int role) {
        this.role = role;
        if (role == 0){
            username = "anon";
        }
    }

    private UserRoles(int role, String username){
        this.role = role;
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
