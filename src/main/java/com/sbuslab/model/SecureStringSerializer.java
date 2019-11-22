package com.sbuslab.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


public class SecureStringSerializer extends StdSerializer<SecureString> {

    public SecureStringSerializer() {
        this(null);
    }

    public SecureStringSerializer(Class<SecureString> t) {
        super(t);
    }

    @Override
    public void serialize(SecureString value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(value.original());
    }
}
