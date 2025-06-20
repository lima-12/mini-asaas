async function updatePayerWithAjax() {

    const payerId = document.getElementById('payerId')?.value;

    const payerData = {
        name: document.getElementById('name')?.value || '',
        email: document.getElementById('email')?.value || '',
        cpfCnpj: document.getElementById('cpfCnpj')?.value || '',
        postalCode: document.getElementById('postalCode')?.value || '',
        address: document.getElementById('address')?.value || '',
        addressNumber: document.getElementById('addressNumber')?.value || ''
    };

    const response = await fetch(`/payer/update/${payerId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payerData)
    });

    if (!response.ok) {
        const errorData = await response.json();
        alert('Erro ao atualizar: \n' + (errorData.errors ? errorData.errors.join('\n') : errorData.error));
        return;
    }

    window.location.href = '/payer/index';
}