package uz.abdukarimov.entity.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.entity.Auditable;
import uz.abdukarimov.entity.user.AuthUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
public class Task extends Auditable {
    private String title;
    private Date deadline;
    private String description;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser user;


    @Builder
    public Task(Long id, Date createdAt, Long createdBy, Date updatedAt, Long updatedBy, String title, Date deadline, String description, boolean completed, AuthUser user) {
        super(id, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.deadline = deadline;
        this.description = description;
        this.completed = completed;
        this.user = user;
    }

    public Task() {
    }
}
