package HREntity;

import HREntity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-31T14:55:44")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, Integer> idrole;
    public static volatile SingularAttribute<Role, String> role;
    public static volatile CollectionAttribute<Role, Users> usersCollection;

}