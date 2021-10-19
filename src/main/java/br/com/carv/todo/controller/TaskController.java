package br.com.carv.todo.controller;

import br.com.carv.todo.model.Task;
import br.com.carv.todo.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveTasks")
    public ResponseEntity<?> saveTasks(@RequestBody Task task) {
        taskService.saveTask(task);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public List<Task> findAll() {
        List<Task> tasks = taskService.findAll();
        return tasks;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findTaskById/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable("id") Long id) {
        Optional<Task> taskResult = taskService.findById(id);

        if (taskResult.isPresent()) {
            return ResponseEntity.ok().body(taskResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateTask/{id}")
    public ResponseEntity<?> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        Optional<Task> taskResult = Optional.ofNullable(taskService.updateTask(id, task));
        return ResponseEntity.ok().body(taskResult);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }




}
