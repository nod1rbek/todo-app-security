package uz.abdukarimov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.abdukarimov.dto.user.UserCreateDto;
import uz.abdukarimov.dto.user.UserDto;
import uz.abdukarimov.dto.user.UserUpdateDto;
import uz.abdukarimov.entity.user.AuthUser;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<
        AuthUser, UserCreateDto, UserUpdateDto, UserDto> {
    @Override
    @Mapping(target = "avatar", ignore = true)
    AuthUser fromCreateDto(UserCreateDto userCreateDto);

    @Override
    @Mapping(target = "avatar", ignore = true)
    AuthUser fromUpdateDto(UserUpdateDto updateDto);
}
