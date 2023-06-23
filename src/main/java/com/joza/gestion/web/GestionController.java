package com.joza.gestion.web;

import com.joza.gestion.entity.Costs;
import com.joza.gestion.entity.CostsForm;
import com.joza.gestion.repository.GestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController

public class GestionController {

    @Autowired
    private GestionRepository gestionRepository;

    public GestionController(GestionRepository gestionRepository) {
        this.gestionRepository = gestionRepository;
    }



    @GetMapping("/costs/all")
    public ResponseEntity<List<Costs>> monthsData(){

        List<Costs> costs = gestionRepository.findAll();
        return new ResponseEntity<>(costs, HttpStatus.OK);
    }



    @GetMapping("/costs/{type}")
    public ResponseEntity<List<Costs>> costsByType(@PathVariable String type){
        List<Costs> byType = gestionRepository.findByType(type);
        return new ResponseEntity<>(byType, HttpStatus.OK);
    }

    @GetMapping("/costs")
    public ResponseEntity<List<Costs>> costsMontantGreaterThan(@RequestParam("montant") double montant) {
        List<Costs> costList = gestionRepository.findMontantGreaterThan(montant);
        return new ResponseEntity<>(costList, HttpStatus.OK);
    }


    @PostMapping("/costs/add")
    public ResponseEntity<Void> addCosts(@RequestBody Costs costs) {
        gestionRepository.save(costs);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/costs/delete/{id}")
    public ResponseEntity<Void> deleteCosts(@PathVariable Costs id) {
        gestionRepository.delete(id);
        return ResponseEntity.ok().build();
    }



}