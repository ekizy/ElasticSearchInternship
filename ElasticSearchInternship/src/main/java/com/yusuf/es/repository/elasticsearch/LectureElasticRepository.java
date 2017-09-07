 package com.yusuf.es.repository.elasticsearch;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.yusuf.es.model.Course;
import com.yusuf.es.model.Instructor;
import com.yusuf.es.model.Lecture;

public interface LectureElasticRepository extends ElasticsearchRepository<Lecture, Long> {

	List<Lecture> findByLanguage(String language);

	List<Lecture> findByClassRoom(String language);

	List <Lecture> findByDayTime (String dayTime);

	List<Lecture> findByInstructor (Instructor instructor);

	List <Lecture> findByCourse (Course course);




}
