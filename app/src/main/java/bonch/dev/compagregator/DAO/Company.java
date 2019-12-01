package bonch.dev.compagregator.DAO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Company {
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private int ID;
    private String name;
    private String comment;
    private String email;
    private Boolean hidden;
    private List<Tag> tags;
    private List<Tag> need_tags;

    public Company(int ID, String name, String comment, String email, Boolean hidden, List<Tag> tags, List<Tag> need_tags) {
        this.ID = ID;
        this.name = name;
        this.comment = comment;
        this.email = email;
        this.hidden = hidden;
        this.tags = tags;
        this.need_tags = need_tags;
    }

    public Company(String compName, String compComment, String compEmail, Boolean isCompanyHidden, List<Tag> companyTags, List<Tag> findTags) {
        this.name = compName;
        this.comment = compComment;
        this.email = compEmail;
        this.hidden = isCompanyHidden;
        this.tags = companyTags;
        this.need_tags = findTags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCompanyHidden() {
        return hidden;
    }

    public void setCompanyHidden(Boolean companyHidden) {
        hidden = companyHidden;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getNeed_tags() {
        return need_tags;
    }

    public void setNeed_tags(ArrayList<Tag> need_tags) {
        this.need_tags = need_tags;
    }
}
