package example.grails

import grails.gorm.services.Service

@Service(Role)
interface RoleService {

    Role save(String authority)
}