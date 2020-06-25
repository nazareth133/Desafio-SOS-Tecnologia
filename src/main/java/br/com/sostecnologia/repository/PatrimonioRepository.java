package br.com.sostecnologia.repository;

import br.com.sostecnologia.domain.Patrimonio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PatrimonioRepository extends AbstractRepository<Patrimonio>{

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager entityManager;

    public PatrimonioRepository(){
        super(Patrimonio.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
