package org.ectimel.dietgeneratorcommon;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {


    @GetMapping
    public ResponseEntity<Test> test() {
        return ResponseEntity.ok(new Test("anv"));
    }

}
