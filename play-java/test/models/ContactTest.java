package models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static play.test.Helpers.*;

/**
 * Created by leon on 04/04/2016.
 */
public class ContactTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("ContactTest");
    }

    @Test
    public void testContactModel() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                String name = "User";
                String email = "user@example.com";
                String phone = "12345";
                Contact contact = new Contact();
                contact.name = name;
                contact.email = email;
                contact.phone = phone;

                contact.save();

                System.out.println("ContactTest");

                Contact savedContact = Contact.find.byId(contact.id);
                assertThat(savedContact, is(notNullValue()));
                assertThat(savedContact.name, equalTo(name));
                assertThat(savedContact.email, equalTo(email));
                assertThat(savedContact.phone, equalTo(phone));
            }
        });
    }

}