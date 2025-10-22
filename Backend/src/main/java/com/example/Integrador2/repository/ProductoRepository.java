package com.example.Integrador2.repository;

import com.example.Integrador2.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Integrador2.dto.ProductosPorCategoriaDTO; //METRICA 2
import org.springframework.data.jpa.repository.Query; //METRICA 2
import java.util.List; //METRICA 2

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //Metrica 2
    @Query("SELECT new com.example.Integrador2.dto.ProductosPorCategoriaDTO(c.nombre, COUNT(p)) FROM Producto p JOIN p.categoria c GROUP BY c.nombre")
    List<ProductosPorCategoriaDTO> countProductosByCategoria();

    //Metrica 4
    List<Producto> findByStockLessThan(int stock);
}
