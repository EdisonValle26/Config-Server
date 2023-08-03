package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Notificacion;

@Repository
public interface INotificacionDao extends CrudRepository<Notificacion, Integer>{
	
}
