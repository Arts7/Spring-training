package com.wildcodeschool.projectWithDB.controllers;

import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wildcodeschool.projectWithDB.entities.School;
import com.wildcodeschool.projectWithDB.repository.SchoolRepository;

@Controller
@ResponseBody
public class SchoolController {

    @PostMapping("/api/schools")
    @ResponseStatus(HttpStatus.CREATED)
    public School store(
        @RequestParam String name,
        @RequestParam int capacity,
        @RequestParam String country
    ) {
        int idGeneratedByInsertion = SchoolRepository.insert(
            name,
            capacity,
            country
        );
        return SchoolRepository.selectById(idGeneratedByInsertion
        );
    }

    @GetMapping("/api/schools")
    public List<School> getSchools(
        @RequestParam(defaultValue = "%") String family
        ){
        return SchoolRepository.selectByName(family);
    }
    
    
}
