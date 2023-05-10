package com.example.exam.controller;

import com.example.exam.service.PaperService;
import com.example.exam.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class PaperController {
    @Autowired
    PaperService paperService;
    @PostMapping("getPaperList")
    private R Login(){
        return paperService.getPaperList();
    }

}
