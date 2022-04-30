package com.onetomany.bidirectional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.bidirectional.entity.Student;
import com.onetomany.bidirectional.entity.Subject;
import com.onetomany.bidirectional.repository.StudentRepository;
import com.onetomany.bidirectional.repository.SubjectRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    StudentRepository studentRepository;

 
    @GetMapping
    List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @PostMapping
    Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{subjectId}/students/{studentId}")
    Subject addStudentToSubject(
            @PathVariable Long subjectId,
            @PathVariable Long studentId
    ) {
        Subject subject = subjectRepository.findById(subjectId).get();
        Student student = studentRepository.findById(studentId).get();
        subject.enrolledStudents.add(student);
        return subjectRepository.save(subject);
    }
//
//    @PutMapping("/{subjectId}/teacher/{teacherId}")
//    Subject assignTeacherToSubject(
//            @PathVariable Long subjectId,
//            @PathVariable Long teacherId
//    ) {
//        Subject subject = subjectRepository.findById(subjectId).get();
//        Teacher teacher = teacherRepository.findById(teacherId).get();
//        subject.setTeacher(teacher);
//        return subjectRepository.save(subject);
//    }
}