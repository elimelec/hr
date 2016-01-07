/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "COMMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByIdcomments", query = "SELECT c FROM Comments c WHERE c.idcomments = :idcomments"),
    @NamedQuery(name = "Comments.findByDeleted", query = "SELECT c FROM Comments c WHERE c.deleted = :deleted")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMMENTS")
    private Integer idcomments;
    @Column(name = "DELETED")
    private Boolean deleted;
    @JoinColumn(name = "CANDIDATE_IDCANDIDATE", referencedColumnName = "IDCANDIDATE")
    @ManyToOne(optional = false)
    private Candidate candidateIdcandidate;

    public Comments() {
    }

    public Comments(Integer idcomments) {
        this.idcomments = idcomments;
    }

    public Integer getIdcomments() {
        return idcomments;
    }

    public void setIdcomments(Integer idcomments) {
        this.idcomments = idcomments;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Candidate getCandidateIdcandidate() {
        return candidateIdcandidate;
    }

    public void setCandidateIdcandidate(Candidate candidateIdcandidate) {
        this.candidateIdcandidate = candidateIdcandidate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomments != null ? idcomments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.idcomments == null && other.idcomments != null) || (this.idcomments != null && !this.idcomments.equals(other.idcomments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HREntity.Comments[ idcomments=" + idcomments + " ]";
    }
    
}
