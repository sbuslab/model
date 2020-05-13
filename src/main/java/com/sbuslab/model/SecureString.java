package com.sbuslab.model;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode
@JsonDeserialize(using = SecureStringDeserializer.class)
public class SecureString implements CharSequence {

    private static final Base64.Decoder b64Decoder = Base64.getUrlDecoder();
    private static final Base64.Encoder b64Encoder = Base64.getUrlEncoder();

    private final String value;
    private final String encodedValue;

    public SecureString(final String original) {
        this.value = original;
        this.encodedValue = "secret:::" + b64Encoder.encodeToString(this.value.getBytes());
    }

    public SecureString(final byte[] original) {
        this(new String(original));
    }

    @JsonCreator
    public static SecureString fromString(final String value) {
        if (value == null) return null;

        if (value.startsWith("secret:::")) {
            return new SecureString(b64Decoder.decode(value.substring(9)));
        }

        return new SecureString(value);
    }

    public String original() {
        return this.value;
    }

    @Override
    public int length() {
        return this.encodedValue.length();
    }

    @Override
    public char charAt(int index) {
        return this.encodedValue.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.encodedValue.subSequence(start, end);
    }

    @JsonValue
    @Override
    public String toString() {
        return this.encodedValue;
    }
}
