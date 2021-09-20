package com.sahar.task_coding_sahar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")

public class AnalyzerController {

    @CrossOrigin(origins = "*")
    @GetMapping("/analyzer")
    public ResponseEntity<?> confirm(@RequestParam String text){
        Map<String, Integer> alphabetMap = TextAnalyzer.analyse(text.split(" "));
        return ResponseEntity.ok().body(alphabetMap);
  //      return ResponseEntity.ok().build();
    }

}
