package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.service.PatrimonioService;
import br.com.sostecnologia.to.PatrimonioTO;
import br.com.sostecnologia.util.MappingUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

@Named(value = "patrimonioController")
@ApplicationScoped
public class PatrimonioController extends AbstractController {

    private Logger logger = Logger.getLogger(PatrimonioController.class);

    @Inject
    private PatrimonioService patrimonioService;

    @Inject
    private PatrimonioTO patrimonioTO;

    @Inject
    private MappingUtil<Patrimonio, PatrimonioTO> mappingUtil;

    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    public Response criarPatrimonio(){
        patrimonioTO.setNome("ok");
        patrimonioTO.setMarcaId(new Marca());
        patrimonioTO.getMarcaId().setNome("marca1");
        patrimonioTO.setDescricao("descricao");
        logger.info(mappingUtil.toToEntity(patrimonioTO, Patrimonio.class).toString());
        //patrimonioService.criarPatrimonio(mappingUtil.toToEntity(patrimonioTO, Patrimonio.class));
        return Response.ok().build();
    }



}
