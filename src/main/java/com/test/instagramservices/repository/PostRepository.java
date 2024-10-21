package com.test.instagramservices.repository;

import com.test.instagramservices.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "select ip, fw.followBy from Post ip JOIN Follow fw on fw.userId = ip.user.id where ip.user.id = ?1")
    List<Post> findAllFollowPost(Long id);
}
