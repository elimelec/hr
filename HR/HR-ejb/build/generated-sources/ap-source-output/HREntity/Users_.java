package HREntity;

import HREntity.Position;
import HREntity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T14:55:44")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> iduser;
    public static volatile SingularAttribute<Users, String> firstname;
    public static volatile SingularAttribute<Users, Boolean> deleted;
    public static volatile CollectionAttribute<Users, Role> roleCollection;
    public static volatile SingularAttribute<Users, String> function;
    public static volatile SingularAttribute<Users, String> mobile;
    public static volatile CollectionAttribute<Users, Position> positionCollection;
    public static volatile SingularAttribute<Users, String> description;
    public static volatile SingularAttribute<Users, String> telephone;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> lastname;
    public static volatile SingularAttribute<Users, String> username;

}