package com.example.Integrador2.repository;

import com.example.Integrador2.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}
