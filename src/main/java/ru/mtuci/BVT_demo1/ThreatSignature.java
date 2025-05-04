package ru.mtuci.BVT_demo1;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "threat_signatures")
public class ThreatSignature {
    @Id
    @GeneratedValue
    private UUID id;
    @Version
    private Long version;

    private String name;
    private String pattern;

    // Геттеры и сеттеры
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}