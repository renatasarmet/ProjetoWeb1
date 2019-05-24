/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaForm() {
    valido = true;
    formData = new FormData($('.criacao, .edicao')[0]);
    for (var pair of formData.entries()) {
        console.log("key: " + pair[0] + ", val: " + pair[1]);
    }
    
    // key: email
    if (!validaEmail(formData.get('email'))) {
        $('#emailTeatro').css("border", "2").css("border-color", "red");
        valido = false;
    } else {
        $('#emailTeatro').css("border", "none");
    }

    // key: Senha
    if (!validaNaoVazio(formData.get('senha1Teatro'))) {
        $('#senha1Teatro').css("border-color", "red");
        valido = false;
    } else {
        $('#senha1Teatro').css("border", "none");
    }

    // key: Confirma senha
    if (!validaNaoVazio(formData.get('senha2Teatro'))) {
        $('#senha2Teatro').css("border-color", "red");
        valido = false;
    } else {
        $('#senha2Teatro').css("border", "none");
    }

    // Mudança de senha
    // - Senha antiga
    if (!("senhaAntigaTeatro" in formData)) {
        if (!validaNaoVazio(formData.get('senhaAntigaSite'))) {
            $('#senhaAntigaTeatro').css("border-color", "red");
            valido = false;
        } else {
            $('#senhaAntigaTeatro').css("border", "none");
        }
    }
    
    // key: CNPJ
    if (!validaCNPJ($('#cnpjTeatro').val())) {
        $('#cnpjTeatro').css("border", "2").css("border-color", "red");
        valido = false;
    } else {
        $('#cnpjTeatro').css("border", "none");
    }
    
    // key: nome
    if (!validaInputTexto(formData.get('nome'))) {
        $('#nomeTeatro').css("border-color", "red");
        valido = false;
    } else {
        $('#nomeTeatro').css("border", "none");
    }
    
    // key: cidade
    if (!validaInputTexto(formData.get('cidade'))) {
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
