package models;


import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by leon on 03/04/2016.
 */
@Entity
public class Contact extends Model {

    @Id
    @GeneratedValue
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String phone;

    @Constraints.Required
    @Constraints.Email
    public String email;

    public static Finder<Long, Contact> find = new Finder<>(Contact.class);

}
