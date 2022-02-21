package uz.abdukarimov.dto.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.dto.BaseDto;
import uz.abdukarimov.entity.user.AuthUser;

import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class TaskCreateDto implements BaseDto {
    private String title;
    private Date deadline;
    private String description;
    private AuthUser user;
}
