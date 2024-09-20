package br.unitins.tp2.faixas.resource;

import br.unitins.tp2.faixas.dto.CidadeDTO;
import br.unitins.tp2.faixas.service.CidadeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cidades")
public class CidadeResource {

    @Inject
    public CidadeService cidadeService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(cidadeService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(cidadeService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(cidadeService.findByNome(nome)).build();
    }
    @POST
    public Response create(CidadeDTO dto) {
        return Response.status(Status.CREATED).entity(cidadeService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CidadeDTO dto) {
        cidadeService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        cidadeService.delete(id);
        return Response.status(Status.NO_CONTENT).build();

    }

}