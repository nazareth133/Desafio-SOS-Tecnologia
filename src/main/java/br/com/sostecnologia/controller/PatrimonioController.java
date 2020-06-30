package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.service.PatrimonioService;
import br.com.sostecnologia.to.PatrimonioTO;
import br.com.sostecnologia.util.ConstantsUtil;
import br.com.sostecnologia.util.MappingUtil;
import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Named(value = "patrimonioController")
@Path("/api/sos-tecnologia")
public class PatrimonioController extends AbstractController {

    private Logger logger = Logger.getLogger(PatrimonioController.class);

    @Inject
    private PatrimonioService patrimonioService;

    private PatrimonioTO patrimonioTO;

    @Inject
    private MappingUtil<Patrimonio, PatrimonioTO> mappingUtil;

    @POST
    @Path(ConstantsUtil.CRIAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarPatrimonio(@BeanParam PatrimonioTO patrimonioTO){
        Patrimonio patrimonio = mappingUtil.toToEntity(patrimonioTO, Patrimonio.class);
        this.patrimonioTO = new PatrimonioTO();
        this.patrimonioTO.setMarcaId(new Marca());
        return Response.ok(patrimonioService.criarPatrimonio(patrimonio)).build();
    }

    @PUT
    @Path(ConstantsUtil.EDITAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarPatrimonio(@BeanParam PatrimonioTO patrimonio, @PathParam("id") String id){
        return Response.ok(patrimonioService.editarPatrimonio(mappingUtil.toToEntity(patrimonioTO, Patrimonio.class))).build();
    }


    @GET
    @Path(ConstantsUtil.BUSCAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPatrimonio(@BeanParam PatrimonioTO patrimonio, @PathParam("id") String id){
        return Response.ok(patrimonioService.buscarPatrimonio(mappingUtil.toToEntity(patrimonioTO, Patrimonio.class))).build();
    }

    @GET
    @Path(ConstantsUtil.LISTAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPatrimonio(){
        return Response.ok(patrimonioService.listarPatrimonio()).build();
    }


    @DELETE
    @Path(ConstantsUtil.DELETAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPatrimonio(@BeanParam PatrimonioTO patrimonio){
        patrimonioService.deletarPatrimonio(mappingUtil.toToEntity(patrimonioTO, Patrimonio.class));
        return Response.ok().build();
    }

    public PatrimonioTO getPatrimonioTO() {
        if (patrimonioTO == null ) {
            patrimonioTO = new PatrimonioTO();
            patrimonioTO.setMarcaId(new Marca());
        }
        return patrimonioTO;
    }

    public void setPatrimonioTO(PatrimonioTO contratoTO) {
        this.patrimonioTO = patrimonioTO;
    }

}
