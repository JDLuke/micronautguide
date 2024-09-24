package acceptance;

import lombok.extern.slf4j.Slf4j;

import io.cucumber.core.backend.ObjectFactory;
import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;

/**
 * Will start an {@link EmbeddedServer} at the start then stop it at the end of <strong>each</strong> Scenario<br>
 * Will also use the {@link ApplicationContext} to resolve Glue beans
 */
@Slf4j
public final class MicronautObjectFactory implements ObjectFactory {

    private EmbeddedServer embeddedServer;

    @Override
    public void start() {
        embeddedServer = ApplicationContext.run(EmbeddedServer.class, "test", "cucumber");
    }

    @Override
    public void stop() {
        if (embeddedServer != null) {
            embeddedServer.stop();
        }
    }

    @Override
    public <T> T getInstance(final Class<T> beanType) {
        return embeddedServer.getApplicationContext().getBean(beanType);
    }

    @Override
    public boolean addClass(final Class<?> aClass) {
        return true;
    }

}