package uz.abdukarimov.service.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import uz.abdukarimov.criteria.UserCriteria;
import uz.abdukarimov.dto.user.UserCreateDto;
import uz.abdukarimov.dto.user.UserDto;
import uz.abdukarimov.dto.user.UserUpdateDto;
import uz.abdukarimov.entity.user.AuthUser;
import uz.abdukarimov.exceptions.UserNotFoundException;
import uz.abdukarimov.mapper.UserMapper;
import uz.abdukarimov.repository.UserRepository;
import uz.abdukarimov.service.BaseAbstractService;
import uz.abdukarimov.service.BaseCrudService;
import uz.abdukarimov.service.BaseShowService;

import java.util.List;


@Service
public class UserService extends BaseAbstractService<UserRepository, UserMapper>
        implements BaseCrudService<UserCreateDto, UserUpdateDto, Long>, BaseShowService<UserDto, UserCriteria, Long> {
    public UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(UserCreateDto userCreateDto) {
        return null;
    }

    @Override
    public void delete(Long aLong) {
    }

    @PreAuthorize("hasAuthority('user_update')")
    @Override
    public void update(UserUpdateDto updateDto) {
        AuthUser authUser = repository.findById(updateDto.getId()).orElseThrow(() -> new UserNotFoundException("User Not found"));
        String username = (updateDto.getUsername().isBlank()) ? authUser.getUsername() : updateDto.getUsername();
        String email = (updateDto.getEmail().isBlank()) ? authUser.getEmail() : updateDto.getEmail();
        String avatar = (updateDto.getAvatar().isBlank()) ? authUser.getAvatar() : updateDto.getAvatar();
        repository.update(authUser.getId(), username, email, avatar);
    }

    @Override
    public List<UserDto> list(UserCriteria criteria) {
        List<AuthUser> all = repository.findAllByDeleted();
        return mapper.toDto(all);
    }

    @PreAuthorize("hasAuthority('user_get')")
    @Override
    public UserDto get(Long id) {
        AuthUser authUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return mapper.toDto(authUser);
    }
}
