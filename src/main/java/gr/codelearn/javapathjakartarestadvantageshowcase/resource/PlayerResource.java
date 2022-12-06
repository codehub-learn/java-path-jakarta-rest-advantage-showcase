package gr.codelearn.javapathjakartarestadvantageshowcase.resource;

import gr.codelearn.javapathjakartarestadvantageshowcase.domain.Player;
import gr.codelearn.javapathjakartarestadvantageshowcase.service.PlayerService;
import jakarta.inject.Inject;
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
    public Response create(Player player){
        return Response.status(Response.Status.CREATED).entity(playerService.create(player)).build();
    }

    @GET
    public Response findAll(){
        return Response.ok(playerService.findAll()).build();
    }
}
