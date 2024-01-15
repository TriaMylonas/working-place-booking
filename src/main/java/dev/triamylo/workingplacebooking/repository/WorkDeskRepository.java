package dev.triamylo.workingplacebooking.repository;

import dev.triamylo.workingplacebooking.model.WorkDesk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkDeskRepository extends JpaRepository<WorkDesk, String> {
}
