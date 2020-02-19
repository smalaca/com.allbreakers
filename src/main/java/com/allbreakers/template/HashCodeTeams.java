package com.allbreakers.template;

import java.util.ArrayList;
import java.util.List;

class HashCodeTeams {
    private final List<Team> teams = new ArrayList<>();

    private HashCodeTeams() {}

    static HashCodeTeams create() {
        Team allBreakers = new Team("All Breakers");
        allBreakers.add("Jaroslaw Zembal");
        allBreakers.add("Maciej Kauf");
        allBreakers.add("Marcin Pancerz");
        allBreakers.add("Sebastian Malaca");

        HashCodeTeams hashCodeTeams = new HashCodeTeams();
        hashCodeTeams.register(allBreakers);
        return hashCodeTeams;
    }

    private void register(Team team) {
        teams.add(team);
    }

    Team findTheBest() {
        return teams.get(0);
    }
}
