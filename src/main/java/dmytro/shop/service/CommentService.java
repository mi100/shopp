package dmytro.shop.service;


import dmytro.shop.dto.request.CommentRequest;
import dmytro.shop.dto.response.CommentResponse;
import dmytro.shop.entiti.Comment;
import dmytro.shop.exception.WrongInputDataException;

import dmytro.shop.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ProductService productService;

    public CommentRepository save (CommentRequest commentRequest) {
        return (CommentRepository) new CommentResponse(commentRepository.save(commentRequestToComment(commentRequest, null)));
    }
    public List<CommentResponse> findAll() {
        return commentRepository.findAll().stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
    public void delete(Long id) {
        commentRepository.delete(findOne(id));
    }

    public Comment findOne(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    public CommentResponse update(CommentRequest commentRequest, Long id){
        return new CommentResponse(commentRepository.save(commentRequestToComment(commentRequest, findOne(id))));
    }
    private Comment commentRequestToComment(CommentRequest commentRequest, Comment comment) {
        if ( comment == null){
            comment = new Comment();
            comment.setDateTime(LocalDateTime.now());
        }
        comment.setUsername(commentRequest.getUsername());
        comment.setText(commentRequest.getText());
//        comment.setProduct(productService.finOne(comment.getProductId()));

        return comment;
    }
}
