package api.devEx.tests.day06;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class EutorechUserFromJsonschema2pojo {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("profileId")
    @Expose
    private Integer profileId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public EutorechUserFromJsonschema2pojo() {
    }

    /**
     * 
     * @param profileId
     * @param name
     * @param company
     * @param id
     * @param email
     * @param status
     */
    public EutorechUserFromJsonschema2pojo(Integer id, String email, String name, String company, String status, Integer profileId) {
        super();
        this.id = id;
        this.email = email;
        this.name = name;
        this.company = company;
        this.status = status;
        this.profileId = profileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

}
