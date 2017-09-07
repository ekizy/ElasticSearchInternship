package com.yusuf.es.controller;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.SimpleQueryParser.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.yusuf.es.model.Instructor;
import com.yusuf.es.model.Lecture;
import com.yusuf.es.model.Student;
import com.yusuf.es.repository.elasticsearch.InstructorElasticRepository;
import com.yusuf.es.repository.elasticsearch.LectureElasticRepository;
import com.yusuf.es.repository.elasticsearch.StudentElasticRepository;
import com.yusuf.es.repository.jpa.InstructorRepository;
import com.yusuf.es.repository.jpa.LectureRepository;
import com.yusuf.es.repository.jpa.StudentRepository;

import java.net.InetAddress;
import java.util.List;

/**
 * AppController
 *
 * @author Yusuf Ekiz
 * @version 1.0.0,  28.7.2017
 */
@RestController // Rest isteklerini kontrol etme özelliği veren spring annotation'ı.
@RequestMapping(value = "/app")
public class AppController {
	Logger log = LoggerFactory.getLogger(AppController.class);
    @Autowired
    StudentElasticRepository studentElasticRepository; // repository sınıfının objesi açıldı
    @Autowired
    ElasticsearchOperations operations; //Genel elasticsearchoperations objesi açıldı.
    @Autowired
    StudentRepository studentRepository;

    //id'e göre öğrenci bulma.
    @RequestMapping(value = "/es/id/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getUserFromEsByID(@PathVariable Long studentId) {
        Student one = studentElasticRepository.findOne(studentId);
        return one;
    }
    // öğrenci ismine göre öğrenci arama
    @RequestMapping(value = "/es/name/{studentName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getUserFromEsByName(@PathVariable String studentName) {
        List<Student> results = studentElasticRepository.findByName(studentName);
        return results;
    }
    //öğrenci soyadına göre öğrenci arama
    @RequestMapping(value = "/es/surname/{studentSurname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getUserFromEsBySurname(@PathVariable String studentSurname) {
        List<Student> results = studentElasticRepository.findBySurname(studentSurname);
        return results;
    }
    //email'e göre öğrenci arama
    @RequestMapping(value = "/es/email/{studentemail}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getUserFromEsByEmail(@PathVariable String email) {
        Student student = studentElasticRepository.findByEmail(email);
        return student;
    }
    // öğrenci dokümanındaki bütün fieldları tarama.
    @RequestMapping(value = "/es/fullsearch/student/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getFullTextSearch(@PathVariable String search) {
        List<Student> list = studentElasticRepository.findByQuery(search);
        return list;
    }
    //elasticsearch'e öğrenci ekleme
    @RequestMapping(value="addStudent",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student createStudent(@RequestBody Student student) {
    	Student newStudent= studentRepository.save(student);
        studentElasticRepository.save(newStudent);
        return newStudent;
    }
    /*@RequestMapping(value="addLecture",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Lecture createLecture(@RequestBody Lecture lecture) {
        Lecture createdLecture = lectureRepository.save(lecture);
        lectureElasticRepository.save(lecture);
        return createdLecture;
    }
    @RequestMapping(value="addInstructor",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Instructor createCourse(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorRepository.save(instructor);
        instructorElasticRepository.save(instructor);
        return createdInstructor;
    }*/

}
