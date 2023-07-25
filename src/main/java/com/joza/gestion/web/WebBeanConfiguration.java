package com.joza.gestion.web;

import com.joza.gestion.repository.GestionRepository;
import com.joza.gestion.service.CostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebBeanConfiguration {

  @Bean
  public CostService acsApplicationService(GestionRepository gestionRepository) {
    return new CostService(gestionRepository);
  }

}
