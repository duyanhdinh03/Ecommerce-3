package com.example.Ecomv3.Controller;


import com.example.Ecomv3.DTO.CommentDTO;
import com.example.Ecomv3.Model.User;
import com.example.Ecomv3.Service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/product/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentDTO> addComment(@PathVariable("productId") int productId,
                                                 @AuthenticationPrincipal UserDetails userDetails,
                                                 @Valid @RequestBody CommentDTO commentDTO) {
        Long userID = ((User) userDetails).getId();
        return ResponseEntity.ok(commentService.addComment((long) productId, userID, commentDTO));

    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(commentService.getCommentsByProduct(productId));
    }
}
