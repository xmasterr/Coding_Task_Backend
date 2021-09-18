package com.sahar.task_coding_sahar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")

public class AnalyzerController {

    @GetMapping("/analyzer")
    public ResponseEntity<?> confirm(@RequestParam String text){
        Map<String, Integer> alphabetMap = TextAnalyzer.analyse(text.split(" "));
        return ResponseEntity.ok().body(alphabetMap);
  //      return ResponseEntity.ok().build();
    }

}
