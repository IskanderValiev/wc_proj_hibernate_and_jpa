package models;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "player_number")
    private int number;

    @Column(name = "player_position")
    private String position;

    @Column(name = "player_name")
    private String name;

    @Column(name = "player_lastname")
    private String lastname;

    @Column(name = "player_age")
    private int age;

    @Column(name = "player_photo")
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_country_id")
    private Country country;

    public Player(){}

    public Player(int number, String position, String name, String lastname, int age, String photo, Club club, Country country) {
        this.number = number;
        this.position = position;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.photo = photo;
        this.club = club;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }

    public Club getClub() {
        return club;
    }

    public Country getCountry() {
        return country;
    }

    public static Builder builder() {
        return new Player().new Builder();
    }

    public class Builder {
        private Builder() {}

        public Builder number(int number) {
            Player.this.number = number;
            return this;
        }

        public Builder position(String position) {
            Player.this.position = position;
            return this;
        }

        public Builder name(String name) {
            Player.this.name = name;
            return this;
        }

        public Builder lastname(String lastname) {
            Player.this.lastname = lastname;
            return this;
        }

        public Builder age(int age) {
            Player.this.age = age;
            return this;
        }

        public Builder photo(String photo) {
            Player.this.photo = photo;
            return this;
        }

        public Builder club(Club club) {
            Player.this.club = club;
            return this;
        }

        public Builder country(Country country) {
            Player.this.country = country;
            return this;
        }
    }
}
