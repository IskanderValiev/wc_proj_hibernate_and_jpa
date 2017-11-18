package controllers;

import freemarker.FreemarkerTemplateHandler;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.countriesservices.CountryService;

@Controller

public class TeamsController {

    private CountryService countryService;

    public TeamsController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ModelAndView getAllCountries() {
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        modelAndView = workWithModelAndViews.showAllTeams(countryService.getAllCountries(), "teams");
        modelAndView.setViewName("country");
        return modelAndView;
    }
}
