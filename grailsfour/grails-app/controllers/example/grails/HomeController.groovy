package example.grails

import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic
import groovy.transform.CompileDynamic

@CompileStatic
class HomeController {

    def responseFormats = ['json']

    static allowedMethods = [index: 'GET']

    UserRoleService userRoleService
    UserService userService
    RoleService roleService

    def index() {
        User sergio = userService.save('sergio')
        Role admin = roleService.save('ROLE_ADMIN')
        Role user =roleService.save('ROLE_USER')
        userRoleService.save(sergio, admin)
        userRoleService.save(sergio, user)

        respond([ids: findAllRoleIdsByUser(sergio.id)])
    }

    @CompileDynamic
    @ReadOnly
    List<Long> findAllRoleIdsByUser(Long userId) {
        def c = UserRole.createCriteria()
        c.list {
            projections {
                role {
                    property('id')
                }
            }
            user {
                eq('id', userId)
            }
        } as List<Long>
    }
}