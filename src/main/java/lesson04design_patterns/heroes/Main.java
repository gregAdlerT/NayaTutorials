package lesson04design_patterns.heroes;

/**
 * @author Greg Adler
 */
public class Main {
    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactory();
        GameManager gameManager = new GameManager();
        Hero hero = heroFactory.createHero();
        Hero hero1 = heroFactory.createHero();
        gameManager.fight(hero,hero1);
    }
}
