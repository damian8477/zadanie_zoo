package com.example.zoo.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "animals")
@AllArgsConstructor
@NoArgsConstructor
public class Animals{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String name;
    private double foodDemand;
    private int zoneId;

    public static boolean isNull(Object obj) {
        return obj == null;
    }

}
