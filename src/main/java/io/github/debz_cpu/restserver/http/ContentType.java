package io.github.debz_cpu.restserver.http;

public enum ContentType {
    HTML("text/html"),
    PLAIN_TEXT("text/plain"),
    JSON("application/json");

    private final String type;

    ContentType(String type){
        this.type = type;
    }
    public String getType(){ return type;}

}
