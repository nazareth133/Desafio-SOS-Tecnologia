package br.com.sostecnologia.repository;

import br.com.sostecnologia.domain.Marca;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MarcaRepository extends AbstractRepository<Marca> {
    public MarcaRepository(){
        super(Marca.class);
    }
}
