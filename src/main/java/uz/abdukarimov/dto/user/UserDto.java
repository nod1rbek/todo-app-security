package uz.abdukarimov.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.abdukarimov.dto.BaseAbstractDto;

@Setter
@Getter
public class UserDto extends BaseAbstractDto {
    private String username;
    private String password;
    private String email;
    private String avatar;

    @Builder
    public UserDto(Long id, String username, String password, String email, String avatar) {
        super(id);
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }
}
