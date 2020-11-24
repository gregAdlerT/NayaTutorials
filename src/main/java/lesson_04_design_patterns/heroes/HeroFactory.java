package lesson_04_design_patterns.heroes;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Greg Adler
 */
public class HeroFactory {
    List<Class<? extends Hero>> heroes;
    public HeroFactory (){
        Reflections scanner=new Reflections("Lesson_04_design_patterns.heroes");
        Set<Class<? extends Hero>> classes = scanner.getSubTypesOf(Hero.class);
        heroes = classes.stream()
                .filter(c -> Modifier.isAbstract(c.getModifiers())).collect(Collectors.toList());
    }

    @SneakyThrows
    public Hero createHero(){
        int ind = RandomUtils.getRandomInRange(0, heroes.size());
       return heroes.get(ind).getDeclaredConstructor().newInstance();
    }
}
