package domain;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

/**
 * Created by kpant on 6/16/17.
 */

@Path("/foods")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class FoodRestService {
    @Context
    private UriInfo uriInfo;

    @POST
    public Response create(Food food) {
        if(food == null)
            throw new BadRequestException();
        FoodManager.add(food);
        URI uri = uriInfo.getAbsolutePathBuilder().path(food.getName()).build();
        return Response.created(uri).build();
    }

    @PUT
    public Response update(Food food) {
        return Response.ok().build();
    }

    @GET
    @Path("{name}")
    public Response get(@PathParam("name") String name) {
        Food food = FoodManager.find(name);
        if(food == null)
            throw new NotFoundException();
        return Response.ok(food).build();

    }

    @GET
    public Response getAll(){
        FoodList foodList = FoodManager.getFoods();
        GenericEntity<List<Food>> list = new GenericEntity<List<Food>>(foodList){};
        return Response.ok(list).build();
    }

    @DELETE
    @Path("{name}")
    public Response delete(@PathParam("name") String name) {
        FoodManager.delete(name);
        return Response.noContent().build();

    }
}
