package com.api.padaria.repository;

import com.api.padaria.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo,Long> {

    Curriculo findByEmail(String email);
}
