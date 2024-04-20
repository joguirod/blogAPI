package com.gm2.blog.repositories;

import com.gm2.blog.entities.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogUserRepository extends JpaRepository<BlogUser, Long> {
}
