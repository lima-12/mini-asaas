<%@ page import="com.mini.asaas.Payer" %>

<%-- 1. Este é o container que receberá as mensagens de erro via JavaScript.
   Ele começa escondido com 'display: none'. --%>
<div id="error-messages-container" class="errors" role="alert" style="color: red; border: 1px solid red; padding: 10px; margin-bottom: 1rem; display: none;">
    <%-- O conteúdo aqui será preenchido pelo JavaScript --%>
</div>

<div style="display: grid; grid-template-columns: 1fr 1fr; gap: 1rem;">
    <atlas-input
            id="nome"
            style="grid-column: span 2;"
            label="Nome"
            value="${payer?.nome}"
            required>
    </atlas-input>

    <atlas-masked-input
            id="cpfCnpj"
            label="CPF/CNPJ"
            mask-alias="cpf-cnpj"
            value="${payer?.cpfCnpj}"
            required>
    </atlas-masked-input>

    <atlas-masked-input
            id="cep"
            label="CEP"
            mask-alias="cep"
            value="${payer?.cep}">
    </atlas-masked-input>

    <atlas-input
            id="logradouro"
            label="Logradouro"
            value="${payer?.logradouro}">
    </atlas-input>

    <atlas-integer-input
            id="numero"
            label="Número"
            value="${payer?.numero}">
    </atlas-integer-input>
</div>