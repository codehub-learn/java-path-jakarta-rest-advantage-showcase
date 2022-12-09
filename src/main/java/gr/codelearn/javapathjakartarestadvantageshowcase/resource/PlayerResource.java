package gr.codelearn.javapathjakartarestadvantageshowcase.resource;

import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Ability;
import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Player;
import gr.codelearn.javapathjakartarestadvantageshowcase.service.PlayerService;
import gr.codelearn.javapathjakartarestadvantageshowcase.transfer.ApiResponse;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("players")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerResource {
    @Inject
    PlayerService playerService;

    @POST
    public Response create(@Valid Player player){
        return Response.ok().entity(ApiResponse.builder().data(playerService.create(player)).build()).build();
    }

    @GET
    public Response findAll(){
        return  Response.ok().entity(ApiResponse.builder().data(playerService.findAll()).build()).build();
    }

    @POST
    @Path("/{id}/abilities")
    public Response addAbility(@PathParam("id") final Long id,@Valid Ability ability){
        playerService.addAbility(id, ability);
        return Response.noContent().entity(ApiResponse.builder().build()).build();
    }
}
