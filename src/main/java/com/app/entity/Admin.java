package com.app.entity;

import com.app.Utilities.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
public class Admin {


    @Id
    private String id;

    private String name;


    public void generateCustomId(){
        this.id = IdGenerator.generateCustomId();
    }


}
