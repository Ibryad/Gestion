package com.joza.gestion.repository;

import com.joza.gestion.entity.Costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public interface GestionRepository extends JpaRepository<Costs, Long> {


}
