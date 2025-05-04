package ru.mtuci.BVT_demo1;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/scan")
public class ScanController {

    private final RabinKarpScanner scanner;
    private final ThreatSignatureRepository signatureRepository;

    public ScanController(RabinKarpScanner scanner, ThreatSignatureRepository signatureRepository) {
        this.scanner = scanner;
        this.signatureRepository = signatureRepository;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<List<ScanResult>> scanFile(@RequestParam("file") MultipartFile file) throws IOException {
        List<ThreatSignature> signatures = signatureRepository.findAll();
        byte[] content = file.getBytes();

        List<ScanResult> results = scanner.scanFile(content, signatures);

        return ResponseEntity.ok(results);
    }
}