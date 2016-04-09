package controllers;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

/**
 * Created by leon on 05/04/2016.
 */

public class LogRequestAction extends Action<LogRequest> {

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        Logger.info("The request was called " + ctx);
        return delegate.call(ctx);
    }
}
