package com.myfonts.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.myfonts.admin.domain.Font;

public interface FontRepository extends JpaRepository<Font, Integer> {
    List<Font> findAll();
}
