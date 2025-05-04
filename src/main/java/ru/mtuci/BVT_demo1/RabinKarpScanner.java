package ru.mtuci.BVT_demo1;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class RabinKarpScanner {

    private static final int PRIME = 101;

    public List<ScanResult> scanFile(byte[] content, List<ThreatSignature> signatures) {
        List<ScanResult> results = new ArrayList<>();

        for (ThreatSignature signature : signatures) {
            byte[] pattern = signature.getPattern().getBytes(StandardCharsets.UTF_8);
            int patternHash = calculateHash(pattern, pattern.length);
            int contentHash = calculateHash(content, pattern.length);

            for (int i = 0; i <= content.length - pattern.length; i++) {
                if (contentHash == patternHash && checkEquals(content, pattern, i)) {
                    results.add(new ScanResult(
                            signature.getId(),
                            signature.getName(),
                            i,
                            i + pattern.length - 1,
                            true
                    ));
                    break;
                }

                if (i < content.length - pattern.length) {
                    contentHash = recalculateHash(contentHash, content[i],
                            content[i + pattern.length], pattern.length);
                }
            }
        }

        return results;
    }

    private int calculateHash(byte[] str, int length) {
        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str[i] * Math.pow(PRIME, i);
        }
        return hash;
    }

    private int recalculateHash(int oldHash, byte oldChar, byte newChar, int patternLength) {
        return (oldHash - oldChar) / PRIME + (int)(newChar * Math.pow(PRIME, patternLength - 1));
    }

    private boolean checkEquals(byte[] content, byte[] pattern, int start) {
        for (int i = 0; i < pattern.length; i++) {
            if (content[start + i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}