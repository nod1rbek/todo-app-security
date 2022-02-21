package uz.abdukarimov.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.dto.BaseAbstractDto;


@Setter
@Getter
public class UserUpdateDto extends BaseAbstractDto {
    private String username;
    private String email;
    private String avatar;


    @Builder
    public UserUpdateDto(Long id, String username, String password, String email, String avatar) {
        super(id);
        this.username = username;
        this.email = email;
        this.avatar = avatar;
    }
}
