package com.chj.postapi.repository;

import com.chj.postapi.entity.Post;
import com.chj.postapi.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByUser_Id(Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Post p WHERE p.user.id = :userId")
    void deleteAllByUser_Id(@Param("userId") Long userId);

    Optional<Post> findByIdAndUser_Id(Long postId, Long userId);

}
