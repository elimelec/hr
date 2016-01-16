package Entity;

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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CANDIDATE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Candidate.findAll", query = "SELECT c FROM Candidate c"),
    @NamedQuery(name = "Candidate.findByIdcandidate", query = "SELECT c FROM Candidate c WHERE c.idcandidate = :idcandidate"),
    @NamedQuery(name = "Candidate.findByFirstname", query = "SELECT c FROM Candidate c WHERE c.firstname = :firstname"),
    @NamedQuery(name = "Candidate.findByLastname", query = "SELECT c FROM Candidate c WHERE c.lastname = :lastname"),
    @NamedQuery(name = "Candidate.findByMobile", query = "SELECT c FROM Candidate c WHERE c.mobile = :mobile"),
    @NamedQuery(name = "Candidate.findByEmail", query = "SELECT c FROM Candidate c WHERE c.email = :email"),
    @NamedQuery(name = "Candidate.findByAdress", query = "SELECT c FROM Candidate c WHERE c.adress = :adress"),
    @NamedQuery(name = "Candidate.findByCuRelocare", query = "SELECT c FROM Candidate c WHERE c.cuRelocare = :cuRelocare")})
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    public static Object getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCANDIDATE")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer idcandidate;
    @Size(max = 45)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 45)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 45)
    @Column(name = "MOBILE")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 45)
    @Column(name = "ADRESS")
    private String adress;
    @Column(name = "CU_RELOCARE")
    private Boolean cuRelocare;
    @Column(name = "ACCEPTED")
    private Boolean accepted;
    @Lob
    @Column(name = "CV")
    private Serializable cv;
    @JoinTable(name = "POSITION_CANDIDATE", joinColumns = {
        @JoinColumn(name = "CANDIDATE_IDCANDIDATE", referencedColumnName = "IDCANDIDATE")}, inverseJoinColumns = {
        @JoinColumn(name = "POSITION_IDPOSITION", referencedColumnName = "IDPOSITION")})
    @ManyToMany
    private Collection<Position> positionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateIdcandidate")
    private Collection<Comments> commentsCollection;

    
    public Candidate() {
    }

    public Candidate(Integer idcandidate) {
        this.idcandidate = idcandidate;
    }

    public Integer getIdcandidate() {
        return idcandidate;
    }

    public void setIdcandidate(Integer idcandidate) {
        this.idcandidate = idcandidate;
    }

    public void setAccepted(Boolean b)
    {
        this.accepted=b;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Boolean getCuRelocare() {
        return cuRelocare;
    }

    public void setCuRelocare(Boolean cuRelocare) {
        this.cuRelocare = cuRelocare;
    }

    public Serializable getCv() {
        return cv;
    }

    public void setCv(Serializable cv) {
        this.cv = cv;
    }

    @XmlTransient
    public Collection<Position> getPositionCollection() {
        return positionCollection;
    }

    public void setPositionCollection(Collection<Position> positionCollection) {
        this.positionCollection = positionCollection;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcandidate != null ? idcandidate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.idcandidate == null && other.idcandidate != null) || (this.idcandidate != null && !this.idcandidate.equals(other.idcandidate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HREntity.Candidate[ idcandidate=" + idcandidate + " ]";
    }
    
}
