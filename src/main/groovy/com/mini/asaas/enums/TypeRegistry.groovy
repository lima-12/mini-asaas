package com.mini.asaas.enums

enum TypeRegistry {

    PESSOA_FISICA('Pessoa Física'),
    PESSOA_JURIDICA('Pessoa Jurídica')

    private final String value

    public TypeRegistry(String value) {
        this.value = value
    }
}