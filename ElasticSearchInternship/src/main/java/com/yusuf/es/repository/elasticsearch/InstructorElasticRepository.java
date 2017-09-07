package com.yusuf.es.repository.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yusuf.es.model.Instructor;

public interface InstructorElasticRepository  extends ElasticsearchRepository<Instructor, Long> {

	List<Instructor> findByName(String name);

	List<Instructor> findBySurname(String surname);

	List<Instructor> findByMobile(String mobile);

	List<Instructor> findByTitle(String title);

	List<Instructor> findByOffice(int office);

	List <Instructor> findByEmail (String email);

}
