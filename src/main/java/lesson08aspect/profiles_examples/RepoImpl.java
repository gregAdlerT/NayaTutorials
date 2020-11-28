package lesson08aspect.profiles_examples;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * @author Greg Adler
 */
@Repository
@Profile(ProfilesConstants.PROD)
public class RepoImpl implements Repo {
    @Override
    public void crud() {
        System.out.println("saved to prod");
    }
}
