package controllers;

import cookies.Cookies;
import cookies.CookiesImpl;
import encoders.Encoder;
import freemarker.FreemarkerTemplateHandler;
import freemarker.template.TemplateException;
import modelandviews.WorkWithModelAndViews;
import modelandviews.WorkWithModelAndViewsImpl;
import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.usersservices.UsersService;
import sessions.Sessions;
import sessions.SessionsImpl;
import validators.UsersValidator;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response) throws IOException, TemplateException {
        ModelAndView modelAndView = new ModelAndView("profile");
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", request, response);
        String login = Encoder.decryptCookie("iskander", cookie.getValue());
        String name = usersService.getParameterByLogin("name", login) + " " + usersService.getParameterByLogin("lastname", login);
        boolean getGender = usersService.getGenderByLogin(login);
        String gender;
        if (getGender) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String bday = usersService.getDateByLogin(login).toString();
        String city = usersService.getParameterByLogin("city", login);
        String telephone = usersService.getParameterByLogin("telephone", login);
        String email = usersService.getParameterByLogin("email", login);
        String image = usersService.getParameterByLogin("photo", login);
        modelAndView = workWithModelAndViews.showUsersData(login, name, gender, bday, city, telephone, email, image, "profile");
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public ModelAndView entrance(HttpServletRequest request, HttpServletResponse response) throws LoginException, NoSuchAlgorithmException{

        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();

        if (request.getParameter("signin") != null) {

            String enterlogin = request.getParameter("enterlogin");
            String enterpassword = Encoder.encrypt(usersService.getParameterByLogin("salt", enterlogin) + request.getParameter(  "enterpass"));


            //checking login and password
            if (enterpassword.equals(usersService.getParameterByLogin("password", enterlogin))) {

                //adding cookies
                Cookies cookies = new CookiesImpl();
                cookies.addCookie("login", Encoder.encryptCookie("iskander", enterlogin), response, 365*24*60*60);

                //adding sessions
                if (request.getParameter("remember") != null) {
                    Sessions sessions = new SessionsImpl();
                    sessions.addSession("login", enterlogin, request);
                }

                //getting info about user
//                String name = usersService.getParameterByLogin("name", enterlogin) + " " + usersService.getParameterByLogin("lastname", enterlogin);
//                boolean getGender = usersService.getGenderByLogin(enterlogin);
//                String gender = "";
//                if (getGender) {
//                    gender = "Male";
//                } else {
//                    gender = "Female";
//                }
//                String bday = usersService.getDateByLogin(enterlogin).toString();
//                String city = usersService.getParameterByLogin("city", enterlogin);
//                String telephone = usersService.getParameterByLogin("telephone", enterlogin);
//                String image = usersService.getParameterByLogin("photo", enterlogin);

                //adding info about user to jsp
//                modelAndView = workWithModelAndViews.showUsersData(enterlogin, name, gender, bday, city, telephone, email, image, "profile");
                modelAndView.setViewName("redirect:/profile");
            } else {

                //throwing exception about incorrect login or password
                modelAndView = workWithModelAndViews.throwException("Login or password is incorrect.", "index");
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) throws LoginException, NoSuchAlgorithmException, ParseException{
        ModelAndView modelAndView = new ModelAndView();
        WorkWithModelAndViews workWithModelAndViews = new WorkWithModelAndViewsImpl();
        if (request.getParameter("signup") != null) {

            //getting data from html form
            String login = request.getParameter("login");
            String password = request.getParameter("pass");
            String cpassword = request.getParameter("cpassword");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lname");
            boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

            //setting data from format
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            java.util.Date parser = simpleDateFormat.parse(request.getParameter("byear")+ request.getParameter("bmon") + request.getParameter("bday"));
            Date bday = new Date(parser.getTime());
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            String telephone = request.getParameter("phone");

            //creating salt for hashing
            String salt = Encoder.salt();

            if(UsersValidator.isCorrect(login, password, cpassword, name, lastname,  city, bday, email, telephone)) {
//                if (!usersService.exists(login)) {
//                    if (!usersService.existingEmail(email)) {
                User user = User.builder()
                        .login(login)
                        .password(Encoder.encrypt(salt + password))
                        .name(name)
                        .lastname(lastname)
                        .gender(gender)
                        .bday(bday)
                        .city(city)
                        .telephone(telephone)
                        .email(email)
                        .salt(salt)
                        .build();

                        usersService.addUser(user);
                System.out.println(user.toString());
                        modelAndView.setViewName("success");
//                    } else {
//                        modelAndView = workWithModelAndViews.throwException("User with such email already exists", "index");
//                    }
//                } else {
//                    modelAndView = workWithModelAndViews.throwException("User with such login already exists", "index");
//                }
            } else {
                modelAndView = workWithModelAndViews.throwException("You have to fill all fields", "index");
            }
        }
        return modelAndView;
    }
}
