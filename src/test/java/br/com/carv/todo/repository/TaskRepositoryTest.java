package br.com.carv.todo.repository;

import br.com.carv.todo.model.Task;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testTaskName() {

        Task task = new Task(null, "Test JUnit", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Fusce fermentum nunc enim, nec bibendum orci iaculis sit amet.",
                LocalDateTime.of(2021, 10, 29, 00, 00, 00 ), LocalDateTime.now());

        Assertions.assertTrue(task.getTaskTitle().contains("Test"));
    }

}
