package br.com.sostecnologia.service;

import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;

import javax.inject.Inject;
import java.util.List;

public class PatrimonioService {

    @Inject
    private PatrimonioRepository patrimonioRepository;

    public Patrimonio criarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.save(patrimonio);
    }

    public Patrimonio editarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.update(patrimonio);
    }

    public void deletarPatrimonio(Patrimonio patrimonio){
        patrimonioRepository.delete(patrimonio);
    }

    public Patrimonio buscarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.find(patrimonio.getId()).get();
    }

    public List<Patrimonio> listarPatrimonio(){
        return patrimonioRepository.findAll();
    }

    public Integer countPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.count();
    }

}
