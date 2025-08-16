
package api.devEx.tests.pojoTest;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Social {

    @SerializedName("youtube")
    @Expose
    private String youtube;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("linkedin")
    @Expose
    private String linkedin;
    @SerializedName("instagram")
    @Expose
    private String instagram;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Social() {
    }

    /**
     * 
     * @param youtube
     * @param twitter
     * @param facebook
     * @param linkedin
     * @param instagram
     */
    public Social(String youtube, String twitter, String facebook, String linkedin, String instagram) {
        super();
        this.youtube = youtube;
        this.twitter = twitter;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.instagram = instagram;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

}
