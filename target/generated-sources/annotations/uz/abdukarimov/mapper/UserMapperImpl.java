package uz.abdukarimov.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.abdukarimov.dto.user.UserCreateDto;
import uz.abdukarimov.dto.user.UserDto;
import uz.abdukarimov.dto.user.UserDto.UserDtoBuilder;
import uz.abdukarimov.dto.user.UserUpdateDto;
import uz.abdukarimov.entity.user.AuthUser;
import uz.abdukarimov.entity.user.AuthUser.AuthUserBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-20T22:45:20+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(AuthUser e) {
        if ( e == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.id( e.getId() );
        userDto.username( e.getUsername() );
        userDto.password( e.getPassword() );
        userDto.email( e.getEmail() );
        userDto.avatar( e.getAvatar() );

        return userDto.build();
    }

    @Override
    public List<UserDto> toDto(List<AuthUser> e) {
        if ( e == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( e.size() );
        for ( AuthUser authUser : e ) {
            list.add( toDto( authUser ) );
        }

        return list;
    }

    @Override
    public AuthUser fromCreateDto(UserCreateDto userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        AuthUserBuilder authUser = AuthUser.builder();

        authUser.username( userCreateDto.getUsername() );
        authUser.password( userCreateDto.getPassword() );
        authUser.email( userCreateDto.getEmail() );

        return authUser.build();
    }

    @Override
    public AuthUser fromUpdateDto(UserUpdateDto updateDto) {
        if ( updateDto == null ) {
            return null;
        }

        AuthUserBuilder authUser = AuthUser.builder();

        authUser.id( updateDto.getId() );
        authUser.username( updateDto.getUsername() );
        authUser.email( updateDto.getEmail() );

        return authUser.build();
    }
}
