package com.joza.gestion.web;

import com.joza.gestion.entity.Costs;
import com.joza.gestion.repository.GestionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GestionController {

    private final GestionRepository gestionRepository;

    public GestionController(GestionRepository gestionRepository) {
        this.gestionRepository = gestionRepository;
    }

    @GetMapping("/costs")
    public List<Costs> hello(){
        return gestionRepository.findAll();
    }



}
