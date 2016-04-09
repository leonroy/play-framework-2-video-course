package e2e;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.test.TestServer;

import java.util.concurrent.CompletionStage;

import static org.hamcrest.CoreMatchers.containsString;
import static play.test.Helpers.*;


public class AgendaAppTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("AgendaAppTest");
    }

//    @Test
//    public void testNewContactFormPage() {
//        running(testServer(3333), new Runnable() {
//            @Override
//            public void run() {
//                Future<WSResponse> response = client.url("http://localhost:3333/contacts/new").get();
//
//                WS.url("http://localhost:3333/contact/new").get();
//            }
//        });
//    }

    @Test
    public void testNewContactFormPage() {
        TestServer server = testServer(3333);
        running(server, () -> {
            try {
                WSClient ws = play.libs.ws.WS.newClient(3333);
                CompletionStage<WSResponse> completionStage = ws.url("/contacts/new").get();
                WSResponse response = completionStage.toCompletableFuture().get();
                ws.close();
                Assert.assertEquals(OK, response.getStatus());
                Assert.assertThat(response.getBody(), containsString("New contact"));
            } catch (Exception e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
            }
        });
    }

}
