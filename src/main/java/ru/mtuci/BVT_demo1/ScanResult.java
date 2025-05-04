package ru.mtuci.BVT_demo1;

import java.util.UUID;

public class ScanResult {
    private UUID signatureId;
    private String threatName;
    private int offsetFromStart;
    private int offsetFromEnd;
    private boolean matched;

    // Конструктор, геттеры и сеттеры
    public ScanResult(UUID signatureId, String threatName, int offsetFromStart, int offsetFromEnd, boolean matched) {
        this.signatureId = signatureId;
        this.threatName = threatName;
        this.offsetFromStart = offsetFromStart;
        this.offsetFromEnd = offsetFromEnd;
        this.matched = matched;
    }

    // Геттеры...
}
