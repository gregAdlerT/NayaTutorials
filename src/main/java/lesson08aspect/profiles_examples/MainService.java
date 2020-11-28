package lesson08aspect.profiles_examples;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Greg Adler
 */
@Service
@RequiredArgsConstructor
public class MainService {
    @Autowired
    private Repo repo;
    @Scheduled(fixedDelay = 1000)
    public void work(){
        repo.crud();
    }
}
