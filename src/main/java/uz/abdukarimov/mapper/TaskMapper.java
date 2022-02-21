package uz.abdukarimov.mapper;

import org.mapstruct.Mapper;
import uz.abdukarimov.dto.task.TaskCreateDto;
import uz.abdukarimov.dto.task.TaskDto;
import uz.abdukarimov.dto.task.TaskUpdateDto;
import uz.abdukarimov.entity.task.Task;


@Mapper(componentModel = "spring")
public interface TaskMapper extends BaseMapper<
        Task, TaskCreateDto, TaskUpdateDto, TaskDto> {
}
