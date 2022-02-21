package uz.abdukarimov.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.abdukarimov.dto.task.TaskCreateDto;
import uz.abdukarimov.dto.task.TaskDto;
import uz.abdukarimov.dto.task.TaskDto.TaskDtoBuilder;
import uz.abdukarimov.dto.task.TaskUpdateDto;
import uz.abdukarimov.entity.task.Task;
import uz.abdukarimov.entity.task.Task.TaskBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-20T22:45:20+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromCreateDto(TaskCreateDto cd) {
        if ( cd == null ) {
            return null;
        }

        TaskBuilder task = Task.builder();

        task.title( cd.getTitle() );
        task.deadline( cd.getDeadline() );
        task.description( cd.getDescription() );
        task.user( cd.getUser() );

        return task.build();
    }

    @Override
    public Task fromUpdateDto(TaskUpdateDto ud) {
        if ( ud == null ) {
            return null;
        }

        TaskBuilder task = Task.builder();

        task.id( ud.getId() );
        task.title( ud.getTitle() );
        task.deadline( ud.getDeadline() );
        task.description( ud.getDescription() );
        task.completed( ud.isCompleted() );

        return task.build();
    }

    @Override
    public TaskDto toDto(Task e) {
        if ( e == null ) {
            return null;
        }

        TaskDtoBuilder taskDto = TaskDto.builder();

        taskDto.id( e.getId() );
        taskDto.title( e.getTitle() );
        taskDto.deadline( e.getDeadline() );
        taskDto.description( e.getDescription() );
        taskDto.completed( e.isCompleted() );

        return taskDto.build();
    }

    @Override
    public List<TaskDto> toDto(List<Task> e) {
        if ( e == null ) {
            return null;
        }

        List<TaskDto> list = new ArrayList<TaskDto>( e.size() );
        for ( Task task : e ) {
            list.add( toDto( task ) );
        }

        return list;
    }
}
