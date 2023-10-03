package com.marcus.desafiodioapi.services;

import com.marcus.desafiodioapi.domain.model.Task;
import com.marcus.desafiodioapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        // Implemente a lógica para criar uma tarefa no banco de dados
        return taskRepository.save(task);
    }

    public Task getTaskById(Long id) {
        // Implemente a lógica para buscar uma tarefa por ID
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task task) {
        // Implemente a lógica para atualizar uma tarefa por ID
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            // Atualize os campos da tarefa com base nos dados fornecidos
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
            // Salve as alterações no banco de dados
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        // Implemente a lógica para excluir uma tarefa por ID
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            taskRepository.delete(existingTask);
            return true;
        }
        return false;
    }
}