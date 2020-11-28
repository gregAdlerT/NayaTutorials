package lesson07beanFactory_qualifier_profile_aspect.qualifier.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Greg Adler
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonEntity {
    private long id;
    private String firstName;
    private String secondName;
}
