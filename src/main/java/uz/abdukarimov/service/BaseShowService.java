package uz.abdukarimov.service;

import uz.abdukarimov.criteria.BaseCriteria;
import uz.abdukarimov.dto.BaseAbstractDto;

import java.io.Serializable;
import java.util.List;


public interface BaseShowService<
        D extends BaseAbstractDto,
        C extends BaseCriteria,
        K extends Serializable> {
    List<D> list(C criteria);

    D get(K k);
}
