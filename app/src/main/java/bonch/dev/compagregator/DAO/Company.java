package bonch.dev.compagregator.DAO;

import java.util.List;

public class Company {

    private String name;
    private String comment;
    private String email;
    private Boolean hidden;
    private List<Tag> tags;
    private List<Tag> need_tags;

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

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Tag> getNeed_tags() {
        return need_tags;
    }

    public void setNeed_tags(List<Tag> need_tags) {
        this.need_tags = need_tags;
    }
}
