package br.com.sostecnologia.to;

import br.com.sostecnologia.domain.Marca;
import javassist.bytecode.ByteArray;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PdfTO {

    private Long id;
    private Byte[] conteudo;

    public PdfTO() {
    }

    public PdfTO(Long id, Byte[] conteudo) {
        this.id = id;
        this.conteudo = conteudo;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PatrimonioTO{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
