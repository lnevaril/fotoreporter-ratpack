package cz.sw.upis.fotoreporter;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import ratpack.registry.Registry;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

public class FotoreporterServer {

	private final Morphia morphia = new Morphia();
	private final Datastore datastore = morphia.createDatastore(new MongoClient("localhost", 27017), "fotoreporter");

	public static void main(String[] args) throws Exception {
		new FotoreporterServer().startServer();
	}

	public void startServer() throws Exception {
		RatpackServer.start(server -> server
				.serverConfig(ServerConfig.embedded().port(3000))
				.registry(Registry.single(Morphia.class, morphia))
				.registry(Registry.single(Datastore.class, datastore))
				.handlers(chain -> chain
						.path("create", new CreateReportHandler())
				)
		);
	}

}
