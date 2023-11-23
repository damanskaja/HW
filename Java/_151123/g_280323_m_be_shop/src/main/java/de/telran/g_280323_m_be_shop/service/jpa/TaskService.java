package de.telran.g_280323_m_be_shop.service.jpa;

import de.telran.g_280323_m_be_shop.domain.entity.jpa.Task;
import de.telran.g_280323_m_be_shop.repository.jpa.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private TaskRepository repository;
    private Task lastCreatedTask;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(String description) {
        lastCreatedTask = repository.save(new Task(description));
        return lastCreatedTask;
    }

    public Task getLastCreatedTask() {
        return lastCreatedTask;
    }
}
