package uz.abdukarimov.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.dto.BaseAbstractDto;

import java.util.Date;

@Setter
@Getter
public class TaskDto extends BaseAbstractDto {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;

    @Builder
    public TaskDto(Long id, String title, Date deadline, String description, boolean completed) {
        super(id);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
    }
}
