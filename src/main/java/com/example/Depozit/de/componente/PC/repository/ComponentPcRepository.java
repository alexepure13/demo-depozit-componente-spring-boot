package com.example.Depozit.de.componente.PC.repository;

import com.example.Depozit.de.componente.PC.entity.ComponentPc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentPcRepository extends JpaRepository<ComponentPc, Long> {
}
