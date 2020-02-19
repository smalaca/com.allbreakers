package com.allbreakers.template;

import java.util.ArrayList;
import java.util.List;

class Team {
    private final String name;
    private final List<String> members = new ArrayList<>();

    Team(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    List<String> members() {
        return members;
    }

    void add(String member) {
        members.add(member);
    }
}
