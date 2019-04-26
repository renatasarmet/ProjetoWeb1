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
        $('#siteEmail').css("border-color", "red")
        valido = false;
    } else {
        $('#siteEmail').css("border", "none");
    }
    
    // key: Senha
    if (!validaNaoVazio(formData.get('senha1Site'))) {
        $('#senha1Site').css("border-color", "red");
        valido = false;
    } else {
        $('#senha1Site').css("border", "none");
    }

    // key: Confirma senha
    if (!validaNaoVazio(formData.get('senha2Site'))) {
        $('#senha2Site').css("border-color", "red");
        valido = false;
    } else {
        $('#senha2Site').css("border", "none");
    }

    // Mudança de senha
    // - Senha antiga
    if (!("senhaAntigaSite" in formData)) {
        if (!validaNaoVazio(formData.get('senhaAntigaSite'))) {
            $('#senhaAntigaSite').css("border-color", "red");
            valido = false;
        } else {
            $('#senhaAntigaSite').css("border", "none");
        }
    }
    
    // verifica se as duas senhas são iguais
    if (formData.get('senha1Site') !== formData.get('senha2Site')) {
        console.log("senhas nao coincidem");
        valido = false;
        alert("Senhas não são iguais");
    }
    
    // key: url
    if (!validaURL(formData.get('url'))) {
        $('#siteURL').css("border-color", "red");
        valido = false;
    } else {
        $('#siteURL').css("border", "none");
    }

    // key: nome
    if (!validaInputTexto(formData.get('nome'))) {
        $('#siteNome').css("border-color", "red");
        valido = false;
    } else {
        $('#siteNome').css("border", "none");
    }

    // key: telefone
    if (!validaNaoVazio(formData.get('telefone'))) {
        $('#siteTelefone').css("border-color", "red");
        valido = false;
    } else {
        $('#siteTelefone').css("border", "none");
    }

    if (!valido)
        alert("invalido!")
    return(valido);
}
;
