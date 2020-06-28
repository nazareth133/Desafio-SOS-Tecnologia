package br.com.sostecnologia.repository;

import br.com.sostecnologia.domain.Patrimonio;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class PatrimonioRepository extends AbstractRepository<Patrimonio>{
    public PatrimonioRepository(){
        super(Patrimonio.class);
    }
}
