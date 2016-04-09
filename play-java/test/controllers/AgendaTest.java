package controllers;

import models.Contact;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.mvc.Result;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.*;

/**
 * Created by leon on 04/04/2016.
 */
public class AgendaTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("AgendaTest");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                Contact contact = new Contact();
                contact.name = "User";
                contact.email = "user@example.com";
                contact.phone = "12345";
                contact.save();

                Result result = route(routes.Agenda.list());
                // OR
                result = new Agenda().list();

                assertThat(result.status(), equalTo(OK));
                assertThat(result.contentType().get(), equalTo("text/html"));

                assertThat(contentAsString(result), containsString(contact.name));
                assertThat(contentAsString(result), containsString(contact.email));
                assertThat(contentAsString(result), containsString(contact.phone));

            }
        });
    }

    @Test
    public void show() throws Exception {

    }

    @Test
    public void newContact() throws Exception {

    }

    @Test
    public void createContact() throws Exception {

    }

    @Test
    public void testNewContactRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/contacts/new"), 0);
        assertThat(result.status(), equalTo(OK));
    }

    @Test
    public void testInvalidRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/foo/bar"), 0);
        assertThat(result, nullValue());
    }

}