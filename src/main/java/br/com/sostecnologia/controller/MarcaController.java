package br.com.sostecnologia.controller;

import br.com.sostecnologia.domain.Marca;
import br.com.sostecnologia.repository.MarcaRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sos-tecnologia/api")
public class MarcaController {

    @Inject
    private MarcaRepository marcaRepository;

    @GET
    @Path("/marcas")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMarcas(){
        return Response.ok().build();
    }

    @GET
    @Path("/marcas/{id}")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarMarca(@PathParam("id") String id){
        return Response.ok().build();
    }

    @POST
    @Path("/marcas/{id}")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarMarca(@BeanParam Marca marca){
        return Response.ok().build();
    }

    @PUT
    @Path("/marcas/{id}")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterarMarca(@PathParam("id") String id,
                                 @BeanParam Marca marca){
        return Response.ok().build();
    }

    @DELETE
    @Path("/marcas/{id}")
    @ApiOperation(value = "Retorna uma lista de marcas", notes = "Retorna uma lista de marcas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Um objeto JSON contendo uma lista de marcas.")})
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarMarca(@PathParam("id") String id){
        return Response.ok().build();
    }

}
