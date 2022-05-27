package com.sbuslab.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


public class SecureStringDeserializer extends StdDeserializer<SecureString> {
    public SecureStringDeserializer() {
        super(SecureString.class);
    }

    public SecureStringDeserializer(Class<?> c) {
        super(c);
    }

    public SecureString deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        if (jsonParser.currentToken().isStructStart()) {
            throw new IllegalArgumentException("Incorrect value for SecureString deserialization! Current value type is: " + jsonParser.currentToken());
        }

        return SecureString.fromString(jsonParser.getText());
    }
}
