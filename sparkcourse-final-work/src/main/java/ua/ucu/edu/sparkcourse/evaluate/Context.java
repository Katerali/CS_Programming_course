package ua.ucu.edu.sparkcourse.evaluate;

import com.google.common.collect.Sets;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Context implements Serializable {

    private Map<Integer, String> events;

    private Map<String, Set<String>> teams;


    public Map<String, Set<String>> getTeams() {
        return teams;
    }

    public void setTeams(Map<String, Set<String>> teams) {
        this.teams = teams;
    }

    public Map<Integer, String> getEvents() {
        return events;
    }

    public void setEvents(Map<Integer, String> events) {
        this.events = events;
    }

    public Set<String> getAllPlayers() {
        if (teams == null) {
            return Collections.emptySet();
        }
        Set<String> allPlayers = Sets.newHashSet();
        for (Set<String> players : teams.values()) {
            allPlayers.addAll(players);
        }
        return allPlayers;
    }
}
