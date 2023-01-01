package com.example.zoo.repository;

import com.example.zoo.model.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    Zone findById(int id);

    Zone findByName(String id);

}
