package com.example.Integrador2.repository;


import com.example.Integrador2.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallaVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}
