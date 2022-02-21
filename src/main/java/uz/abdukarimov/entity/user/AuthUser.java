package uz.abdukarimov.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.entity.Auditable;
import uz.abdukarimov.entity.role.Role;
import uz.abdukarimov.entity.task.Task;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
public class AuthUser extends Auditable {
    private String username;
    private String password;
    private String email;
    private String avatar;
    private byte active = 1;

    @OneToMany(mappedBy = "user")
    private List<Task> task;

    @OneToOne(mappedBy = "authUser")
    private Role role;

    @Builder
    public AuthUser(Long id, Date createdAt, Long createdBy, Date updatedAt, Long updatedBy, String username, String password, String email, String avatar, List<Task> task) {
        super(id, createdAt, createdBy, updatedAt, updatedBy);
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
        this.task = task;
    }

    public AuthUser() {
        super();
    }
}
