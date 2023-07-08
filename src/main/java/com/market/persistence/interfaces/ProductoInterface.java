package com.market.persistence.interfaces;

import com.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoInterface extends CrudRepository <Producto, Integer> {

    Optional<List<Producto>> findByIdCategoria(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThan(int cantidadStock);
}
