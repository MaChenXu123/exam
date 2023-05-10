package com.example.exam.controller;


import com.example.exam.service.aExamService;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class aExamController {
    @Autowired
    private aExamService aExamService;
    @GetMapping("getExam")
    public R getExam(@PathParam("examNum") int examNum){

        return aExamService.getExam(examNum);
    }
}
