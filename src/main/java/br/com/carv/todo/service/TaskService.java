package br.com.carv.todo.service;

import br.com.carv.todo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Optional<Task> findById(Long id);

    Task saveTask(Task task);

    List<Task> findAll();

    void deleteTask(Long id);

    Task updateTask(Long id, Task task);

}
