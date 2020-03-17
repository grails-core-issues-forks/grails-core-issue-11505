package example.grails

class UserRole implements Serializable {
    private static final long serialVersionUID = 1

    User user
    Role role

    static mapping = {
        id composite: ['user', 'role']
        version false
    }
}