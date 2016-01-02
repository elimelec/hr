package HREntity;

import HREntity.Comments;
import HREntity.Position;
import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T14:55:44")
@StaticMetamodel(Candidate.class)
public class Candidate_ { 

    public static volatile SingularAttribute<Candidate, Boolean> cuRelocare;
    public static volatile SingularAttribute<Candidate, String> firstname;
    public static volatile SingularAttribute<Candidate, Serializable> cv;
    public static volatile SingularAttribute<Candidate, Integer> idcandidate;
    public static volatile SingularAttribute<Candidate, String> mobile;
    public static volatile CollectionAttribute<Candidate, Position> positionCollection;
    public static volatile SingularAttribute<Candidate, String> adress;
    public static volatile CollectionAttribute<Candidate, Comments> commentsCollection;
    public static volatile SingularAttribute<Candidate, String> email;
    public static volatile SingularAttribute<Candidate, String> lastname;

}