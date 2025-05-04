package ru.mtuci.BVT_demo1;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ThreatSignatureRepository repository;

    public DataInitializer(ThreatSignatureRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (repository.count() == 0) {
            ThreatSignature eicar = new ThreatSignature();
            eicar.setId(UUID.randomUUID());
            eicar.setName("EICAR-Test");
            eicar.setPattern("X5O!P%@AP[4\\PZX54(P^)7CC)7}$EICAR");
            repository.save(eicar);
        }
    }
}