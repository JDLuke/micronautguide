package example.micronaut;

import io.micronaut.runtime.Micronaut;

public final class Application {

    /**
     * Entry point if running a Micronaut application.
     *
     * @param args - ignored right now except for any
     *             default handling Micronaut may impose
     */
    public static void main(final String[] args) {
        Micronaut.run(Application.class, args);
    }

    private Application() { }
}

