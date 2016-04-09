package views;


import models.Contact;
import org.junit.Before;
import org.junit.Test;
import play.twirl.api.Html;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.contentAsString;

public class ListTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("ListTest");
    }

    @Test
    public void templateTest() {
        List<Contact> contacts = new ArrayList<Contact>();

        Contact contact = new Contact();
        contact.name = "Test User";
        contact.email = "testy@example.com";
        contact.phone = "12345";
        contacts.add(contact);

        Html content = views.html.list.render(contacts);

        assertThat(contentAsString(content), containsString("<html lang=\"en\">"));
        assertThat(contentAsString(content), containsString(contact.name));
        assertThat(contentAsString(content), containsString(contact.name));
        assertThat(contentAsString(content), containsString("Create new contact"));
    }
}
