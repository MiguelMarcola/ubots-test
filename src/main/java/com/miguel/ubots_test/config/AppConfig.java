package com.miguel.ubots_test.config;

import com.miguel.ubots_test.model.Agent;
import com.miguel.ubots_test.model.Team;
import com.miguel.ubots_test.service.SolicitationDistributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SolicitationDistributor solicitationDistributor() {
        SolicitationDistributor distributor = new SolicitationDistributor();

        Team cardTeam = new Team("Cards");
        cardTeam.addAgent(new Agent("Agent 1"));
        cardTeam.addAgent(new Agent("Agent 2"));

        Team loanTeam = new Team("Loans");
        loanTeam.addAgent(new Agent("Agent 3"));
        loanTeam.addAgent(new Agent("Agent 4"));

        Team otherTeam = new Team("Other Issues");
        otherTeam.addAgent(new Agent("Agent 5"));
        otherTeam.addAgent(new Agent("Agent 6"));

        distributor.addTeam(cardTeam);
        distributor.addTeam(loanTeam);
        distributor.addTeam(otherTeam);

        return distributor;
    }
}
