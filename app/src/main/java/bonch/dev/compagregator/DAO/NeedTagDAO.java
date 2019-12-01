package bonch.dev.compagregator.DAO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NeedTagDAO {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("CreatedAt")
    @Expose
    private String createdAt;
    @SerializedName("UpdatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("DeletedAt")
    @Expose
    private Object deletedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("companies")
    @Expose
    private Object companies;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCompanies() {
        return companies;
    }

    public void setCompanies(Object companies) {
        this.companies = companies;
    }
}
