package br.com.sostecnologia.beans;

import br.com.sostecnologia.client.PatrimonioClient;
import br.com.sostecnologia.domain.Patrimonio;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "patrimonioBean")
@ViewScoped
public class PatrimonioBean implements Serializable {
    @Inject
    private PatrimonioClient patrimonioClient;

    public PatrimonioBean() {}

    public List<Patrimonio> findAll(){
        return patrimonioClient.findAll(List.class);
    }
}
