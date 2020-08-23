package com.dropwizard.gameauth;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GameAuthApplication extends Application<GameAuthConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GameAuthApplication().run(args);
    }

    @Override
    public String getName() {
        return "GameAuth";
    }

    @Override
    public void initialize(final Bootstrap<GameAuthConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GameAuthConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
