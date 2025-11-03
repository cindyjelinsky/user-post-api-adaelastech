package com.chj.postapi.repository;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByUser(User user);
    Optional<Post> findByIdAndUserId(Long postId, Long userId);

}
