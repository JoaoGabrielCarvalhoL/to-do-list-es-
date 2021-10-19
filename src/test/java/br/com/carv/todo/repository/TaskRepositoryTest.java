package br.com.carv.todo.repository;

import br.com.carv.todo.model.Task;
import org.assertj.core.api.Assertions;
import org.junit.Test;
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
        boolean result;
        Task task = new Task();
        task.setTaskTitle("Test JUnit");
        task.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Fusce fermentum nunc enim, nec bibendum orci iaculis sit amet.");
        task.setDeadline(LocalDateTime.now());

        if (task.getTaskTitle().contains("Test")) {
            result = true;
        } else {
            result = false;
        }

        Assertions.assertThat(result).isTrue();
    }

}
