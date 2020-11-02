package pl.coderslab.simpleTasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainHero {

    public static void main(String[] args) {

        Hero superman = new Hero("superman", 10l, LocalDate.of(1800, 3, 13), "500-100-200");
        Hero spiderman = new Hero("spiderman", 8l, LocalDate.of(1920, 5, 20), "600-600-600");
        Hero batman = new Hero("batman", 4l, LocalDate.of(1970, 1, 25), "800-800-800");
        Hero antman = new Hero("antman", null, LocalDate.of(2010, 12, 5), "100-100-100");
        List<Hero> heroes = Arrays.asList(superman, spiderman, batman, antman);

        String collect = heroes.stream()
                .filter(hero -> hero.getPower() != null)
                .filter(hero -> hero.getPower() > 5)
                .filter(hero -> hero.getName().length() > 2)
                .filter(hero -> hero.getName().charAt(1) == 'u')
                .sorted()
                .map(Hero::getName)
                .map(s -> s.substring(0, 1).toUpperCase())
                .collect(Collectors.joining("-"));
        System.out.println(collect);

    }
}
