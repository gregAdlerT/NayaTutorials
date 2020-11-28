package lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton;

import lesson04design_patterns.heroes.RandomUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author Greg Adler
 */
@Component
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;
    public ColorFrame(){
        setSize(200,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    @SneakyThrows
    public void moveToRandomLocation(){
        int x = RandomUtils.getRandomInRange(0, 800);
        int y = RandomUtils.getRandomInRange(0, 800);
        setLocation(x,y);
        getContentPane().setBackground(color);
        Thread.sleep(100);
        repaint();
    }
    
}
