package org.example.repo.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;

public class MavenRepoServer {
    public static void main(String... args) throws Exception {
        Server server = new Server(8080);

	ResourceHandler handler = new ResourceHandler();
	handler.setDirectoriesListed(true);
	handler.setResourceBase("../../maven-repo");


	GzipHandler gzip = new GzipHandler();
	server.setHandler(gzip);
        HandlerList handlers = new HandlerList();
	handlers.setHandlers(new Handler[] {handler, new DefaultHandler()});
	gzip.setHandler(handlers);

        server.start();
        // server.join();
    }
}
