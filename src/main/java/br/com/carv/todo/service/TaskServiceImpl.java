package br.com.carv.todo.service;

import br.com.carv.todo.model.Task;
import br.com.carv.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    public TaskServiceImpl (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> findById(Long id) {
        Optional taskResult = taskRepository.findById(id);
        return taskResult;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> taskResult = taskRepository.findById(id);

        if (taskResult.isPresent()) {
            taskRepository.delete(taskResult.get());
        }

    }

    @Override
    public Task updateTask(Long id, Task task) {

        Optional<Task> taskResult = taskRepository.findById(id);

        if (taskResult.isPresent()) {
            taskResult.get().setTaskTitle(task.getTaskTitle());
            taskResult.get().setDescription(task.getDescription());
            taskResult.get().setDeadline(task.getDeadline());
            return taskRepository.save(taskResult.get());

        } else {
            return taskResult.get();
        }
    }
}
