package lesson07beanFactory_qualifier_profile_aspect.refresh_prototype_in_singleton;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.concurrent.TimeUnit;

/**
 * @author Greg Adler
 */
public class ToSecondsScopeProvider implements Scope {
    private Cache<String,Object> cache=CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS).build();

    @Override
    @SneakyThrows
    public Object get(String s, ObjectFactory<?> objectFactory) {
        return cache.get(s,objectFactory::getObject);
    }

    
    
    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
