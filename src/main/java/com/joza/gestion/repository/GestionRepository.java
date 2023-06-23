package com.joza.gestion.repository;

import com.joza.gestion.entity.Costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GestionRepository extends JpaRepository<Costs, Long> {

    List<Costs> findByType(String type);
    @Query(value = "SELECT * FROM costs WHERE montant >= :montant", nativeQuery = true)
    List<Costs> findMontantGreaterThan(Double montant);


}


