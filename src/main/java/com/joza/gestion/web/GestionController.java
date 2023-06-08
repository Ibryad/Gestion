package com.joza.gestion.web;

import com.joza.gestion.entity.Costs;
import com.joza.gestion.repository.GestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class GestionController {


    private final GestionRepository gestionRepository;

    public GestionController(GestionRepository gestionRepository) {
        this.gestionRepository = gestionRepository;
    }

    @GetMapping("/costs")
    public ResponseEntity<List<Costs>> monthsData(){

        List<Costs> costs = gestionRepository.findAll();
        return new ResponseEntity<>(costs, HttpStatus.OK);
    }

    /*@GetMapping("/costs/{date}")
    public List<Costs> monthsCosts(@PathVariable String date){

    }*/

    @GetMapping("/costs/{type}")
    public ResponseEntity<List<Costs>> costsByType(@PathVariable String type){
        List<Costs> byType = gestionRepository.findByType(type);
        return new ResponseEntity<>(byType, HttpStatus.OK);
    }



    @PostMapping("/costs")
    public ResponseEntity<Void> addCosts (@RequestBody Costs costs) {
        gestionRepository.save(costs);
        return ResponseEntity.ok(null);
    }

}