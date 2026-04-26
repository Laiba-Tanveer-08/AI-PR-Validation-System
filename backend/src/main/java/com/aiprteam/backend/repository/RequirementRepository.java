package com.aiprteam.backend.repository;
import com.aiprteam.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/*✅ CREATE / SAVE
save(requirement)
✅ READ
findById(id)
findAll()
✅ UPDATE
save(updatedRequirement)
👉 Same method as save
(if ID exists → it updates)
✅ DELETE
deleteById(id)
delete(requirement)*/
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    List<Requirement> findBySprint(Sprint sprint);
    List<Requirement> findByProject(Project project);
}