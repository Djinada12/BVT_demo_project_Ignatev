import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "threat_signatures")
public class ThreatSignature {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private Integer version; // Измените на Integer и инициализируйте

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String pattern;

    // Конструктор
    public ThreatSignature() {
        this.version = 0; // Инициализация версии
    }

    // Геттеры и сеттеры
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
}