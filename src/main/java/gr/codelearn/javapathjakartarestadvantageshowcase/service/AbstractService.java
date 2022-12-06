package gr.codelearn.javapathjakartarestadvantageshowcase.service;

import gr.codelearn.javapathjakartarestadvantageshowcase.repository.AbstractRepository;

import java.util.List;

public abstract class AbstractService<T> implements BaseService<T,Long>{
    public abstract AbstractRepository<T,Long> getRepository();

    @Override
    public T create(T entity) {
        return getRepository().create(entity);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T findById(Long id) {
        return getRepository().get(id);
    }
}
