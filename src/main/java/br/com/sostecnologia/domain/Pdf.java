package br.com.sostecnologia.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javassist.bytecode.ByteArray;
import lombok.Data;

@Entity
@Table(name = "patrimonio")
@Data
public class Pdf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "conteudo")
    private Byte[] conteudo;


    public Pdf() {
    }

    public Pdf(Long id, Byte[] conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(Byte[] conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Patrimonio{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdf that = (Pdf) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(conteudo, that.conteudo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conteudo);
    }
}
