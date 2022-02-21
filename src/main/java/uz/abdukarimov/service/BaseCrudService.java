package uz.abdukarimov.service;

import uz.abdukarimov.dto.BaseAbstractDto;
import uz.abdukarimov.dto.BaseDto;

import java.io.Serializable;


public interface BaseCrudService<
        CD extends BaseDto,
        UD extends BaseAbstractDto,
        K extends Serializable> {
    K create(CD cd);

    void delete(K k);

    void update(UD ud);

}
