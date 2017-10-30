package models;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "club_name")
    private String name;

    @Column(name = "club_country_id")
    private int country;

    @Column(name = "club_logo")
    private String logo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "club")
    private Set<Player> players;

    public Club() {}

    public Club(String name, int country, String logo, Set<Player> players) {
        this.name = name;
        this.country = country;
        this.logo = logo;
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCountry() {
        return country;
    }

    public String getLogo() {
        return logo;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public static Builder build() {
        return new Club().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder name(String name) {
            Club.this.name = name;
            return this;
        }

        public Builder country(Integer countryId) {
            Club.this.country = countryId;
            return this;
        }

        public Builder logo(String logo) {
            Club.this.logo = logo;
            return this;
        }
    }
}
