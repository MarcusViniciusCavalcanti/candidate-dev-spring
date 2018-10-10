var errors = document.querySelector("[role=\"errors\"]");
console.log(errors);
if (errors !== null) {new PNotify({ title: 'Algo não esta certo!', text: errors.innerHTML, type: 'error', styling: 'bootstrap3' });
}