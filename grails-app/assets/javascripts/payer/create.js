async function savePayerWithAjax() {

    const payerData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        cpfCnpj: document.getElementById('cpfCnpj').value,
        postalCode: document.getElementById('postalCode').value,
        address: document.getElementById('address').value,
        addressNumber: document.getElementById('addressNumber').value
    };

    const response = await fetch('/payer/save' , {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
    },
        body: JSON.stringify(payerData)
    });

        if (response.ok) {
        window.location.href = '/payer/index';
    } else {
        const errorData = await response.json();
        alert('Erro ao salvar: \n' + errorData.errors.join('\n'));
    }
}