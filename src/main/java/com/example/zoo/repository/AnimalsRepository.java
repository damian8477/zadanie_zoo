package com.example.zoo.repository;

import com.example.zoo.model.db.Animals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface AnimalsRepository extends JpaRepository<Animals, Long> {
    List<Animals> findAllByZoneId(int zoneId);
    List<Animals> findAllByName(String name);
}
