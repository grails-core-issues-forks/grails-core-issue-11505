package example.grails

import grails.gorm.services.Service

@Service(User)
interface UserService {
    User save(String username)
}