<%@ page import="com.mini.asaas.Payer" %>

<%-- 1. Este é o container que receberá as mensagens de erro via JavaScript.
   Ele começa escondido com 'display: none'. --%>
<div id="error-messages-container" class="errors" role="alert" style="color: red; border: 1px solid red; padding: 10px; margin-bottom: 1rem; display: none;">
    <%-- O conteúdo aqui será preenchido pelo JavaScript --%>
</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;">
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
            id="adress"
            label="Logradouro"
            value="${payer?.adress}">
    </atlas-input>

    <atlas-integer-input
            id="adressNumber"
            label="Número"
            value="${payer?.adressNumber}">
    </atlas-integer-input>
</div>