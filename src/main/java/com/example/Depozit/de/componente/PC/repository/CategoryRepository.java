package com.example.Depozit.de.componente.PC.repository;

import com.example.Depozit.de.componente.PC.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
