<%@ page defaultCodec="html" %>
<meta name="layout" content="main"/>
<asset:stylesheet src="payer/index.css"/>

<title>Lista de Pagadores</title>

<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

<div class="header-container">
    <h2>Pagadores Cadastrados</h2>
    <atlas-button appearance="primary" description="Novo Pagador" href="${createLink(action: 'create')}"></atlas-button>
</div>

<atlas-table>
    <atlas-table-header slot="header">
        <atlas-table-col> Nome </atlas-table-col>
        <atlas-table-col> Email </atlas-table-col>
        <atlas-table-col> CPF/CNPJ </atlas-table-col>
        <atlas-table-col> Endereço </atlas-table-col>
        <atlas-table-col> Ações </atlas-table-col>
    </atlas-table-header>

    <atlas-table-body slot="body">
        <g:each in="${payerList}" var="payer">
            <atlas-table-row>
                <atlas-table-col>
                    ${payer.name}
                </atlas-table-col>

                <atlas-table-col>
                    ${payer.email}
                </atlas-table-col>

                <atlas-table-col>
                    ${payer.cpfCnpj}
                </atlas-table-col>

                <atlas-table-col>
                    ${payer.address} - ${payer.addressNumber}
                </atlas-table-col>

                <atlas-table-col>
                    <atlas-layout gap="2" inline>
                        <atlas-button
                            type="outlined"
                            theme="primary"
                            size="sm"
                            description="Editar"
                            href="${createLink(action: 'edit', id: payer.id)}">
                        </atlas-button>

                        <atlas-button
                                type="outlined"
                                theme="danger"
                                size="sm"
                                description="Deletar"
                                onclick="deletePayerWithAjax(${payer.id}, this)">
                        </atlas-button>
                    </atlas-layout>
                </atlas-table-col>
            </atlas-table-row>
        </g:each>
    </atlas-table-body>
</atlas-table>


<asset:javascript src="payer/index.js"/>

