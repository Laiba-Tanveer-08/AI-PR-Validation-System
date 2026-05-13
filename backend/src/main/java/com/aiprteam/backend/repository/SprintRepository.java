package com.aiprteam.backend.repository;

import com.aiprteam.backend.entity.Sprint;
import org.jspecify.annotations.NullMarked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
    @NullMarked
    Optional<Sprint> findById(Long id);
    Optional<Sprint> findByIdAndProjectIdAndProjectUserId(Long id, Long projectId, Long userId);
    Optional<Sprint> findByIdAndProjectUserId(Long id, Long projectUserId);
    Optional<Sprint> findByIdAndProjectId(Long id, Long projectId);
    List<Sprint> findByProjectIdAndProjectUserId(Long projectId, Long userId);
}