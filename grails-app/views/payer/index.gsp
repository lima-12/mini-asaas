<%@ page defaultCodec="html" %>
<meta name="layout" content="main"/>
<title>Lista de Pagadores</title>

<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

<div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 1rem;">
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
                    ${payer.adress} - ${payer.adressNumber}
                </atlas-table-col>

                <atlas-table-col>
                    <div style="display: flex; align-items: center; gap: 0.5rem;">
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
                    </div>
                </atlas-table-col>
            </atlas-table-row>
        </g:each>
    </atlas-table-body>
</atlas-table>


<script type="text/javascript">
    async function deletePayerWithAjax(payerId, buttonElement) {
        if (confirm('Tem certeza que deseja remover este pagador?')) {
            const response = await fetch('${createLink(action: 'delete')}/' + payerId, {
                method: 'DELETE'
            });

            if (response.ok) {
                const row = buttonElement.closest('atlas-table-row');
                if (row) {
                    row.remove();
                }
                alert('Pagador removido com sucesso!');
            } else {
                alert('Ocorreu um erro ao tentar remover o pagador.');
            }
        }
    }
</script>
