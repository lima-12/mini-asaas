<meta name="layout" content="main"/>
<title>Criar Novo Pagador</title>

<g:render template="form"/>

<atlas-layout gap="2" inline style="margin-top: 1rem;">
    <atlas-button
            description="Salvar"
            appearance="primary"
            onclick="savePayerWithAjax()">
    </atlas-button>
    <atlas-button
            description="Cancelar"
            appearance="secondary"
            href="${createLink(action: 'index')}">
    </atlas-button>
</atlas-layout>

<script type="text/javascript">
    async function savePayerWithAjax() {

        const payerData = {
            name: document.getElementById('name').value,
            email: document.getElementById('email').value,
            cpfCnpj: document.getElementById('cpfCnpj').value,
            postalCode: document.getElementById('postalCode').value,
            adress: document.getElementById('adress').value,
            adressNumber: document.getElementById('adressNumber').value
        };

        const response = await fetch('${createLink(action: 'save')}', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payerData)
        });

        if (response.ok) {
            // alert('Pagador criado com sucesso!');
            window.location.href = '${createLink(action: 'index')}';
        } else {
            const errorData = await response.json();
            alert('Erro ao salvar: \n' + errorData.errors.join('\n'));
        }
    }
</script>