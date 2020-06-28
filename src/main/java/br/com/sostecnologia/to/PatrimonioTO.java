package br.com.sostecnologia.to;

import br.com.sostecnologia.domain.Marca;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatrimonioTO {

    private Long id;
    private Marca marcaId;
    private Long numeroTombo;
    private String nome;
    private String descricao;

    public Long getId() {
        return id;
    }

}
