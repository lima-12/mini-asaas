async function savePaymentWithAjax() {

    const paymentData = {
        customerId: document.getElementById('customerId').value,
        payerId: document.getElementById('payerId').value,
        value: document.getElementById('value').value,
        billingType: document.getElementById('billingType').value,
        status: document.getElementById('status').value,
        dueDate: document.getElementById('dueDate').value
    };


    const response = await fetch('/payment/save' , {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(paymentData)
    });

    if (!response.ok) {
        const errorData = await response.json();
        alert('Erro ao salvar: \n' + (errorData.errors ? errorData.errors.join('\n') : errorData.error));
        return;
    }


    window.location.href = '/payment/index';
}