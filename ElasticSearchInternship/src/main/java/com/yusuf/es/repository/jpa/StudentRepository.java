package com.yusuf.es.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.es.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
