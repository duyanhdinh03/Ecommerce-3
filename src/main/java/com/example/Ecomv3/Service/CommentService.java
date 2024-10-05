package com.example.Ecomv3.Service;

import com.example.Ecomv3.DTO.CommentDTO;
import com.example.Ecomv3.Exception.ResourceNotFoundException;
import com.example.Ecomv3.Mapper.CommentMapper;
import com.example.Ecomv3.Model.Comment;
import com.example.Ecomv3.Model.Product;
import com.example.Ecomv3.Model.User;
import com.example.Ecomv3.Repositories.CommentRepository;
import com.example.Ecomv3.Repositories.ProductRepository;
import com.example.Ecomv3.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;
    public CommentDTO addComment(Long productId, Long userId, CommentDTO commentDTO){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setProduct(product);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDTO(savedComment);
    }
    public List<CommentDTO> getCommentsByProduct(Long productId){
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }
}
