package profiles_examples;

import lesson07beanFactory_qualifier_profile_aspect.profiles_examples.Confi;
import lesson07beanFactory_qualifier_profile_aspect.profiles_examples.MainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Greg Adler
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Confi.class)
@ActiveProfiles("dev")
public class MainServiceTest {
    @Autowired
    MainService service;

    @Test
    public void work() {
        service.work();
    }
}
