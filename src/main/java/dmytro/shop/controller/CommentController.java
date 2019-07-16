package dmytro.shop.controller;


import dmytro.shop.dto.request.CommentRequest;
import dmytro.shop.dto.response.CommentResponse;
import dmytro.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentResponse save (@RequestBody CommentRequest commentRequest){
        return (CommentResponse) commentService.save(commentRequest);
    }
    @GetMapping
    public List<CommentResponse> findAll() {
        return commentService.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        commentService.delete(id);
    }

    @PutMapping
    public CommentResponse update(@RequestParam Long id, @RequestBody CommentRequest commentRequest) {
        return commentService.update(commentRequest, id);
    }
}

