package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.FacturaCabecera;

@Repository
public interface FacturaCabeceraRepository extends JpaRepository<FacturaCabecera, Integer> {

}
