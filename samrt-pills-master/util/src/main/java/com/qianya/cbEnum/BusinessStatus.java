package com.qianya.cbEnum;

public enum BusinessStatus {
    SUCCESS(1, "SUCCESS"),
    FAIL(0, "FAIL");

    private final int value;
    private final String reasonPhrase;

    private BusinessStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }
}