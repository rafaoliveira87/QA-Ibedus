package com.ibedus.pojos;

public class University {

    private int id;
    private String name;
    private String abbreviation;
    private String logoURL;
    private String website;
    private boolean isPrivate;
    private SocialMedia socialMedia;


    public int getID()
    {
        return this.id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAbbreviation()
    {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public String getLogoURL()
    {
        return this.logoURL;
    }

    public void setLogoURL(String logoURL)
    {
        this.logoURL = logoURL;
    }

    public String getWebsite()
    {
        return this.website;
    }

    public void setWebSite(String website)
    {
        this.website = website;
    }

    public boolean getIsPrivate()
    {
        return this.isPrivate;
    }

    public void setIsPrivate(boolean isPrivate)
    {
        this.isPrivate = isPrivate;
    }

    public SocialMedia getSocialMedia()
    {
        return this.socialMedia;
    }

    public void setSocialMedia(SocialMedia socialMedia)
    {
        this.socialMedia = socialMedia;
    }

    public University()
    {
        int id = 0;
        name = null;
        abbreviation = null;
        logoURL = null;
        website = null;
        isPrivate = false;
        socialMedia = null;
    }

    public University(int id, String name, String abbreviation, String logoURL, String website,
                        boolean isPrivate, SocialMedia socialMedia)
    {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.logoURL = logoURL;
        this.website = website;
        this.isPrivate = isPrivate;
        this.socialMedia = socialMedia;
    }





}
