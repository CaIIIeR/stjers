/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.watchlist;

import ee.ttu.idu0075._2017.ws.wlt.AddWatchlistFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.AddWatchlistRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistFilmListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistListResponse;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistRequest;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistFilmListType;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistFilmType;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistType;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * REST Web Service
 *
 * @author User
 */
@Path("watchlists")
public class WatchlistsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WatchlistsResource
     */
    public WatchlistsResource() {
    }

    @GET
    @Produces("application/json")
    public GetWatchlistListResponse getWatchlistList(@QueryParam("token") String token,
            @QueryParam("isEmpty") String isEmpty) {
        WatchlistWebService ws = new WatchlistWebService();
        GetWatchlistListRequest request = new GetWatchlistListRequest();
        request.setToken(token);
        if (isEmpty != null) {
            request.setIsEmpty(isEmpty);
        }
        return ws.getWatchlistList(request);
    }

    /**
     *
     * @param content
     * @param token
     * @return
     */
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public WatchlistType addWatchlist(WatchlistType content,
            @QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        AddWatchlistRequest request = new AddWatchlistRequest();
        request.setToken(token);
        request.setName(content.getName());
        return ws.addWatchList(request);
    }

    @GET
    @Path("{id : \\d+}") //support digit only
    @Produces("application/json")
    public WatchlistType getWatchlist(@PathParam("id") String id,
            @QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        GetWatchlistRequest request = new GetWatchlistRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getWatchlist(request);
    }

    /**
     *
     * @param content
     * @param token
     * @param id
     * @return
     * @throws javax.xml.datatype.DatatypeConfigurationException
     */
    @POST
    @Path("{id : \\d+}/films") //support digit only
    @Consumes("application/json")
    @Produces("application/json")
    public WatchlistFilmType addWatchlistFilm(
            AddWatchlistFilmRequest content,
            @QueryParam("token") String token,
            @PathParam("id") String id) throws DatatypeConfigurationException {
        WatchlistWebService ws = new WatchlistWebService();
        AddWatchlistFilmRequest request = new AddWatchlistFilmRequest();
        request.setToken(token);
        request.setWatchlistId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setFilmId(content.getFilmId());
        return ws.addWatchlistFilm(request);
    }

    @GET
    @Path("{id : \\d+}/films") //support digit only
    @Produces("application/json")
    public WatchlistFilmListType getWatchlistFilmList(
            @PathParam("id") String id,
            @QueryParam("token") String token) {
        WatchlistWebService ws = new WatchlistWebService();
        GetWatchlistFilmListRequest request = new GetWatchlistFilmListRequest();
        request.setWatchlistId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return ws.getWatchlistFilmlist(request);
    }
}
