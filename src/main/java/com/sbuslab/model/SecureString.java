package com.sbuslab.model;

import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode
@JsonDeserialize(using = SecureStringDeserializer.class)
public class SecureString {

    private static final Base64.Decoder b64Decoder = Base64.getUrlDecoder();
    private static final Base64.Encoder b64Encoder = Base64.getUrlEncoder().withoutPadding();

    private final String value;

    public SecureString(final String original) {
        this.value = original;
    }

    public SecureString(final byte[] original) {
        this.value = new String(original);
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

    @JsonValue
    @Override
    public String toString() {
        return "secret:::" + b64Encoder.encodeToString(this.value.getBytes());
    }
}
