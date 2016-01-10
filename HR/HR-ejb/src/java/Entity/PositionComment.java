package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "POSITION_COMMENT")
@NamedQueries({
    @NamedQuery(name = "PositionComment.findAll", query = "SELECT r FROM PositionComment r"),
    @NamedQuery(name = "PositionComment.findByPositionId", query = "SELECT c FROM PositionComment c WHERE c.positionId = :positionId")})
public class PositionComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "TEXT")
    private String text;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSITION_ID")
    private int positionId;

    public PositionComment() {
    }

    public PositionComment(String text, int positionId) {
        this.text = text;
        this.positionId = positionId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PositionComment)) {
            return false;
        }
        PositionComment other = (PositionComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PositionComment[ id=" + id + " ]";
    }

}
