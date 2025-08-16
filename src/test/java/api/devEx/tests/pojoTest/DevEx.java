
package api.devEx.tests.pojoTest;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DevEx {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("skills")
    @Expose
    private List<String> skills;
    @SerializedName("bio")
    @Expose
    private Object bio;
    @SerializedName("githubusername")
    @Expose
    private String githubusername;
    @SerializedName("social")
    @Expose
    private Social social;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("education")
    @Expose
    private List<Object> education;
    @SerializedName("experience")
    @Expose
    private List<Object> experience;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DevEx() {
    }

    /**
     * 
     * @param date
     * @param website
     * @param education
     * @param year
     * @param social
     * @param bio
     * @param experience
     * @param userId
     * @param skills
     * @param githubusername
     * @param company
     * @param location
     * @param id
     * @param user
     * @param status
     */
    public DevEx(Integer id, String company, String website, Integer year, String location, String status, List<String> skills, Object bio, String githubusername, Social social, String date, Integer userId, User user, List<Object> education, List<Object> experience) {
        super();
        this.id = id;
        this.company = company;
        this.website = website;
        this.year = year;
        this.location = location;
        this.status = status;
        this.skills = skills;
        this.bio = bio;
        this.githubusername = githubusername;
        this.social = social;
        this.date = date;
        this.userId = userId;
        this.user = user;
        this.education = education;
        this.experience = experience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Object getBio() {
        return bio;
    }

    public void setBio(Object bio) {
        this.bio = bio;
    }

    public String getGithubusername() {
        return githubusername;
    }

    public void setGithubusername(String githubusername) {
        this.githubusername = githubusername;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Object> getEducation() {
        return education;
    }

    public void setEducation(List<Object> education) {
        this.education = education;
    }

    public List<Object> getExperience() {
        return experience;
    }

    public void setExperience(List<Object> experience) {
        this.experience = experience;
    }

}
