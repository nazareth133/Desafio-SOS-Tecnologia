package br.com.sostecnologia.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MarcaTO {

    private Long id;

    private String nome;

    public MarcaTO() {
    }

    public MarcaTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "MarcaTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
