package com.lms.universe.service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class ServiceModel<getDto, createDto> {
    public abstract List<?> index();
    public abstract getDto show(Long id);
    public abstract void delete(Long id);
    public abstract void update(Long id, createDto data);
    public abstract getDto create(createDto data);
}
