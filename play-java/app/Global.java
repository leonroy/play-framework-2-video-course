import play.GlobalSettings;
import play.http.HttpErrorHandler;

public class Global extends GlobalSettings {

    /**
     * One way of creating a 404 error handler. A better way is to create a {@link HttpErrorHandler}
     */
//    @Override
//    public CompletionStage<Result> onHandlerNotFound(Http.RequestHeader request) {
//            return CompletableFuture.completedFuture(Results.notFound(views.html.notFound.render()));
//    }

}
