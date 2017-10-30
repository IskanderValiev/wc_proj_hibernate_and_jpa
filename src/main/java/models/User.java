package models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by isko on 9/24/17.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password", insertable = false, updatable = false)
    private String password;

    @Column(name = "name", insertable = false, updatable = false)
    private String name;

    @Column(name = "lastname", insertable = false, updatable = false)
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "bday")
    private Date bday;

    @Column(name = "city")
    private String city;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "photo")
    private String photo;

    @Column(name = "salt")
    private String salt;

    @Column(name = "status")
    private Boolean isAdmin;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public Date getBday() {
        return bday;
    }

    public String getCity() {
        return city;
    }

    public boolean isGender() {
        return gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSalt() {
        return salt;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public static Builder builder() {
        return new User().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder login(String login) {
            User.this.login = login;
            return this;
        }

        public Builder password(String password) {
            User.this.password = password;
            return this;
        }

        public Builder name(String name) {
            User.this.name = name;
            return this;
        }

        public Builder lastname(String lastName) {
            User.this.lastname = lastName;
            return this;
        }

        public Builder gender(boolean gender) {
            User.this.gender = gender;
            return this;
        }

        public Builder bday(Date bday) {
            User.this.bday = bday;
            return this;
        }

        public Builder city(String city) {
            User.this.city = city;
            return this;
        }

        public Builder telephone(String telephone) {
            User.this.telephone = telephone;
            return this;
        }

        public Builder email(String email) {
            User.this.email = email;
            return this;
        }

        public Builder photo(String photo) {
            User.this.photo = photo;
            return this;
        }

        public Builder salt(String salt) {
            User.this.salt = salt;
            return this;
        }

        public User build() {
            return User.this;
        }

    }
}
