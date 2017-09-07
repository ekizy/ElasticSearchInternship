package com.yusuf.es.repository.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.es.model.Address;
import com.yusuf.es.model.Student;

import java.util.List;

@Repository
public interface StudentElasticRepository extends ElasticsearchRepository<Student, Long> {

	// full text arama için yapay bir query yazıldı.
    @Query("{\"query\": {\"multi_match\":{\"fields\":[\"*\"],\"lenient\":\"true\",\"query\":\"?0\",\"type\":\"phrase_prefix\"}}}")
    List<Student> findByQuery(String query);

    //Elasticsearch repository kütüphanelerinde dokumandaki alanların her biri için doğal bir findBy fonksiyonu oluşturulabilir.

    //elasticsearch'den gelen doğal find fonksiyonu
    List<Student> findByName(String name);

    List <Student> findBySurname(String surname);

    Student findByEmail(String email);

    List<Student> findByHobby(String hobby);

   // Student findByAddress(Address address);

}
