package models;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "country_name")
    private String name;

    @Column(name = "country_flag")
    private String flag;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<Player> players;

    public Country() {}

    public Country(String name, String flag, Set<Player> players) {
        this.name = name;
        this.flag = flag;
        this.players = players;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFlag() {
        return flag;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public static Builder builder() {
        return new Country().new Builder();
    }

    public class Builder {

        private Builder(){}

        public Builder name(String name) {
            Country.this.name = name;
            return this;
        }
    }
}
