package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.auth.AgendaAuthenticator;
import models.Contact;
import play.data.Form;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by leon on 04/04/2016.
 */
@LogRequest // every action
@Security.Authenticated(AgendaAuthenticator.class)
public class Agenda extends Controller {

    @Inject
    public WebJarAssets webJarAssets;

    @LogRequest // just this action
    public Result list() {
        List<Contact> contacts = Contact.find.all();
        return ok(views.html.list.render(contacts));
    }

    public Result show(Long id) {
        Contact contact = Contact.find.byId(id);
        if (contact == null) {
            return notFound();
        } else {
            return ok(views.html.show.render(contact));
        }
    }

    public Result newContact() {
        Form<Contact> contactForm = Form.form(Contact.class);
        return ok(views.html.newContact.render(contactForm));
    }

    public Result createContact() {
        Form<Contact> contactForm = Form.form(Contact.class).bindFromRequest();
        if (contactForm.hasErrors()) {
            return badRequest(views.html.newContact.render(contactForm));
        }
        Contact contact = contactForm.get();
        contact.save();
        return redirect(routes.Agenda.list());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result createContactJson() {
        JsonNode json = request().body().asJson();
        ObjectNode result = play.libs.Json.newObject();

        String name = json.findPath("name").textValue();
        String phone = json.findPath("phone").textValue();
        String email = json.findPath("email").textValue();
        if (name == null || phone == null || email == null) {
            result.put("status", "fail");
            return badRequest(result);
        } else {
            Contact contact = new Contact();
            contact.name = name;
            contact.phone = phone;
            contact.email = email;
            contact.save();
            result.put("status", "ok");

            return ok(result);
        }
    }


}
