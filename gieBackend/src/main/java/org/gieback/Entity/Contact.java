package org.gieback.Entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Personne.class, name = "personne"),
        @JsonSubTypes.Type(value = Entreprise.class, name = "entreprise")
})
@JsonIgnoreProperties(ignoreUnknown = true)

public class Contact implements Serializable{

    public Contact(String phone, String email, Adresse adresse) {
        this.phone = phone;
        this.email = email;
        this.adresse = adresse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name = "phone")
    private String phone;

    @Column(name = "email")

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @Override
    public String toString() {
        return this.getAdresse().getAdresse_id()+"";
    }

    public Contact() {

    }


}