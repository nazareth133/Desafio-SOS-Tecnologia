package br.com.sostecnologia.repository;

import br.com.sostecnologia.domain.Patrimonio;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PatrimonioRepository extends AbstractRepository<Patrimonio>{

    public PatrimonioRepository(){
        super(Patrimonio.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
