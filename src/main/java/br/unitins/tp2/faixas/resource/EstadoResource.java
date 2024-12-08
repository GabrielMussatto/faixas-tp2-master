package br.unitins.tp2.faixas.resource;

import br.unitins.tp2.faixas.dto.EstadoDTO;
import br.unitins.tp2.faixas.service.EstadoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/estados")
public class EstadoResource {

    @Inject
    public EstadoService estadoService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(estadoService.findById(id)).build();
    }

    @GET
    @RolesAllowed("Adm")
    public Response findAll(
            @DefaultValue("0") @QueryParam("page") int page,
            @DefaultValue("100") @QueryParam("pageSize") int pageSize) {
        return Response.ok(estadoService.findAll(page, pageSize)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(
            @PathParam("nome") 
            @DefaultValue("0") @QueryParam("page") int page,
            @DefaultValue("100") @QueryParam("pageSize") int pageSize,
            String nome) {
        return Response.ok(estadoService.findByNome(page, pageSize, nome)).build();
    }

    @GET
    @Path("/search/sigla/{sigla}")
    public Response findBySigla(
            @PathParam("sigla") 
            @DefaultValue("0") @QueryParam("page") int page,
            @DefaultValue("100") @QueryParam("pageSize") int pageSize,
            String sigla) {
        return Response.ok(estadoService.findBySigla(page, pageSize, sigla)).build();
    }

    @GET
    @Path("/count")
    public Response count() {
        return Response.ok(estadoService.count()).build();
    }

    @POST
    public Response create(EstadoDTO dto) {
        return Response.status(Status.CREATED).entity(estadoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, EstadoDTO dto) {
        estadoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        estadoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

}
