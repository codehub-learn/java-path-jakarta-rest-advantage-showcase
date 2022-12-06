package gr.codelearn.javapathjakartarestadvantageshowcase.service;

import java.util.List;

public interface BaseService<T,ID> {
    T create(T entity);
    List<T> findAll();
    T findById(ID id);
}
