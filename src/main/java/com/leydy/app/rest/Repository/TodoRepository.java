package com.leydy.app.rest.Repository;

import com.leydy.app.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task,Long> {
}
