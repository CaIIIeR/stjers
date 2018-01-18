/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.watchlist;

import ee.ttu.idu0075._2017.ws.wlt.AddFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.FilmType;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListResponse;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmRequest;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("films")
public class FilmsResource {

    @Context
    private UriInfo context;

    public FilmsResource() {
    }

    @GET
    @Produces("application/json")
    public GetFilmListResponse getFilmList(@QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        GetFilmListRequest request = new GetFilmListRequest();
        request.setToken(token);
        return ws.getFilmList(request);
    }

    @GET
    @Path("{id : \\d+}") //supports digits only
    @Produces("application/json")
    public FilmType getFilm(@PathParam("id") String id,
            @QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        GetFilmRequest request = new GetFilmRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getFilm(request);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public FilmType addFilm(FilmType content,
            @QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        AddFilmRequest request = new AddFilmRequest();
        request.setName(content.getName());
        request.setYear(content.getYear());
        request.setGenre(content.getGenre());
        request.setDurationInMinutes(content.getDurationInMinutes());
        request.setToken(token);
        return ws.addFilm(request);
    }
}
