package com.mini.asaas.utils

class ValidateParams{

    public static boolean isCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); 
            }

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));

        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public static boolean isCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {
            int soma = 0;
            int peso = 5; 
            for (int i = 0; i < 12; i++) {
                soma += (cnpj.charAt(i) - '0') * peso;
                peso--;
                if (peso < 2) {
                    peso = 9;
                }
            }
            
            int resultado = soma % 11;
            int dv1 = (resultado < 2) ? 0 : (11 - resultado);
            
            if (dv1 != (cnpj.charAt(12) - '0')) {
                return false;
            }

            soma = 0;
            peso = 6; 
            for (int i = 0; i < 13; i++) {
                soma += (cnpj.charAt(i) - '0') * peso;
                peso--;
                if (peso < 2) {
                    peso = 9;
                }
            }

            resultado = soma % 11;
            int dv2 = (resultado < 2) ? 0 : (11 - resultado);

            if (dv2 != (cnpj.charAt(13) - '0')) {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    static Map validateCustomerParams(Map params) {
        Map errors = [:]

        if (!params.name) {
            errors.name = "name é obrigatório"
        }
        if (!params.email) {
            errors.email = "email é obrigatório"
        } else if (!params.email.matches(/^[^\s@]+@[^\s@]+\.[^\s@]+$/)) {
            errors.email = "email inválido"
        }
        if (params.typeRegistry == "Pessoa Física") {
            if (!isCPF(params.cpfCnpj)) {
                errors.cpfCnpj = "CPF inválido"
            }
            
        } else if (params.typeRegistry == "Pessoa Jurídica") {
            if (!isCNPJ(params.cpfCnpj)){
                errors.cpfCnpj = "CNPJ inválido"
            }
        }
        if (!params.postalCode) {
            errors.postalCode = "CEP é obrigatório"
        }


        if (!params.cpfCnpj) {
            errors.cpfCnpj = "CPF ou CNPJ é obrigatório"
        }

        if (errors) {
            return [hasErrors: true, errors: errors]
        }
        
        return [hasErrors: false]
    }
}