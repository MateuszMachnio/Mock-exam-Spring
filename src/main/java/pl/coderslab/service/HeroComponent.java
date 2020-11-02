package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.simpleTasks.Hero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class HeroComponent {

    private List<Hero> heroes;

    public HeroComponent() {
        this.heroes = new ArrayList<>();
        heroes.add(new Hero("superman", 10l, LocalDate.of(1800, 3, 13), "500-100-200"));
        heroes.add(new Hero("spiderman", 8l, LocalDate.of(1920, 5, 20), "600-600-600"));
        heroes.add(new Hero("batman", 4l, LocalDate.of(1970, 1, 25), "800-800-800"));
        heroes.add(new Hero("antman", null, LocalDate.of(2010, 12, 5), "100-100-100"));
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public Optional<Hero> findHeroByPhoneNumber(String phoneNumber) {
        return heroes.stream()
                .filter(hero -> hero.getPhoneNumber().equals(phoneNumber))
                .findFirst();
    }
}
