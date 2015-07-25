package httpsclientservergrizzly;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import static org.glassfish.jersey.client.authentication.HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_PASSWORD;
import static org.glassfish.jersey.client.authentication.HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_USERNAME;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private static final String TRUSTORE_CLIENT_FILE = "./truststore_client";
    private static final String TRUSTSTORE_CLIENT_PWD = "asdfgh";
    private static final String KEYSTORE_CLIENT_FILE = "./keystore_client";
    private static final String KEYSTORE_CLIENT_PWD = "asdfgh";

    private final Object serverGuard = new Object();
    private Server server = null;
    private SSLContext sslContext;

    @Before
    public void setUp() throws Exception {
        synchronized (serverGuard) {
            if (server != null) {
                throw new IllegalStateException(
                        "Test run sync issue: Another instance of the SSL-secured HTTP test server has been already started.");
            }
            server = Server.start();
        }
        SslConfigurator sslConfig = SslConfigurator.newInstance()
                .trustStoreFile(TRUSTORE_CLIENT_FILE)
                .trustStorePassword(TRUSTSTORE_CLIENT_PWD)
                .keyStoreFile(KEYSTORE_CLIENT_FILE)
                .keyPassword(KEYSTORE_CLIENT_PWD);
        sslContext = sslConfig.createSSLContext();
    }

    @After
    public void tearDown() throws Exception {
        synchronized (serverGuard) {
            if (server == null) {
                throw new IllegalStateException("Test run sync issue: There is no SSL-secured HTTP test server to stop.");
            }
            server.stop();
            server = null;
        }
    }

    @Test
    public void testWithBasicAndSSLAuth2() {
        Client client = ClientBuilder.newBuilder()
                .sslContext(sslContext).build();
        client.register(HttpAuthenticationFeature.basic("", ""));
        System.out.println("Client: GET " + Server.BASE_URI);
        WebTarget target = client.target(Server.BASE_URI);
        final Response response = target.path("/").request()
                .property(HTTP_AUTHENTICATION_BASIC_USERNAME, "user")
                .property(HTTP_AUTHENTICATION_BASIC_PASSWORD,
                        "password")
                .get(Response.class);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testWithBasicAndSSLAuth() {//ClientConfig clientConfig) {
        Client client = ClientBuilder.newBuilder()
                .sslContext(sslContext).build();
        // client basic auth demonstration
        client.register(HttpAuthenticationFeature.basic("user", "password"));
        System.out.println("Client: GET " + Server.BASE_URI);
        WebTarget target = client.target(Server.BASE_URI);
        final Response response = target.path("/").request().get(Response.class);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testWithoutBasicAuth() {
        Client client = ClientBuilder.newBuilder()
                .sslContext(sslContext).build();
        System.out.println("Client: GET " + Server.BASE_URI);
        WebTarget target = client.target(Server.BASE_URI);
        target.register(new LoggingFilter());
        Response response = target.path("/").request().get(Response.class);
        assertEquals(401, response.getStatus());

    }

    @Test(expected = javax.ws.rs.ProcessingException.class)
    public void testWithoutSSLAuthentication() {
        Client client = ClientBuilder.newBuilder().build();
        client.register(HttpAuthenticationFeature.basic("user", "password"));
        System.out.println("Client: GET " + Server.BASE_URI);
        WebTarget target = client.target(Server.BASE_URI);
        target.register(new LoggingFilter());
        target.path("/").request().get(String.class);

    }

}
