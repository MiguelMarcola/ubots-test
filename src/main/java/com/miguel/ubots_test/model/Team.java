package com.miguel.ubots_test.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Team {
    private String name;
    private List<Agent> agents = new ArrayList<>();
    private Queue<Solicitation> queue = new LinkedList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void distributeSolicitation(Solicitation solicitation) {
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                agent.addSolicitation(solicitation);
                return;
            }
        }
        queue.add(solicitation);
    }

    public void processQueue() {
        while (!queue.isEmpty()) {
            Solicitation solicitation = queue.poll();
            distributeSolicitation(solicitation);
        }
    }
}
