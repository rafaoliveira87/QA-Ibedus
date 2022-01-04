package com.ibedus.pojos;

public class SocialMedia {
    private String facebook;
    private String instagram;
    private String youtube;
    private String twitter;
    private String linkedin;

    public String getFacebook()
    {
        return this.facebook;
    }
    public String getInstagram()
    {
        return this.instagram;
    }
    public String getYoutube()
    {
        return this.youtube;
    }
    public String getTwitter()
    {
        return this.twitter;
    }
    public String getLinkedin()
    {
        return this.linkedin;
    }


    public void setFacebook(String facebook)
    {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram)
    {
        this.instagram = instagram;
    }

    public void setYoutube(String youtube)
    {
        this.youtube = youtube;
    }

    public void setTwitter(String twitter)
    {
        this.twitter = twitter;
    }

    public void setLinkedin(String linkedin)
    {
        this.linkedin = linkedin;
    }

    public SocialMedia(){
        facebook = null;
        instagram = null;
        youtube = null;
        twitter = null;
        linkedin = null;
    }

    public SocialMedia(String facebook, String instagram, String youtube, String twitter, String linkedin)
    {
        this.facebook = facebook;
        this.instagram = instagram;
        this.youtube = youtube;
        this.twitter = twitter;
        this.linkedin = linkedin;
    }
}
