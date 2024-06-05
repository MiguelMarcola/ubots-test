package com.miguel.ubots_test.model;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String name;
    private List<Solicitation> solicitations = new ArrayList<>();

    public Agent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Solicitation> getSolicitations() {
        return solicitations;
    }

    public boolean isAvailable() {
        return solicitations.size() < 3;
    }

    public void addSolicitation(Solicitation solicitation) {
        if (isAvailable()) {
            solicitations.add(solicitation);
        } else {
            throw new IllegalStateException("Agent is busy");
        }
    }

    public void removeSolicitation(Solicitation solicitation) {
        solicitations.remove(solicitation);
    }
}
