package com.marcus.desafiodioapi.repositories;

import com.marcus.desafiodioapi.domain.model.Task;
import com.marcus.desafiodioapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUsuario(User usuario);
}