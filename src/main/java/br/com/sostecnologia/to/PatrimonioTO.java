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

    public PatrimonioTO() {
    }

    public PatrimonioTO(Long id, Marca marcaId, Long numeroTombo, String nome, String descricao) {
        this.id = id;
        this.marcaId = marcaId;
        this.numeroTombo = numeroTombo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    public Long getNumeroTombo() {
        return numeroTombo;
    }

    public void setNumeroTombo(Long numeroTombo) {
        this.numeroTombo = numeroTombo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

}
