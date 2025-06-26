function PaymentEditController() {

    this.init = function () {
        this.setupListeners();
    };

    this.setupListeners = function () {
        const deleteButtons = document.querySelectorAll(".delete-payment-btn");

        deleteButtons.forEach(button => {
            button.addEventListener("click", () => {
                const paymentId = button.dataset.paymentId;
                this.deletePaymentWithAjax(paymentId);
            });
        });
    };

    this.deletePaymentWithAjax = async function (paymentId) {
        if (!confirm('Tem certeza que deseja remover este pagamento?')) return;

        const response = await fetch(`/payment/delete/${paymentId}`, {
            method: 'DELETE'
        });

        if (!response.ok) {
            alert('Ocorreu um erro ao tentar remover o pagamento.');
            return;
        }

        alert('Pagamento removido com sucesso!');
        window.location.reload();
    };
}

document.addEventListener("DOMContentLoaded", function () {
    const controller = new PaymentEditController();
    controller.init();
});
