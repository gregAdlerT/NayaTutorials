package lesson08aspect.more_aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Greg Adler
 */
@Service
public class SomeService {
    @Autowired
    private SomeDao dao;
    public void work(){
        System.out.println(" Working.........");
        dao.saveData();
    }
}
