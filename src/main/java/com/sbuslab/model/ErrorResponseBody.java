package com.sbuslab.model;

import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ErrorResponseBody {

    private final String message;

    private final String error;

    @JsonProperty("_links")
    private final Map<String, Object> links;

    @JsonProperty("_embedded")
    private final Map<String, Object> embedded;

    @java.beans.ConstructorProperties({"message", "error", "links", "embedded"})
    public ErrorResponseBody(String message, String error, Map<String, Object> links, Map<String, Object> embedded) {
        this.message = message;
        this.error = error;
        this.links = links;
        this.embedded = embedded;
    }

    public String getMessage() {
        return this.message;
    }

    public String getError() {
        return this.error;
    }

    public Map<String, Object> getLinks() {
        return this.links;
    }

    public Map<String, Object> getEmbedded() {
        return this.embedded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorResponseBody that = (ErrorResponseBody) o;
        return Objects.equals(message, that.message) &&
                Objects.equals(error, that.error) &&
                Objects.equals(links, that.links) &&
                Objects.equals(embedded, that.embedded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, error, links, embedded);
    }

    public String toString() {
        return "ErrorResponseBody(message=" + this.getMessage() +
                ", error=" + this.getError() +
                ", links=" + this.getLinks() +
                ", embedded=" + this.getLinks() + ")";
    }
}
