package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;
import pl.coderslab.service.HeroComponent;
import pl.coderslab.simpleTasks.Hero;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ExamController {

    private final HeroComponent heroComponent;

    public ExamController(HeroComponent heroComponent) {
        this.heroComponent = heroComponent;
    }

    @GetMapping("/add-hero")
    public String addHeroForm() {
        return "addingHero";
    }

    @PostMapping("/add-hero")
    public String addHero(Model model, @RequestParam String name, @RequestParam Long power, @RequestParam String date, @RequestParam String phone) {
        Hero hero = new Hero(name, power, LocalDate.parse(date), phone);
        heroComponent.addHero(hero);
        model.addAttribute("hero", hero);
        return "heroDetails";
    }

    @GetMapping("/hero-list")
    public String heroList(Model model) {
        Map<String, Integer> heroes = heroComponent.getHeroes().stream()
                .filter(hero -> hero.getDateOfBirth().getYear() > 2000)
                .peek(hero -> hero.setName(hero.getName().substring(0, 1).toUpperCase() + hero.getName().substring(1)))
                .collect(Collectors.toMap(Hero::getName, hero -> Period.between(hero.getDateOfBirth(), LocalDate.now()).getYears()));
        model.addAttribute("heroes", heroes);
        return "heroes";
    }

    @GetMapping("/add-cookies")
    public String addCookies(HttpServletResponse response) {
        Cookie cookie1 = new Cookie("user", "Jan");
        cookie1.setMaxAge(60 * 10);
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        cookie2.setMaxAge(60 * 60 * 24 * 10);
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        cookie3.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return "redirect:all-cookies";
    }

    @GetMapping("/all-cookies")
    public String showCookies(HttpServletRequest request, Model model) {
        Cookie cookie1 = WebUtils.getCookie(request, "user");
        Cookie cookie2 = WebUtils.getCookie(request, "uid");
        Cookie cookie3 = WebUtils.getCookie(request, "IDE");
        model.addAttribute("cookies", Arrays.asList(cookie1, cookie2, cookie3));
        return "cookies";
    }
}
