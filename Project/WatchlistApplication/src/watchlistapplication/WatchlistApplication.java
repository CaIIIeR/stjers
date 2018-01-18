/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watchlistapplication;

import ee.ttu.idu0075._2017.ws.wlt.AddFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.FilmType;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListRequest;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmListResponse;
import ee.ttu.idu0075._2017.ws.wlt.GetFilmRequest;
import ee.ttu.idu0075._2017.ws.wlt.WatchlistService;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class WatchlistApplication {

    public static void main(String[] args) {
        String token = "salajane";
        Scanner scanner = new Scanner(System.in);
        boolean endWork = false;
        while (endWork != true) {
            System.out.println("Choose an operation: addFilm, getFilm, exit - close the client");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                endWork = true;
            } else if (operation.equalsIgnoreCase("addFilm")) {
                AddFilmRequest request = new AddFilmRequest();
                request.setToken(token);
                System.out.println("Please input film data:");

                System.out.println("Name:");
                String name;

                WatchlistService service = new WatchlistService();
                GetFilmListRequest filmListRequest = new GetFilmListRequest();
                filmListRequest.setToken(token);
                List<FilmType> films = service.getWatchlistPort().getFilmList(filmListRequest).getFilm();

                boolean filmAlreadyInList = true;
                while (filmAlreadyInList) {
                    name = scanner.next();
                    filmAlreadyInList = checkIfFilmAlreadyInList(films, name);
                    if (filmAlreadyInList) {
                        System.out.println("Film already exists, use another name.");
                    } else {
                        request.setName(name);
                        break;
                    }
                }

                System.out.println("Year:");
                request.setYear((BigInteger.valueOf(Integer.valueOf(scanner.next()))));

                System.out.println("Genre:");
                request.setGenre(scanner.next());

                System.out.println("Duration in minutes:");
                request.setDurationInMinutes((BigInteger.valueOf(Integer.valueOf(scanner.next()))));

                System.out.println("FILM ADDED, FILM ID: " + addFilm(request).getId());

            } else if (operation.equalsIgnoreCase("getFilm")) {
                GetFilmRequest request = new GetFilmRequest();
                request.setToken(token);
                System.out.println("Please input required data:");
                System.out.println("Film id:");
                request.setId((BigInteger.valueOf(Integer.valueOf(scanner.next()))));
                System.out.println("Film:");
                System.out.println("Id: " + getFilm(request).getId());
                System.out.println("Name: " + getFilm(request).getName());
                System.out.println("Year: " + getFilm(request).getYear());
                System.out.println("Genre: " + getFilm(request).getGenre());
                System.out.println("Duration in minutes: " + getFilm(request).getDurationInMinutes());
            }
        }
    }

    public static boolean checkIfFilmAlreadyInList(List<FilmType> filmList, String nameOfFilmToAdd) {
        for (FilmType film : filmList) {
            if (film.getName().equalsIgnoreCase(nameOfFilmToAdd)) {
                return true;
            }
        }
        return false;
    }

    private static FilmType addFilm(ee.ttu.idu0075._2017.ws.wlt.AddFilmRequest parameter) {
        ee.ttu.idu0075._2017.ws.wlt.WatchlistService service = new ee.ttu.idu0075._2017.ws.wlt.WatchlistService();
        ee.ttu.idu0075._2017.ws.wlt.WatchlistPortType port = service.getWatchlistPort();
        return port.addFilm(parameter);
    }

    private static FilmType getFilm(ee.ttu.idu0075._2017.ws.wlt.GetFilmRequest parameter) {
        ee.ttu.idu0075._2017.ws.wlt.WatchlistService service = new ee.ttu.idu0075._2017.ws.wlt.WatchlistService();
        ee.ttu.idu0075._2017.ws.wlt.WatchlistPortType port = service.getWatchlistPort();
        return port.getFilm(parameter);
    }

    private static GetFilmListResponse getFilmList(ee.ttu.idu0075._2017.ws.wlt.GetFilmListRequest parameter) {
        ee.ttu.idu0075._2017.ws.wlt.WatchlistService service = new ee.ttu.idu0075._2017.ws.wlt.WatchlistService();
        ee.ttu.idu0075._2017.ws.wlt.WatchlistPortType port = service.getWatchlistPort();
        return port.getFilmList(parameter);
    }

}
