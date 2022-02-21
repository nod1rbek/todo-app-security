package uz.abdukarimov.mapper;

import uz.abdukarimov.dto.BaseAbstractDto;
import uz.abdukarimov.dto.BaseDto;
import uz.abdukarimov.entity.BaseEntity;

import java.util.List;


public interface BaseMapper<
        E extends BaseEntity,
        CD extends BaseDto,
        UD extends BaseAbstractDto,
        D extends BaseAbstractDto> extends Mapper {

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud);

    D toDto(E e);

    List<D> toDto(List<E> e);
}
