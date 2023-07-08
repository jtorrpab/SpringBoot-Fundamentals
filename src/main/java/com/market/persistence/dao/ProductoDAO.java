package com.market.persistence.dao;

import com.market.domain.dto.Product;
import com.market.domain.repository.ProductRepository;
import com.market.persistence.entity.Producto;
import com.market.persistence.interfaces.ProductoInterface;
import com.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoDAO implements ProductRepository {

    @Autowired
    private ProductoInterface productoInterface;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoInterface.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoInterface.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        Optional<List<Producto>> productos = productoInterface.findByIdCategoria(categoryId);
        return productos.map(producto -> mapper.toProducts(producto));
    }

    @Override
    public Optional<List<Product>> getScaseProducts(int quantity) {
        Optional<List<Producto>> productos = productoInterface.findByCantidadStockLessThan(quantity);
        return productos.map(producto -> mapper.toProducts(producto));
    }

    @Override
    public Product saveProduct(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoInterface.save(producto));
    }

    @Override
    public void deleteProduct(int productId) {
        productoInterface.deleteById(productId);
    }
}
