package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.MarcaRepository;
import br.com.sostecnologia.service.MarcaService;
import br.com.sostecnologia.service.PatrimonioService;
import br.com.sostecnologia.to.MarcaTO;
import br.com.sostecnologia.to.PatrimonioTO;
import br.com.sostecnologia.util.ConstantsUtil;
import br.com.sostecnologia.util.MappingUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Named(value = "marcaController")
@Path("/api/sos-tecnologia")
public class MarcaController extends AbstractController {

    @Inject
    private MarcaService marcaService;

    @Inject
    private MarcaTO marcaTO;

    @Inject
    private MappingUtil<Marca, MarcaTO> mappingUtil;

    @POST
    @Path(ConstantsUtil.CRIAR_MARCA_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarMarca(@BeanParam MarcaTO marcaTO){
        return Response.ok(marcaService.criarMarca(mappingUtil.toToEntity(marcaTO, Marca.class))).build();
    }

    @PUT
    @Path(ConstantsUtil.EDITAR_MARCA_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editarMarca(@BeanParam MarcaTO marca, @PathParam("id") String id){
        return Response.ok(marcaService.editarMarca(mappingUtil.toToEntity(marcaTO, Marca.class))).build();
    }

    @GET
    @Path(ConstantsUtil.BUSCAR_MARCA_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarMarca(@BeanParam MarcaTO marca, @PathParam("id") String id){
        return Response.ok(marcaService.buscarMarca(mappingUtil.toToEntity(marcaTO, Marca.class))).build();
    }

    @GET
    @Path(ConstantsUtil.LISTAR_MARCA_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMarca(){
        return Response.ok(marcaService.listarMarca()).build();
    }


    @DELETE
    @Path(ConstantsUtil.DELETAR_MARCA_PATH)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarMarca(@BeanParam MarcaTO marca){
        marcaService.deletarMarca(mappingUtil.toToEntity(marcaTO, Marca.class));
        return Response.ok().build();
    }

}
