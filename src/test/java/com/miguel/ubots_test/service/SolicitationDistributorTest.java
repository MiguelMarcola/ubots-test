package com.miguel.ubots_test.service;

import com.miguel.ubots_test.model.Agent;
import com.miguel.ubots_test.model.Solicitation;
import com.miguel.ubots_test.model.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolicitationDistributorTest {

    @Test
    public void testDistributeSolicitation() {
        SolicitationDistributor distributor = new SolicitationDistributor();

        Team cardTeam = new Team("Cards");
        Agent agent1 = new Agent("Agent 1");
        cardTeam.addAgent(agent1);

        distributor.addTeam(cardTeam);

        Solicitation solicitation = new Solicitation("Card Issues", "123");
        distributor.distribute(solicitation);

        assertEquals(1, agent1.getSolicitations().size());
        assertEquals("123", agent1.getSolicitations().get(0).getClientId());
    }
}

