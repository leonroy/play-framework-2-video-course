package controllers;

import play.api.libs.concurrent.Promise;
import play.http.HttpErrorHandler;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by leon on 05/04/2016.
 */
public class NotFoundError implements HttpErrorHandler {

    @Override
    public CompletionStage<Result> onClientError(Http.RequestHeader request, int statusCode, String message) {
        if (statusCode == play.mvc.Http.Status.NOT_FOUND) {
            return CompletableFuture.completedFuture(Results.status(statusCode, views.html.notFound.render()));
        }
        return null;
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        return null;
    }
}
