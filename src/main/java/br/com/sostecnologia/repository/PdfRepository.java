package br.com.sostecnologia.repository;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.sostecnologia.domain.Pdf;

@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class PdfRepository extends AbstractRepository<Pdf>{
    public PdfRepository(){
        super(Pdf.class);
    }
}
