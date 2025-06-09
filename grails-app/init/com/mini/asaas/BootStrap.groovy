package com.mini.asaas

import grails.gorm.transactions.Transactional

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        println "BOOTSTRAP - INIT: Verificando/Criando usuários..."

        Role.withTransaction {
            if (!Role.findByAuthority("ROLE_ADMIN")) {
                println "Criando usuário de teste 'admin'..."

                // Codificar a senha antes de salvar
                def encodedPassword = springSecurityService.encodePassword("123456")

                def roleAdmin = new Role(authority: "ROLE_ADMIN").save()
                def user = new User(username: "admin", password: encodedPassword, enabled: true)
                if (!user.save(flush: true)) {
                    println "ERRO ao salvar usuário: ${user.errors}"
                }

                if (user && roleAdmin) {
                    UserRole.create(user, roleAdmin, true)
                    println "Usuário 'admin' criado com senha '123456' e permissão ROLE_ADMIN."
                } else {
                    println "ERRO: Falha ao criar o usuário ou a role."
                }
            } else {
                println "Usuário 'admin' já existe. Nenhuma ação necessária."
            }
        }
    }

    def destroy = {
        //
    }
}
