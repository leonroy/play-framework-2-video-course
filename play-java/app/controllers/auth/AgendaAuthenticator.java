package controllers.auth;

import play.mvc.Http;
import play.mvc.Security;

/**
 * Created by leon on 05/04/2016.
 */
public class AgendaAuthenticator extends Security.Authenticator {

    private final String username = "leon";
    private final String password = "PaSSw0rd";

    @Override
    public String getUsername(Http.Context ctx) {
        BasicAuthHelper.BasicAuthUser user = BasicAuthHelper.auth(ctx);
        if (user == null) {
            return null;
        }
        if (user.name.equals(username) && user.password.equals(password)) {
            return user.name;
        } else {
            return null;
        }
    }

}

