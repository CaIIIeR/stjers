/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ttu.idu0075.watchlist;

import ee.ttu.idu0075._2017.ws.wlt.AddFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.AddWatchlistFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.AddWatchlistRequest;
import ee.ttu.idu0075._2017.ws.wlt.FilmType;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListResponse;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistFilmListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistListResponse;
import ee.ttu.idu0075._2017.ws.wlt.GetWatchlistRequest;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistFilmListType;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistFilmType;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author User
 */
@WebService(serviceName = "WatchlistService", portName = "WatchlistPort", endpointInterface = "ee.ttu.idu0075._2017.ws.wlt.WatchlistPortType", targetNamespace = "http://www.ttu.ee/idu0075/2017/ws/wlt", wsdlLocation = "WEB-INF/wsdl/WatchlistWebService/WatchlistService.wsdl")
public class WatchlistWebService {

    static int nextFilmId = 1;
    static List<FilmType> filmList = new ArrayList<FilmType>();

    static int nextWatchlistId = 1;
    static List<WatchlistType> watchlistList = new ArrayList<WatchlistType>();

    public FilmType getFilm(GetFilmRequest parameter) {
        FilmType filmType = null;
        if (parameter.getToken() != null && parameter.getId() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                for (int i = 0; i < filmList.size(); i++) {
                    if (filmList.get(i).getId().equals(parameter.getId())) {
                        filmType = filmList.get(i);
                    }
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return filmType;
    }

    public FilmType addFilm(AddFilmRequest parameter) {
        FilmType filmType = new FilmType();
        if (parameter.getName() != null
                && parameter.getYear() != null
                && parameter.getGenre() != null
                && parameter.getDurationInMinutes() != null
                && parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                filmType.setName(parameter.getName());
                filmType.setYear(parameter.getYear());
                filmType.setGenre(parameter.getGenre());
                filmType.setDurationInMinutes(parameter.getDurationInMinutes());
                for (FilmType filmInList : filmList) {
                    if (filmInList.getName().equalsIgnoreCase(parameter.getName())) {
                        return null;
                    }
                }
                filmType.setId(BigInteger.valueOf(nextFilmId++));
                filmList.add(filmType);
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return filmType;
    }

    public GetFilmListResponse getFilmList(GetFilmListRequest parameter) {
        GetFilmListResponse response = new GetFilmListResponse();
        if (parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                for (FilmType filmType : filmList) {
                    response.getFilm().add(filmType);
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return response;
    }

    public XMLGregorianCalendar getXMLGregorianCalendarNow()
            throws DatatypeConfigurationException {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now
                = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }

    public WatchlistFilmType addWatchlistFilm(AddWatchlistFilmRequest parameter) throws DatatypeConfigurationException {
        WatchlistFilmType watchlistFilm = new WatchlistFilmType();
        if (parameter.getFilmId() != null
                && parameter.getWatchlistId() != null
                && parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                GetFilmRequest filmRequest = new GetFilmRequest();
                filmRequest.setId(parameter.getFilmId());
                filmRequest.setToken(parameter.getToken());
                watchlistFilm.setFilm(getFilm(filmRequest));
                watchlistFilm.setDateAdded(getXMLGregorianCalendarNow());

                for (int i = 0; i < watchlistList.size(); i++) {
                    if (watchlistList.get(i).getId().equals(parameter.getWatchlistId())) {
                        for (int j = 0; j < watchlistList.get(i).getWatchlistFilmList().getWatchlistFilm().size(); j++) {
                            if (watchlistList.get(i).getWatchlistFilmList().getWatchlistFilm().get(j).getFilm().getId().equals(parameter.getFilmId())) {
                                return watchlistFilm;
                            }
                        }
                        watchlistList.get(i).getWatchlistFilmList().getWatchlistFilm().add(watchlistFilm);
                        return watchlistFilm;
                    }
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return null;
    }

    public WatchlistType addWatchList(AddWatchlistRequest parameter) {
        WatchlistType watchlistType = new WatchlistType();
        if (parameter.getName() != null && parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                watchlistType.setName(parameter.getName());
                watchlistType.setWatchlistFilmList(new WatchlistFilmListType());
                for (WatchlistType watchlist : watchlistList) {
                    if (watchlist.getName().equalsIgnoreCase(parameter.getName())) {
                        return null;
                    }
                }
                watchlistType.setId(BigInteger.valueOf(nextWatchlistId++));
                watchlistList.add(watchlistType);
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return watchlistType;
    }

    public WatchlistType getWatchlist(GetWatchlistRequest parameter) {
        WatchlistType watchlistType = null;
        if (parameter.getId() != null && parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                for (int i = 0; i < watchlistList.size(); i++) {
                    if (watchlistList.get(i).getId().equals(parameter.getId())) {
                        watchlistType = watchlistList.get(i);
                    }
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return watchlistType;
    }

    public GetWatchlistListResponse getWatchlistList(GetWatchlistListRequest parameter) {
        GetWatchlistListResponse response = new GetWatchlistListResponse();
        if (parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                for (WatchlistType watchlistType : watchlistList) {
                    if (parameter.getIsEmpty().equalsIgnoreCase("ei") || parameter.getIsEmpty().equalsIgnoreCase("jah")) {
                        if (((parameter.getIsEmpty().equalsIgnoreCase("ei") && (!watchlistType.getWatchlistFilmList().getWatchlistFilm().isEmpty()))
                                || (parameter.getIsEmpty().equalsIgnoreCase("jah") && watchlistType.getWatchlistFilmList().getWatchlistFilm().isEmpty()))) {
                            response.getWatchlist().add(watchlistType);
                        }
                    } else {
                        response.getWatchlist().add(watchlistType);
                    }
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return response;
    }

    public WatchlistFilmListType getWatchlistFilmlist(GetWatchlistFilmListRequest parameter) {
        WatchlistFilmListType invoiceProductList = null;
        if (parameter.getWatchlistId() != null && parameter.getToken() != null) {
            if (parameter.getToken().equalsIgnoreCase("salajane")) {
                for (int i = 0; i < watchlistList.size(); i++) {
                    if (watchlistList.get(i).getId().equals(parameter.getWatchlistId())) {
                        invoiceProductList = watchlistList.get(i).getWatchlistFilmList();
                    }
                }
            } else {
                throw new RuntimeException("Wrong token");
            }
        } else {
            throw new RuntimeException("Parameters cannot be null");
        }
        return invoiceProductList;
    }
}
