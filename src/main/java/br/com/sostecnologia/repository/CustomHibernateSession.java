package br.com.sostecnologia.repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CustomHibernateSession<T> {
    public T save(T entity);
    public T update(T entity) ;
    public void delete(T entity) ;
    public Optional<T> find(Object id) ;
    public List<T> findAll() ;
    public List<T> findRange(int[] range) ;
    public int count();
}
