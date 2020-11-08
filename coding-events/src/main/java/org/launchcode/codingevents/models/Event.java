package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    //private static int nextId = 1; Replaced by ID/generatedval annotations for mySql

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3-50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, try again.")
    private String contactEmail;

    private EventType type;
    /* EventType doesn't need validation since is Enum w/set valid values already in eventtype.java*/

    public Event(String name, String description, String contactEmail, EventType type) {
        /*this(); calls different constructor within the same class (line 35)obsolete via ln 15*/
        this.name = name;
        this.description= description;
        this.contactEmail= contactEmail;
        this.type= type;
    }

    public Event() { } //removed nextid++ since annotations handle via mysql

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
