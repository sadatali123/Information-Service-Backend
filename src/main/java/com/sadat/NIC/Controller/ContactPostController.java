package com.sadat.NIC.Controller;

import com.sadat.NIC.Entity.ContactPost;
import com.sadat.NIC.Service.ContactPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/posts")
public class ContactPostController {

    @Autowired
    private ContactPostService postService;

    @PostMapping("/add")
    public ResponseEntity<ContactPost> add(@RequestBody ContactPost post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactPost> update(@PathVariable Long id, @RequestBody ContactPost post) {
        return ResponseEntity.ok(postService.update(id, post));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ContactPost>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ContactPost> getById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getById(id));
    }
}
