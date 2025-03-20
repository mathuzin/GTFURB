package com.example.gtfurb.services;

import com.example.gtfurb.utils.FilterImpl;
import com.example.gtfurb.utils.Page;

public interface Service<T> {
    T create(T entity);

    T update(Integer id, T entity);

    T get(Integer id);

    Page<T> list(FilterImpl filter);

    T retrieve(Integer id);

    void delete(Integer id);

    void delete(T entity);
}
