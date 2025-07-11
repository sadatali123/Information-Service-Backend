package com.sadat.NIC.ContactController;

import com.sadat.NIC.ContactEntity.Post;
import com.sadat.NIC.ContactService.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contact-service/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Post> add(@RequestBody Post post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.update(id, post));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Post> getById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getById(id));
    }
}
