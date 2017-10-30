package controllers;

import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.clubsservices.ClubService;
import services.countriesservices.CountryService;
import services.playersservices.PlayersService;

import javax.servlet.http.HttpServletRequest;


@Controller

public class PlayersController {

    private PlayersService playersService;
    private CountryService countryService;
    private ClubService clubService;

    public PlayersController(PlayersService playersService, CountryService countryService, ClubService clubService) {
        this.playersService = playersService;
        this.countryService = countryService;
        this.clubService = clubService;
    }

    @RequestMapping(value = "/squad", method = RequestMethod.GET)
    public ModelAndView setSquad(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        Integer country = Integer.parseInt(request.getParameter("countryName"));
        System.out.println(country);
        modelAndView.addObject("countryName", country);
        System.out.println("players: " + playersService.getAllPlayersByCountry(country));
        modelAndView.addObject("players", playersService.getAllPlayersByCountry(country));
        modelAndView.setViewName("players");
        return modelAndView;
    }

    @RequestMapping(value = "/playerinfo", method = RequestMethod.GET)
    public ModelAndView showPlayerInfo(HttpServletRequest request) {
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        ModelAndView modelAndView;
        String playerName = request.getParameter("playerName");
        String playerNumber = playersService.getColumnByName("player_number", playerName);
        String playerPosition = playersService.getColumnByName("player_position", playerName);
        String playerLastname = playersService.getColumnByName("player_lastname", playerName);
        String playerAge = playersService.getColumnByName("player_age", playerName);
        String playerClub = playersService.getColumnByName("player_club", playerName);
        String playerCountry = playersService.getColumnByName("player_country", playerName);
        String playerPhoto = playersService.getColumnByName("player_photo", playerName);


        modelAndView = workWithModelAndViews.showPlayerInfo(playerNumber, playerPosition, playerName, playerLastname, playerAge, playerClub, playerCountry, playerPhoto, "playerinfo");
        modelAndView.addObject("countryImage", countryService.getColumnByName("country_flag", playerCountry));
        modelAndView.addObject("clubLogo", clubService.getLogoByName(playerClub));
        return modelAndView;
    }
}
