package com.postservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dominik_Janiga
 */
@Repository
interface PostRepository extends JpaRepository<Post, Long> {
}
