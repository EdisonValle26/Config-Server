package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CategoriaProductos;

@Repository
public interface CategoriaProductosRepository extends JpaRepository<CategoriaProductos, Integer> {

}
