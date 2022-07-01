package dev.megashopper.common.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Password {
    @Column(name = "password_hash", nullable = false, unique = true)
    private byte[] hash;
    @Column(name = "password_salt", nullable = false, unique = true)
    private byte[] salt;

    public Password() {
    }

    public Password(byte[] hash, byte[] salt) {
        this.hash = hash;
        this.salt = salt;
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
