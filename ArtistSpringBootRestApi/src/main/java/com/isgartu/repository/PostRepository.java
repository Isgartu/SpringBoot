package com.isgartu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isgartu.model.Post;

/**
 * Created by rajeevkumarsingh on 21/11/17.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
