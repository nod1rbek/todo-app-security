package uz.abdukarimov.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.abdukarimov.dto.BaseDto;

import javax.persistence.Column;

@Setter
@Getter
public class UserCreateDto implements BaseDto {
    @Column(length = 20, unique = true, nullable = false)
    private String username;

    private String password;
    private String email;
    private MultipartFile avatar;

    @Builder
    public UserCreateDto(String username, String password, String email, MultipartFile avatar) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.avatar = avatar;
    }
}
