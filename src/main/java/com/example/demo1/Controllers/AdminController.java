package com.example.demo1.Controllers;

import com.example.demo1.Entities.*;
import com.example.demo1.Repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
public class AdminController {

    @Autowired
    SampleRepository sampleRepository;
    DoctorRepository doctorRepository;
    SpecializationRepository specializationRepository;
    NewsRepository newsRepository;
    ContactFormRepository contactFormRepository;

    @PostMapping("/addNews")
    public ResponseEntity<News> entity(@RequestBody News news) {
        news.setTimeOfCreation(LocalDateTime.now());
        newsRepository.save(news);
        return ResponseEntity.ok(news);
    }


    @GetMapping("/getContactForms")
    public ResponseEntity<ContactForm> contactForm(@RequestBody ContactForm contactForm) {
        return ResponseEntity.ok(contactFormRepository.save(contactForm));
    }



    @GetMapping("/findAllDoctors")
    public ResponseEntity<List<Doctor>> findAll() {

        return ResponseEntity.ok(doctorRepository.findAll());
    }

}
