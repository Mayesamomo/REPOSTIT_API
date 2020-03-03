/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassTesting;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author micha
 */
@Entity
@Table(name = "community")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Community.findAll", query = "SELECT c FROM Community c")
    , @NamedQuery(name = "Community.findByCommunityId", query = "SELECT c FROM Community c WHERE c.communityId = :communityId")
    , @NamedQuery(name = "Community.findByCommunityName", query = "SELECT c FROM Community c WHERE c.communityName = :communityName")
    , @NamedQuery(name = "Community.findByCommunityStatus", query = "SELECT c FROM Community c WHERE c.communityStatus = :communityStatus")
    , @NamedQuery(name = "Community.findByCommunityDesc", query = "SELECT c FROM Community c WHERE c.communityDesc = :communityDesc")})
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "community_id")
    private Integer communityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "community_name")
    private String communityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "community_status")
    private int communityStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "community_desc")
    private String communityDesc;
    @ManyToMany(mappedBy = "communityCollection")
    private Collection<Users> usersCollection;
    @JoinTable(name = "communitytags", joinColumns = {
        @JoinColumn(name = "communityId", referencedColumnName = "community_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tagId", referencedColumnName = "tagId")})
    @ManyToMany
    private Collection<Tags> tagsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "community")
    private Collection<Post> postCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Users userId;

    public Community() {
    }

    public Community(Integer communityId) {
        this.communityId = communityId;
    }

    public Community(Integer communityId, String communityName, int communityStatus, String communityDesc) {
        this.communityId = communityId;
        this.communityName = communityName;
        this.communityStatus = communityStatus;
        this.communityDesc = communityDesc;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getCommunityStatus() {
        return communityStatus;
    }

    public void setCommunityStatus(int communityStatus) {
        this.communityStatus = communityStatus;
    }

    public String getCommunityDesc() {
        return communityDesc;
    }

    public void setCommunityDesc(String communityDesc) {
        this.communityDesc = communityDesc;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Tags> getTagsCollection() {
        return tagsCollection;
    }

    public void setTagsCollection(Collection<Tags> tagsCollection) {
        this.tagsCollection = tagsCollection;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communityId != null ? communityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Community)) {
            return false;
        }
        Community other = (Community) object;
        if ((this.communityId == null && other.communityId != null) || (this.communityId != null && !this.communityId.equals(other.communityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClassTesting.Community[ communityId=" + communityId + " ]";
    }
    
}
