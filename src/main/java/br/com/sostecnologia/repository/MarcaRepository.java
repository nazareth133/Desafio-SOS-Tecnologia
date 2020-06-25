package br.com.sostecnologia.repository;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MarcaRepository extends AbstractRepository<Marca> {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager entityManager;

    public MarcaRepository(){
        super(Marca.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
