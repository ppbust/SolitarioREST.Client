package upm.miw.solitaire.controllers.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import upm.miw.solitaire.models.entities.Gender;
import upm.miw.solitaire.models.entities.User;

public class LoginResourceClient {
    private String uri = "http://localhost:8080/Solitario.JSF.REST.Server/rest/user";

    public User login(String nick, String password) {
        Client client = Client.create(new DefaultClientConfig());
        client.addFilter(new HTTPBasicAuthFilter(nick, password));

        WebResource wr = client.resource(UriBuilder.fromUri(uri).build());
        wr = wr.path(nick); // para añadir path

        Builder response = wr.accept(MediaType.APPLICATION_JSON);
        Logger.getLogger(LoginResourceClient.class).info(
                "GET/" + response.head().getStatus() + "/" + response.get(User.class));
        return response.get(User.class);
    }

    /**
     * @param usuario
     * @return true si se puede crear el usuario, false si el nick está ocupado
     */
    public boolean register(User usuario) {
        Client client = Client.create(new DefaultClientConfig());
        WebResource wr = client.resource(UriBuilder.fromUri(uri).build());
        ClientResponse response = wr.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,
                usuario);
        Logger.getLogger(LoginResourceClient.class).info("POST/" + response.getStatus());
        return response.getStatus() == 201;
    }

    public static void main(String[] args) {
        LoginResourceClient lrc = new LoginResourceClient();
        User u = new User("u44", "22222222", "u22", "u22", 18, Gender.FEMALE, "u22");
        lrc.login("user", "uuuuuuuu");
        lrc.register(u);

    }
}
