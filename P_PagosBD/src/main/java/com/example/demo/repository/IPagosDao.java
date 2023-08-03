package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Pagos;

public interface IPagosDao extends CrudRepository<Pagos, Integer>{
}
