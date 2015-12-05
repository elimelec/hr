package HREntity;

import HREntity.Candidate;
import HREntity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-06T00:59:56")
@StaticMetamodel(Position.class)
public class Position_ { 

    public static volatile SingularAttribute<Position, String> deleted;
    public static volatile SingularAttribute<Position, String> noPositions;
    public static volatile SingularAttribute<Position, String> name;
    public static volatile SingularAttribute<Position, Integer> idposition;
    public static volatile SingularAttribute<Position, String> project;
    public static volatile SingularAttribute<Position, String> opened;
    public static volatile CollectionAttribute<Position, Candidate> candidateCollection;
    public static volatile SingularAttribute<Position, Users> userIduser1;
    public static volatile SingularAttribute<Position, String> department;
    public static volatile SingularAttribute<Position, String> cerinte;
    public static volatile SingularAttribute<Position, String> responsabilitati;

}