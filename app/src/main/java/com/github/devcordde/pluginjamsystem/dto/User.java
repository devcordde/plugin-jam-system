package com.github.devcordde.pluginjamsystem.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    private long id;
    private String username;
    private String avatar;
    private String discriminator;
    private GuildProfile currentGuild;
    private List<GuildProfile> guilds;

    @JsonCreator
    public User(@JsonProperty("id") long id, @JsonProperty("username") String username, @JsonProperty("discriminator") String discriminator, @JsonProperty("avatar") String avatar) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.discriminator = discriminator;
    }

    public User() {
    }

    @JsonProperty("handle")
    public String handle() {
        return String.format("%s#%s", username, discriminator);
    }

    @JsonProperty("username")
    public String username() {
        return username;
    }

    @JsonProperty("avatar_url")
    public String avatarUrl() {
        var file = avatar.startsWith("a_") ? "gif" : "png";
        return String.format("https://cdn.discordapp.com/avatars/%s/%s.%s", id, avatar, file);
    }

    @JsonProperty("current_guild")
    public GuildProfile currentGuild() {
        return currentGuild;
    }

    public void currentGuild(GuildProfile currentGuild) {
        this.currentGuild = currentGuild;
    }

    @JsonProperty("guilds")
    public List<GuildProfile> guilds() {
        return guilds;
    }

    public void guilds(List<GuildProfile> guilds) {
        this.guilds = guilds;
    }

    public long id() {
        return id;
    }

    public String avatar() {
        return avatar;
    }

    public String discriminator() {
        return discriminator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
