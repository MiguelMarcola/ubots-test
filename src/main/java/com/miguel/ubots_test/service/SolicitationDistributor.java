package com.miguel.ubots_test.service;

import com.miguel.ubots_test.model.Solicitation;
import com.miguel.ubots_test.model.Team;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SolicitationDistributor {
    private Map<String, Team> teams = new HashMap<>();

    public void addTeam(Team team) {
        teams.put(team.getName(), team);
    }

    public void distribute(Solicitation solicitation) {
        Team team;
        switch (solicitation.getType()) {
            case "Card Issues":
                team = teams.get("Cards");
                break;
            case "Loan Application":
                team = teams.get("Loans");
                break;
            default:
                team = teams.get("Other Issues");
        }
        if (team != null) {
            team.distributeSolicitation(solicitation);
            team.processQueue();
        }
    }
}
