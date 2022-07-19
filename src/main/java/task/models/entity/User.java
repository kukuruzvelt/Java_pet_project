package task.models.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private int role_id;
    private long money;
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class UserBuilder {
        private User newUser;

        public UserBuilder() {
            newUser = new User();
        }

        public UserBuilder withId(int id) {
            newUser.id = id;
            return this;
        }

        public UserBuilder withEmail(String email) {
            newUser.email = email;
            return this;
        }

        public UserBuilder withName(String name) {
            newUser.name = name;
            return this;
        }

        public UserBuilder withSurname(String surname) {
            newUser.surname = surname;
            return this;
        }

        public UserBuilder withPassword(String password) {
            newUser.password = password;
            return this;
        }

        public UserBuilder withRole(int role_id) {
            newUser.role_id= role_id;
            return this;
        }

        public UserBuilder withMoney(long money) {
            newUser.money = money;
            return this;
        }

        public UserBuilder withRating(int rating) {
            newUser.rating = rating;
            return this;
        }

        public User build() {
            return newUser;
        }
    }

}
