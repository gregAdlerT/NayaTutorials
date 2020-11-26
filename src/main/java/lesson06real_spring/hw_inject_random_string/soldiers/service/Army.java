package lesson06real_spring.hw_inject_random_string.soldiers.service;

import lesson06real_spring.hw_inject_random_string.soldiers.Soldier;
import lesson06real_spring.hw_inject_random_string.soldiers.config.GenerateObjects;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Greg Adler
 */
@Data
public class Army {
    @GenerateObjects(clazz = Soldier.class,amount=20)
    private Map<String, List<Soldier>>soldierMap;
    
    public void attack(){
        System.out.println(soldierMap);
        soldierMap.values().stream().forEach(list->list.forEach(soldier -> soldier.fight()));
    }
}
