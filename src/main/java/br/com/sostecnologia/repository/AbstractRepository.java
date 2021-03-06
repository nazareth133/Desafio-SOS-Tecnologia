package br.com.sostecnologia.repository;

import org.apache.log4j.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T> implements CustomHibernateSession<T>{

    private Logger logger = Logger.getLogger(AbstractRepository.class);

    @PersistenceContext(unitName = "persistenceUnit")
    protected EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    private final Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T save(T entity) {
        try{
            userTransaction.begin();
            entityManager.persist(entity);
            userTransaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro salvo com sucesso!"));
            return entity;
        }catch (Exception exception){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Ocorreu um error ao persistir os dados!"));
            logger.error(exception.getMessage(), exception);
        }
        return null;
    }

    public T update(T entity) {
        try{
            userTransaction.begin();
            if(entityManager.contains(entity)){
                this.delete(entity);
                entityManager.persist(entity);
            }else{
                entityManager.merge(entity);
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro alterado com sucesso!"));
            userTransaction.commit();
            return entity;
        }catch(Exception exception){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Ocorreu um error ao persistir os dados!"));
            logger.error(exception.getMessage(), exception);
        }
        return null;
    }

    public void delete(T entity) {
        try{
            userTransaction.begin();
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
            userTransaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Registro excluido com sucesso!"));
        }catch(Exception exception){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Ocorreu um error ao persistir os dados!"));
            logger.error(exception.getMessage(), exception);
        }
    }

    public Optional<T> find(Object id) {
        T entity = null;
        try {
            userTransaction.begin();
            entity = entityManager.find(entityClass, id);
            userTransaction.commit();
            return Optional.of(entity);
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }
        return Optional.empty();
    }

    public List<T> findAll() {
        try{
            userTransaction.begin();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            List<T> entities = entityManager.createQuery(cq).getResultList();
            userTransaction.commit();
            return entities;
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }
        return Collections.emptyList();
    }

    public List<T> findRange(int[] range) {
        try {
            userTransaction.begin();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            Query q = entityManager.createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            List<T> resultList =  q.getResultList();
            userTransaction.commit();
            return resultList;
        }catch (Exception exception){
            logger.error(exception.getMessage(), exception);
        }
        return Collections.emptyList();
    }

    public int count() {
        try {
            userTransaction.begin();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(entityClass);
            cq.select(entityManager.getCriteriaBuilder().count(rt));
            Query q = entityManager.createQuery(cq);
            Integer count = ((Long) q.getSingleResult()).intValue();
            userTransaction.commit();
            return count;
        }catch(Exception exception){
            logger.error(exception.getMessage(), exception);
        }
        return 0;
    }

}
