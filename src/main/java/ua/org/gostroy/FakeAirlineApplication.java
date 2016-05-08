package ua.org.gostroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import ua.org.gostroy.service.populator.FlightPopulator;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FakeAirlineApplication extends SpringBootServletInitializer {

    private static FlightPopulator flightPopulator;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        SpringApplicationBuilder springApplicationBuilder = builder.sources(FakeAirlineApplication.class);
        return springApplicationBuilder;
    }

    public static void main(String[] args) {
        SpringApplication.run(FakeAirlineApplication.class, args);
    }

    @PostConstruct
    public void afterStartup() {
        flightPopulator.populateDb();
    }

    @Autowired
    public void setFlightPopulator(FlightPopulator flightPopulator) {
        FakeAirlineApplication.flightPopulator = flightPopulator;
    }
}
