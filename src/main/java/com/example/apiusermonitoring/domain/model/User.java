package com.example.apiusermonitoring.domain.model;

import java.util.Date;
import java.util.Set;

public class User {

    private String id;
    private String email;
    private String name;
    private String image;
    private String position;
    private Date emailVerified;
    private Date termsAndConditionsAccepted;
    private Date createdAt;
    private Date updatedAt;
    private Role role;
    private Set<Country> countries;


    public User(String id, String email, String name, String image, String position, Date emailVerified, Date termsAndConditionsAccepted, Date createdAt, Date updatedAt, Role role, Set<Country> countries) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.image = image;
        this.position = position;
        this.emailVerified = emailVerified;
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.countries = countries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Date emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Date getTermsAndConditionsAccepted() {
        return termsAndConditionsAccepted;
    }

    public void setTermsAndConditionsAccepted(Date termsAndConditionsAccepted) {
        this.termsAndConditionsAccepted = termsAndConditionsAccepted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updatedAt = updatedAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!getId().equals(user.getId())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getName().equals(user.getName())) return false;
        if (getImage() != null ? !getImage().equals(user.getImage()) : user.getImage() != null) return false;
        if (getPosition() != null ? !getPosition().equals(user.getPosition()) : user.getPosition() != null)
            return false;
        if (getEmailVerified() != null ? !getEmailVerified().equals(user.getEmailVerified()) : user.getEmailVerified() != null)
            return false;
        if (getTermsAndConditionsAccepted() != null ? !getTermsAndConditionsAccepted().equals(user.getTermsAndConditionsAccepted()) : user.getTermsAndConditionsAccepted() != null)
            return false;
        if (!getCreatedAt().equals(user.getCreatedAt())) return false;
        if (getUpdatedAt() != null ? !getUpdatedAt().equals(user.getUpdatedAt()) : user.getUpdatedAt() != null)
            return false;
        if (getRole() != null ? !getRole().equals(user.getRole()) : user.getRole() != null) return false;
        return getCountries() != null ? getCountries().equals(user.getCountries()) : user.getCountries() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getPosition() != null ? getPosition().hashCode() : 0);
        result = 31 * result + (getEmailVerified() != null ? getEmailVerified().hashCode() : 0);
        result = 31 * result + (getTermsAndConditionsAccepted() != null ? getTermsAndConditionsAccepted().hashCode() : 0);
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + (getUpdatedAt() != null ? getUpdatedAt().hashCode() : 0);
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        result = 31 * result + (getCountries() != null ? getCountries().hashCode() : 0);
        return result;
    }

}
