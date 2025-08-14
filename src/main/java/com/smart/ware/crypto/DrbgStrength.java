package com.smart.ware.crypto;

public enum DrbgStrength {
    S128(128), S192(192), S256(256);
    private final int bits;

    DrbgStrength(int bits) {
        this.bits = bits;
    }

    public int getBits() {
        return bits;
    }
}
