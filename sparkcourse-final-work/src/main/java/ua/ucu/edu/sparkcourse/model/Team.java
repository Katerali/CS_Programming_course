package ua.ucu.edu.sparkcourse.model;

import java.io.Serializable;
import java.util.Set;

public class Team implements Serializable {

    private String country;
    private Set<String> players;


    public Team(String country, Set<String> players) {
        this.country = country;
        this.players = players;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<String> getPlayers() {
        return players;
    }

    public void setPlayers(Set<String> players) {
        this.players = players;
    }
}
