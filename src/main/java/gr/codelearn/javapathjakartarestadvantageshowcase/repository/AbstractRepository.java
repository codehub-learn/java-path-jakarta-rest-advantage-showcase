package gr.codelearn.javapathjakartarestadvantageshowcase.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class AbstractRepository<T, K> implements Repository<T,K> {
    @PersistenceContext(unitName = "Persistence")
    protected EntityManager em;

    public abstract Class<T> getClassType();
    public String getClassName(){
        return getClassType().getSimpleName();
    }
    @Override
    @Transactional
    public T create(T t) {
        em.persist(t);
        return t;
    }
    @Override
    public T get(K id) {
        return em.find(getClassType(), id);
    }
    @Override
    public List<T> findAll() {
        return  em.createQuery("select c from "+ getClassName()+" c").getResultList();
    }

    @Override
    @Transactional
    public boolean delete(K id) {
        T t = get(id);
        if (t == null) return false;
        em.remove(t);
        return true;
    }
}
