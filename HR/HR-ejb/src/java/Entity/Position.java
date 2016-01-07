/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alexa
 */
@Entity
@Table(name = "POSITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p"),
    @NamedQuery(name = "Position.findByIdposition", query = "SELECT p FROM Position p WHERE p.idposition = :idposition"),
    @NamedQuery(name = "Position.findByName", query = "SELECT p FROM Position p WHERE p.name = :name"),
    @NamedQuery(name = "Position.findByNoPositions", query = "SELECT p FROM Position p WHERE p.noPositions = :noPositions"),
    @NamedQuery(name = "Position.findByDepartment", query = "SELECT p FROM Position p WHERE p.department = :department"),
    @NamedQuery(name = "Position.findByCerinte", query = "SELECT p FROM Position p WHERE p.cerinte = :cerinte"),
    @NamedQuery(name = "Position.findByResponsabilitati", query = "SELECT p FROM Position p WHERE p.responsabilitati = :responsabilitati"),
    @NamedQuery(name = "Position.findByProject", query = "SELECT p FROM Position p WHERE p.project = :project"),
    @NamedQuery(name = "Position.findByOpened", query = "SELECT p FROM Position p WHERE p.opened = :opened"),
    @NamedQuery(name = "Position.findByDeleted", query = "SELECT p FROM Position p WHERE p.deleted = :deleted")})
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPOSITION")
    private Integer idposition;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 45)
    @Column(name = "NO_POSITIONS")
    private String noPositions;
    @Size(max = 45)
    @Column(name = "DEPARTMENT")
    private String department;
    @Size(max = 45)
    @Column(name = "CERINTE")
    private String cerinte;
    @Size(max = 45)
    @Column(name = "RESPONSABILITATI")
    private String responsabilitati;
    @Size(max = 45)
    @Column(name = "PROJECT")
    private String project;
    @Size(max = 45)
    @Column(name = "OPENED")
    private String opened;
    @Size(max = 45)
    @Column(name = "DELETED")
    private String deleted;
    @ManyToMany(mappedBy = "positionCollection")
    private Collection<Candidate> candidateCollection;
    @JoinColumn(name = "USER_IDUSER1", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Users userIduser1;

    public Position() {
    }

    public Position(Integer idposition) {
        this.idposition = idposition;
    }

    public Integer getIdposition() {
        return idposition;
    }

    public void setIdposition(Integer idposition) {
        this.idposition = idposition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoPositions() {
        return noPositions;
    }

    public void setNoPositions(String noPositions) {
        this.noPositions = noPositions;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCerinte() {
        return cerinte;
    }

    public void setCerinte(String cerinte) {
        this.cerinte = cerinte;
    }

    public String getResponsabilitati() {
        return responsabilitati;
    }

    public void setResponsabilitati(String responsabilitati) {
        this.responsabilitati = responsabilitati;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public Collection<Candidate> getCandidateCollection() {
        return candidateCollection;
    }

    public void setCandidateCollection(Collection<Candidate> candidateCollection) {
        this.candidateCollection = candidateCollection;
    }

    public Users getUserIduser1() {
        return userIduser1;
    }

    public void setUserIduser1(Users userIduser1) {
        this.userIduser1 = userIduser1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idposition != null ? idposition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.idposition == null && other.idposition != null) || (this.idposition != null && !this.idposition.equals(other.idposition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HREntity.Position[ idposition=" + idposition + " ]";
    }
    
}
