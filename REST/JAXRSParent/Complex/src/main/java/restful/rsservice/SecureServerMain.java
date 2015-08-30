package restful.rsservice;

import java.io.IOException;
import java.net.URI;
import java.security.AccessController;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.util.PropertiesHelper;
import org.glassfish.jersey.server.ResourceConfig;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.ssl.SSLContextConfigurator;
import org.glassfish.grizzly.ssl.SSLEngineConfigurator;

/**
 * @author Pavel Bucek (pavel.bucek at oracle.com)
 */
public class SecureServerMain {

    private static final String KEYSTORE_SERVER_FILE = "./keystore_server";
    private static final String KEYSTORE_SERVER_PWD = "asdfgh";
    private static final String TRUSTORE_SERVER_FILE = "./truststore_server";
    private static final String TRUSTORE_SERVER_PWD = "asdfgh";
    private static HttpServer webServer;

    public static final URI BASE_URI = getBaseURI();
    public static final String CONTENT = "JERSEY HTTPS EXAMPLE\n";

    private static URI getBaseURI() {
        return UriBuilder.fromUri("https://localhost/").port(getPort(4463)).build();
    }

    private static int getPort(int defaultPort) {
        final String port
                = AccessController.doPrivileged(PropertiesHelper.getSystemProperty("jersey.config.test.container.port"));
        if (null != port) {
            try {
                return Integer.parseInt(port);
            } catch (NumberFormatException e) {
                System.out.println("Value of jersey.config.test.container.port property"
                        + " is not a valid positive integer [" + port + "]."
                        + " Reverting to default [" + defaultPort + "].");
            }
        }
        return defaultPort;
    }

    protected static void startServer() {

        // Grizzly ssl configuration
        SSLContextConfigurator sslContext = new SSLContextConfigurator();

        // set up security context
        sslContext.setKeyStoreFile(KEYSTORE_SERVER_FILE); // contains server keypair
        sslContext.setKeyStorePass(KEYSTORE_SERVER_PWD);
        sslContext.setTrustStoreFile(TRUSTORE_SERVER_FILE); // contains client certificate
        sslContext.setTrustStorePass(TRUSTORE_SERVER_PWD);

        ResourceConfig rc = new ResourceConfig();
        rc.registerClasses(MyResource.class, SecurityFilter.class, AuthenticationExceptionMapper.class);

        try {
            webServer = GrizzlyHttpServerFactory.createHttpServer(
                    getBaseURI(),
                    rc,
                    true,
                    new SSLEngineConfigurator(sslContext).setClientMode(false).setNeedClientAuth(false)
            );

            // start Grizzly embedded server //
            System.out.println("Jersey app started. Try out " + BASE_URI + "\nHit CTRL + C to stop it...");
            webServer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    protected static void stopServer() {
        webServer.shutdownNow();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws InterruptedException, IOException {
        startServer();

        System.in.read();
    }
}
