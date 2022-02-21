package uz.abdukarimov.controller;

import uz.abdukarimov.service.BaseService;

public abstract class BaseAbstractController<S extends BaseService> {
    protected final S service;

    public BaseAbstractController(S service) {
        this.service = service;
    }
}
