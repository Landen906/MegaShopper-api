package dev.megashopper.common.entities;

public class Password {
    private byte[] hash;
    private byte[] salt;

    public Password(byte[] hash, byte[] salt) {
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
