package uz.abdukarimov.service.task;

import org.springframework.stereotype.Service;
import uz.abdukarimov.criteria.TaskCriteria;
import uz.abdukarimov.dto.task.TaskCreateDto;
import uz.abdukarimov.dto.task.TaskDto;
import uz.abdukarimov.dto.task.TaskUpdateDto;
import uz.abdukarimov.entity.task.Task;
import uz.abdukarimov.exceptions.NotFoundException;
import uz.abdukarimov.exceptions.UserNotFoundException;
import uz.abdukarimov.mapper.TaskMapper;
import uz.abdukarimov.repository.TaskRepository;
import uz.abdukarimov.service.BaseAbstractService;
import uz.abdukarimov.service.BaseCrudService;
import uz.abdukarimov.service.BaseShowService;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Service
public class TaskService extends BaseAbstractService<TaskRepository, TaskMapper>
        implements BaseCrudService<TaskCreateDto, TaskUpdateDto, Long>, BaseShowService<TaskDto, TaskCriteria, Long> {

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(TaskCreateDto taskCreateDto) {
        Task task = mapper.fromCreateDto(taskCreateDto);
        // TODO: 2/19/2022 add some check
        repository.save(task);
        return task.getId();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void update(TaskUpdateDto taskUpdateDto) {
        Task task = repository.findById(taskUpdateDto.getId()).orElseThrow(() -> new NotFoundException("Not Found"));
        String title = (taskUpdateDto.getTitle().isBlank()) ? task.getTitle() : taskUpdateDto.getTitle();
        Date deadline = (Objects.isNull(taskUpdateDto.getDeadline())) ? task.getDeadline() : taskUpdateDto.getDeadline();
        String description = (taskUpdateDto.getDescription().isBlank()) ? task.getDescription() : taskUpdateDto.getDescription();
        boolean completed = (taskUpdateDto.isCompleted()) ? task.isCompleted() : taskUpdateDto.isCompleted();

        repository.update(task.getId(), title, deadline, description, completed);
    }

    @Override
    public List<TaskDto> list(TaskCriteria criteria) {
        List<Task> all = repository.findAll();
        return mapper.toDto(all);
    }

    @Override
    public TaskDto get(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
        return mapper.toDto(task);
    }

    public List<TaskDto> list(Long userId) {
        List<Task> userTask = repository.findByUserId(userId);
        List<TaskDto> taskDtos = mapper.toDto(userTask);
        return taskDtos;
    }
}
