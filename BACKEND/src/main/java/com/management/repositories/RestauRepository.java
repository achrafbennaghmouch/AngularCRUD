package com.management.repositories;


import com.management.entities.Restau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauRepository extends JpaRepository<Restau, Long> {
}
