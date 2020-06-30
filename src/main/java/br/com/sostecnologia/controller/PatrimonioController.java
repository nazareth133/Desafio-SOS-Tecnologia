package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.service.PatrimonioService;
import br.com.sostecnologia.to.PatrimonioTO;
import br.com.sostecnologia.util.ConstantsUtil;
import br.com.sostecnologia.util.MappingUtil;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@ApplicationScoped
@Named(value = "patrimonioController")
@Path("/api/sos-tecnologia")
public class PatrimonioController extends AbstractController {

    private Logger logger = Logger.getLogger(PatrimonioController.class);

    @Inject
    private PatrimonioService patrimonioService;

    private PatrimonioTO patrimonioTO;

    private Patrimonio selectedPatrimonio;

    @Inject
    private MappingUtil<Patrimonio, PatrimonioTO> mappingUtil;

    @POST
    @Path(ConstantsUtil.CRIAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarPatrimonio(@BeanParam PatrimonioTO patrimonioTO){
        logger.info(patrimonioTO);
        Patrimonio patrimonio = mappingUtil.toToEntity(patrimonioTO, Patrimonio.class);
        this.patrimonioTO = new PatrimonioTO();
        this.patrimonioTO.setNumeroTombo(Math.abs(Math.round(Math.random()*((1-10000)+1))+1));
        this.patrimonioTO.setMarcaId(new Marca());
        return Response.ok(patrimonioService.criarPatrimonio(patrimonio)).build();
    }

    @PUT
    @Path(ConstantsUtil.EDITAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarPatrimonio(@BeanParam Patrimonio patrimonio, @PathParam("id") String id){
        logger.info(selectedPatrimonio);
        return Response.ok(patrimonioService.editarPatrimonio(patrimonio)).build();
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
    public List<Patrimonio> listarPatrimonio(){
        List<Patrimonio> listaPatrimonio = patrimonioService.listarPatrimonio();
        logger.info(listaPatrimonio);
        return listaPatrimonio;
    }


    @DELETE
    @Path(ConstantsUtil.DELETAR_PATRIMONIO_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarPatrimonio(@BeanParam Patrimonio patrimonio){
        logger.info(patrimonio);
        patrimonioService.deletarPatrimonio(patrimonio);
        return Response.ok().build();
    }

    @DELETE
    @Path("teste/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste(byte[] patrimonio, @PathParam("id") String id){
        logger.info(new String(patrimonio) + "id:" + id);
        patrimonioService.deletarPatrimonio(mappingUtil.toToEntity(new Gson().fromJson(new String(patrimonio), PatrimonioTO.class), Patrimonio.class));
        return Response.ok().build();
    }

    public PatrimonioTO getPatrimonioTO() {
        if (patrimonioTO == null ) {
            patrimonioTO = new PatrimonioTO();
            patrimonioTO.setMarcaId(new Marca());
            patrimonioTO.setNumeroTombo(Math.abs(Math.round(Math.random()*((1-10000)+1))+1));
        }
        return patrimonioTO;
    }

    public void setPatrimonioTO(PatrimonioTO contratoTO) {
        this.patrimonioTO = patrimonioTO;
    }

    public Patrimonio getSelectedPatrimonio(){
        if (selectedPatrimonio == null ) {
            selectedPatrimonio = Faces.getFlashAttribute("selectedPatrimonio");
        }
        return selectedPatrimonio;
    }

    public void setSelectecPatrimonio(Patrimonio patrimonio){
        Faces.setFlashAttribute("selectedPatrimonio", patrimonio);
        selectedPatrimonio = patrimonio;
    }

}
