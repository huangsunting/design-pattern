package com.bravo.pattern.builder.stepbuilder.demo.httprequest;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HttpRequest {

    public enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }

    // 请求内容，由Builder构建
    private final String url;
    private final HttpMethod method;
    private final Map<String, String> headers;
    private final Map<String, String> parameters;
    private final Map<String, String> body;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers;
        this.parameters = builder.parameters;
        this.body = builder.body;
    }

    public static UrlStep builder() {
        return new Builder();
    }

    // ------ 接口：保证构建顺序 ------
    public interface UrlStep {
        MethodStep withUrl(String url);
    }

    public interface MethodStep {
        HeadersStep withMethod(HttpMethod method);
    }

    public interface HeadersStep {
        ParametersStep withHeader(String key, String value);

        HttpRequest build();
    }

    public interface ParametersStep {
        ParametersStep withParameter(String key, String value);

        BodyStep withBody(String key, String value);

        HttpRequest build();
    }

    public interface BodyStep {
        BodyStep withBody(String key, String value);

        HttpRequest build();
    }

    // ------ Builder：构建请求 ------
    private static class Builder implements UrlStep, MethodStep, HeadersStep, ParametersStep, BodyStep {

        private String url;
        private HttpMethod method;
        private final Map<String, String> headers;
        private final Map<String, String> parameters;
        private final Map<String, String> body;

        private Builder() {
            this.headers = new HashMap<>();
            this.parameters = new HashMap<>();
            this.body = new HashMap<>();
        }

        @Override
        public MethodStep withUrl(String url) {
            this.url = url;
            return this;
        }

        @Override
        public HeadersStep withMethod(HttpMethod method) {
            this.method = method;
            return this;
        }

        @Override
        public ParametersStep withHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        @Override
        public ParametersStep withParameter(String key, String value) {
            this.parameters.put(key, value);
            return this;
        }

        @Override
        public BodyStep withBody(String key, String value) {
            this.body.put(key, value);
            return this;
        }

        @Override
        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}