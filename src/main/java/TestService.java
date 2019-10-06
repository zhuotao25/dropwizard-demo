import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestService extends Application<TestServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new TestService().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<TestServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TestServiceConfiguration configuration,
                    Environment environment) {
        final TestResource resource = new TestResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TestHealthCheck healthCheck = new TestHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("test", healthCheck);
        environment.jersey().register(resource);
    }
}
