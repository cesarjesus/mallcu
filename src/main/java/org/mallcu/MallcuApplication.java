package org.mallcu;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.mallcu.resources.ClassResource;
import org.mallcu.resources.StudentResource;

public class MallcuApplication extends Application<MallcuConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MallcuApplication().run(args);
    }

    @Override
    public String getName() {
        return "Mallcu";
    }

    @Override
    public void initialize(final Bootstrap<MallcuConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MallcuConfiguration configuration,
                    final Environment environment) {
        StudentResource studentResource = new StudentResource();
        environment.jersey().register(studentResource);
        
        ClassResource classResource = new ClassResource();
        environment.jersey().register(classResource);
    }

}
