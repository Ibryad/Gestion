package com.joza.gestion.service;

import static java.util.stream.Collectors.toList;

import com.joza.gestion.entity.Costs;
import com.joza.gestion.repository.GestionRepository;
import com.joza.gestion.web.CostsResponse;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostService {


  private final GestionRepository repository;

  public CostService(GestionRepository repository) {
    this.repository = repository;
  }

  public List<CostsResponse> findAll() {
    List<Costs> costs = repository.findAll();
    Map<YearMonth, MonthlyCost> res = new HashMap<>();
    for (Costs cost : costs) {
      YearMonth yearMonth = YearMonth.from(cost.getDate());
      MonthlyCost monthlyCost = res.get(yearMonth);
      if(monthlyCost == null){
        res.put(yearMonth, MonthlyCost.from(cost));
      }else {
        res.replace(yearMonth, monthlyCost.append(cost));
      }
    }
    return res.entrySet()
        .stream()
        .map(e -> new CostsResponse(e.getKey(), e.getValue()))
        .collect(toList());
  }
}
