package com.api.padaria.repository;

import com.api.padaria.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargoRepository extends JpaRepository<Cargo,Long> {


}
