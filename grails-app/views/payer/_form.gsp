<%@ page import="com.mini.asaas.Payer" %>

<div id="error-messages-container" class="errors" role="alert" style="color: red; border: 1px solid red; padding: 10px; margin-bottom: 1rem; display: none;">

</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;">

    <input type="hidden" id="payerId" value="${payer?.id}" />

    <atlas-input
            id="name"
            label="Nome"
            value="${payer?.name}"
            required>
    </atlas-input>

    <atlas-input
            id="email"
            label="E-mail"
            value="${payer?.email}">
    </atlas-input>

    <atlas-masked-input
            id="cpfCnpj"
            label="CPF/CNPJ"
            mask-alias="cpf-cnpj"
            value="${payer?.cpfCnpj}"
            required>
    </atlas-masked-input>

    <atlas-masked-input
            id="postalCode"
            label="CEP"
            mask-alias="cep"
            value="${payer?.postalCode}">
    </atlas-masked-input>

    <atlas-input
            id="address"
            label="Logradouro"
            value="${payer?.address}">
    </atlas-input>

    <atlas-integer-input
            id="addressNumber"
            label="Número"
            value="${payer?.addressNumber}">
    </atlas-integer-input>
</div>