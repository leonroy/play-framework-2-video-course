package controllers;

import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by leon on 06/04/2016.
 */
public class Application extends Controller {

    public Result index() {
        return redirect(routes.Agenda.list());
    }

    @Inject
    private WSClient wsClient;

    /**
     * Code below from video tutorial but doesn't work at all with Play 2.5 and Twitter has also closed their unauthenticated API.
     * See {@link Twitter} instead for an implementation cribbed from official Play Framework docs.
     */
//    public static Result externalWs() {
//        return async(WS.url("http://search.twitter.com/search.json").setQueryParameter("q", "mgonto").get().map(new Function<WS.Response, Result>() {
//
//            @Override
//            public Result apply(Http.Response response) throws Throwable {
//                return ok(response.asJson().findPath("max_id"));
//            }
//        }));
//    }
}
