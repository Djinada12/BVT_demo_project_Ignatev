package ru.mtuci.BVT_demo1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ThreatSignatureRepository extends JpaRepository<ThreatSignature, UUID> {
}