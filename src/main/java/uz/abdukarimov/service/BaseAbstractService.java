package uz.abdukarimov.service;


public abstract class BaseAbstractService<R, M> implements BaseService {
    protected final R repository;
    protected final M mapper;

    public BaseAbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
