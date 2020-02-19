package com.allbreakers.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HashCodeTest {
    private final HashCodeTeams hashCodeTeams = HashCodeTeams.create();

    @Test
    void shouldFindTheBestTeam() {
        Team actual = hashCodeTeams.findTheBest();

        assertThat(actual.name()).isEqualTo("All Breakers");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Jaroslaw Zembal", "Maciej Kauf", "Marcin Pancerz", "Sebastian Malaca"})
    void theBestTeamShouldContain(String member) {
        List<String> actual = hashCodeTeams.findTheBest().members();

        assertThat(actual).contains(member);
    }

    @Test
    void theBestTeamShouldContainAll() {
        List<String> actual = hashCodeTeams.findTheBest().members();

        assertThat(actual).containsOnly("Jaroslaw Zembal", "Maciej Kauf", "Marcin Pancerz", "Sebastian Malaca");
    }
}