<%@ page import="com.mini.asaas.Payer" %>

<atlas-layout>

    <input type="hidden" id="payerId" value="${payer?.id}" />

    <atlas-panel>
        <atlas-grid>
            <atlas-row>
                <atlas-col lg="6">
                    <atlas-input
                            id="name"
                            label="Nome"
                            value="${payer?.name}"
                            required>
                    </atlas-input>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-input
                            id="email"
                            label="E-mail"
                            value="${payer?.email}">
                    </atlas-input>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-masked-input
                            id="cpfCnpj"
                            label="CPF/CNPJ"
                            mask-alias="cpf-cnpj"
                            value="${payer?.cpfCnpj}"
                            required>
                    </atlas-masked-input>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-masked-input
                            id="postalCode"
                            label="CEP"
                            mask-alias="cep"
                            value="${payer?.postalCode}">
                    </atlas-masked-input>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-input
                            id="address"
                            label="Logradouro"
                            value="${payer?.address}">
                    </atlas-input>
                </atlas-col>
                <atlas-col lg="6">
                    <atlas-integer-input
                            id="addressNumber"
                            label="Número"
                            value="${payer?.addressNumber}">
                    </atlas-integer-input>
                </atlas-col>
            </atlas-row>
        </atlas-grid>
    </atlas-panel>
</atlas-layout>