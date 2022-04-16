package com.github.devcordde.pluginjamsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {
    @JsonProperty("handle")
    private String handle;
    @JsonProperty("name")
    private String name;
    @JsonProperty("avatar_url")
    private String avatarUrl;

    public User(
            String handle,
            String name,
            String avatarUrl
    ) {
        this.handle = handle;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public User() {
    }

    public void handle(String discordHandle) {
        this.handle = discordHandle;
    }

    public void name(String name) {
        this.name = name;
    }

    public void avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String handle() {
        return handle;
    }

    public String name() {
        return name;
    }

    public String avatarUrl() {
        return avatarUrl;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (User) obj;
        return Objects.equals(this.handle, that.handle) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.avatarUrl, that.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handle, name, avatarUrl);
    }

    @Override
    public String toString() {
        return "User[" +
                "discordHandle=" + handle + ", " +
                "name=" + name + ", " +
                "avatarUrl=" + avatarUrl + ']';
    }

}
