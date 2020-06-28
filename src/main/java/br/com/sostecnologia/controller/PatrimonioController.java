package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.domain.Patrimonio;
import br.com.sostecnologia.repository.PatrimonioRepository;
import br.com.sostecnologia.service.PatrimonioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sos-tecnologia/api")
@Named(value = "patrimonioController")
@ApplicationScoped
public class PatrimonioController extends AbstractController {

    @Inject
    private PatrimonioService patrimonioService;

    @POST
    @Path("/patrimonios")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarPatrimonios() throws Exception{
        Patrimonio patrimonio = new Patrimonio();
        patrimonio.setDescricao("ok");
        patrimonio.setNome("nome");
        patrimonio.setMarcaId(new Marca());
        patrimonioService.criarPatrimonio(patrimonio);
        return Response.ok().build();
    }

//    @GET
//    @Path("/patrimonios/{id}")
//    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response listarPatrimonio(@PathParam("id") String id){
//        return Response.ok(patrimonioRepository.find(id)).build();
//    }
//
//    @POST
//    @Path("/patrimonios")
//    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response criarPatrimonio(@BeanParam Patrimonio patrimonio){
//        patrimonioRepository.create(patrimonio);
//        return Response.ok().build();
//    }
//
//    @PUT
//    @Path("/patrimonios/{id}")
//    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response alterarPatrimonio(@PathParam("id") Long id,
//                                      @BeanParam Patrimonio patrimonio){
//        patrimonio.setId(id);
//        patrimonioRepository.edit(patrimonio);
//        return Response.ok().build();
//    }
//
//    @DELETE
//    @Path("/patrimonios/{id}")
//    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
//    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response deletarPatrimonio(@PathParam("id") Long id){
//        Patrimonio patrimonio = new Patrimonio();
//        patrimonio.setId(id);
//        patrimonioRepository.remove(patrimonio);
//        return Response.ok().build();
//    }

}
