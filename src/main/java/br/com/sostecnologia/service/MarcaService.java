package br.com.sostecnologia.service;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.MarcaRepository;
import br.com.sostecnologia.repository.PatrimonioRepository;

import javax.inject.Inject;
import java.util.List;

public class MarcaService {

    @Inject
    private MarcaRepository marcaRepository;

    public Marca criarMarca(Marca marca){
        return marcaRepository.save(marca);
    }

    public Marca editarMarca(Marca marca){
        return marcaRepository.update(marca);
    }

    public void deletarMarca(Marca marca){
        marcaRepository.delete(marca);
    }

    public Marca buscarMarca(Marca marca){
        return marcaRepository.find(marca.getId()).get();
    }

    public List<Marca> listarMarca(){
        return marcaRepository.findAll();
    }

    public Integer countMarca(Marca marca){
        return marcaRepository.count();
    }

}
