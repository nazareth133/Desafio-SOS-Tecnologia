package br.com.sostecnologia.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "patrimonio")
@Data
public class Patrimonio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marcaId", nullable = false)
    private Marca marcaId;

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name= "numeroTombo")
    private String numeroTombo;

    @Column(name= "nome")
    private String nome;

    @Column(name= "descricao")
    private String descricao;

    public Patrimonio() {
    }

    public Patrimonio(Long id, Marca marcaId, String numeroTombo, String nome, String descricao) {
        this.id = id;
        this.marcaId = marcaId;
        this.numeroTombo = numeroTombo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Patrimonio{" +
                "id=" + id +
                ", marcaId=" + marcaId +
                ", numeroTombo=" + numeroTombo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrimonio that = (Patrimonio) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(marcaId, that.marcaId) &&
                Objects.equals(numeroTombo, that.numeroTombo) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marcaId, numeroTombo, nome, descricao);
    }
}
