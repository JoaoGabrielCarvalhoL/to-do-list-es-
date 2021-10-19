package br.com.carv.todo.repository;

import br.com.carv.todo.model.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskRepositoryTestJUnit5 {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testNameTask() {
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
