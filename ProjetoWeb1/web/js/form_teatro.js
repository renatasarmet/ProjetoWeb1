/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaForm() {
    valido = true;
    formData = new FormData($('.criacao', '.edicao')[0]);
    for (var pair of formData.entries()) {
        console.log("key: " + pair[0] + ", val: " + pair[1]);
    }

    if (!validaEmail(formData['email'])) {
        $('#emailTeatro').css("border", "2").css("border-color", "red");
        valido = false;
    } else {
        $('#emailTeatro').css("border", "none");
    }

    if (!validaNaoVazio(formData['senha'])) {
        $('#senhaTeatro').css("border-color", "red");
        valido = false;
    } else {
        $('#senhaTeatro').css("border", "none");
    }

    if (!validaCNPJ($('#cnpjTeatro').val())) {
        $('#cnpjTeatro').css("border", "2").css("border-color", "red");
        valido = false;
    } else {
        $('#cnpjTeatro').css("border", "none");
    }

    if (!validaInputTexto(formData['nome'])) {
        $('#nomeTeatro').css("border-color", "red");
        valido = false;
    } else {
        $('#nomeTeatro').css("border", "none");
    }

    if (!validaInputTexto(formData['cidade'])) {
        $('#cidadeTeatro').css("border-color", "red");
        valido = false;
    } else {
        $('#cidadeTeatro').css("border", "none");
    }
    if (!valido)
        alert("invalido!")
    return(valido);
}
;
