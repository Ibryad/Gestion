package com.joza.gestion.web;

import com.joza.gestion.entity.Costs;
import com.joza.gestion.repository.GestionRepository;
import com.joza.gestion.service.CostService;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Spécifiez le domaine ou l'origine autorisé

public class GestionController {

    @Autowired
    private GestionRepository gestionRepository;

    private final CostService costService;

    public GestionController(CostService costService) {
        this.costService = costService;
    }

    @GetMapping("/costs/all")
    public ResponseEntity<List<CostsResponse>> allCosts(){
        List<CostsResponse> res = costService.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
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

    @GetMapping("/costs/monthsdate/{date}")
    public ResponseEntity<List<Costs>> costsByMonthsYears(@PathVariable String date) {
        /*String[] split = yearMonth.split("-");
        LocalDate min = LocalDate.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]), 1);*/
        YearMonth yearMonth = YearMonth.parse(date);

        List<Costs> costList = gestionRepository.findMontantByMonthsYears(yearMonth.atDay(1), yearMonth.atEndOfMonth());
        return new ResponseEntity<>(costList, HttpStatus.OK);
    }

    @GetMapping("/costs/year/{date}")
    public ResponseEntity<List<Costs>> costsByYears(@PathVariable String date) {
        int yearValue = Integer.parseInt(date);
        LocalDate startDate = LocalDate.of(yearValue, 1, 1);
        LocalDate endStart = LocalDate.of(yearValue, 12, 31);


        List<Costs> costList = gestionRepository.findMontantByYears(startDate, endStart);
        return new ResponseEntity<>(costList, HttpStatus.OK);
    }

}