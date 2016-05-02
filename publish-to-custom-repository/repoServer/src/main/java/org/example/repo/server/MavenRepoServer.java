package org.example.repo.server;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Credential;

public class MavenRepoServer {
    public static void main(String... args) throws Exception {
        Server server = new Server(8080);

        ResourceHandler resources = new ResourceHandler();
        resources.setDirectoriesListed(true);
        resources.setResourceBase("../../maven-repo");

        SecurityHandler securityHandler = getSecurityHandler();
        securityHandler.setHandler(resources);

        server.setHandler(securityHandler);

        server.start();
        server.join();
    }

    private static SecurityHandler getSecurityHandler() {
        HashLoginService login = new HashLoginService();
        login.putUser("admin", Credential.getCredential("admin"), new String[] {"user"});

        Constraint constraint = new Constraint();
        constraint.setName(Constraint.__BASIC_AUTH);
        constraint.setRoles(new String[]{"user"});
        constraint.setAuthenticate(true);

        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setConstraint(constraint);
        constraintMapping.setPathSpec("/*");

        ConstraintSecurityHandler securityHandler = new ConstraintSecurityHandler();
        securityHandler.setAuthenticator(new BasicAuthenticator());
        securityHandler.setRealmName("realm");
        securityHandler.addConstraintMapping(constraintMapping);
        securityHandler.setLoginService(login);
        return securityHandler;
    }
}
