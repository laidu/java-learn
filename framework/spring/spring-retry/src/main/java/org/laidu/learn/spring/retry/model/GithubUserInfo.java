
package org.laidu.learn.spring.retry.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
@Data
public class GithubUserInfo {

    @SerializedName("avatar_url")
    private String avatarUrl;
    @Expose
    private Object bio;
    @Expose
    private String blog;
    @Expose
    private Object company;
    @SerializedName("created_at")
    private String createdAt;
    @Expose
    private Object email;
    @SerializedName("events_url")
    private String eventsUrl;
    @Expose
    private Long followers;
    @SerializedName("followers_url")
    private String followersUrl;
    @Expose
    private Long following;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("gists_url")
    private String gistsUrl;
    @SerializedName("gravatar_id")
    private String gravatarId;
    @Expose
    private Object hireable;
    @SerializedName("html_url")
    private String htmlUrl;
    @Expose
    private Long id;
    @Expose
    private String location;
    @Expose
    private String login;
    @Expose
    private String name;
    @SerializedName("node_id")
    private String nodeId;
    @SerializedName("organizations_url")
    private String organizationsUrl;
    @SerializedName("public_gists")
    private Long publicGists;
    @SerializedName("public_repos")
    private Long publicRepos;
    @SerializedName("received_events_url")
    private String receivedEventsUrl;
    @SerializedName("repos_url")
    private String reposUrl;
    @SerializedName("site_admin")
    private Boolean siteAdmin;
    @SerializedName("starred_url")
    private String starredUrl;
    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;
    @Expose
    private String type;
    @SerializedName("updated_at")
    private String updatedAt;
    @Expose
    private String url;

}
