package com.miguel.ubots_test.controller;

import com.miguel.ubots_test.model.Solicitation;
import com.miguel.ubots_test.service.SolicitationDistributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitations")
public class SolicitationController {

    @Autowired
    private SolicitationDistributor solicitationDistributor;

    @PostMapping
    public void receiveSolicitation(@RequestBody Solicitation solicitation) {
        solicitationDistributor.distribute(solicitation);
    }
}
