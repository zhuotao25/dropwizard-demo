import com.codahale.metrics.health.HealthCheck;

public class TestHealthCheck extends HealthCheck {
    private final String template;

    public TestHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() {
        final String name = "TEST";
        final String saying = String.format(template, name);
        if (!saying.contains(name)) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}