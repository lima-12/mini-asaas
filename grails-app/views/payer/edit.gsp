<meta name="layout" content="main"/>
<title>Editar Pagador</title>

<g:render template="form" model="[payer: payer]"/>

<atlas-layout gap="2" inline style="margin-top: 1rem;">
    <atlas-button
            description="Atualizar"
            appearance="primary"
            onclick="updatePayerWithAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<script type="text/javascript">
    const payerId = ${payer.id};

    async function updatePayerWithAjax() {
        const payerData = {
            name: document.getElementById('name').value,
            email: document.getElementById('email').value,
            cpfCnpj: document.getElementById('cpfCnpj').value,
            postalCode: document.getElementById('postalCode').value,
            adress: document.getElementById('adress').value,
            adressNumber: document.getElementById('adressNumber').value
        };

        const response = await fetch('${createLink(action: 'update')}/' + payerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payerData)
        });

        if (response.ok) {
            // alert('Pagador atualizado com sucesso!');
            window.location.href = '${createLink(action: 'index')}';
        } else {
            const errorData = await response.json();
            alert('Erro ao atualizar: \n' + (errorData.errors ? errorData.errors.join('\n') : errorData.error));
        }
    }
</script>