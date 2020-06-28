package br.com.sostecnologia.service;

import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.util.RequestAPIUtil;
import com.google.gson.Gson;
import com.squareup.okhttp.HttpUrl;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class PatrimonioService {

    @Inject
    private PatrimonioRepository patrimonioRepository;

    public Patrimonio criarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.save(patrimonio);
    }

    public Patrimonio alterarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.update(patrimonio);
    }

    public void deletarPatrimonio(Patrimonio patrimonio){
        patrimonioRepository.delete(patrimonio);
    }

    public Patrimonio buscarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.find(patrimonio.getId()).get();
    }

    public List<Patrimonio> listarPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.findAll();
    }

    public Integer countPatrimonio(Patrimonio patrimonio){
        return patrimonioRepository.count();
    }

}
