package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer>{

}
