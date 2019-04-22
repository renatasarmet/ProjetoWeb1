/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaForm() {
    valido = true;
    formData = new FormData($('form')[0]);
    for (var pair of formData.entries()) {
        console.log("key: " + pair[0] + ", val: " + pair[1]);
    }
    
    if(!validaURL(formData['url'])) {
        $('#cnpjPromocao').css("border-color", "red");
    }
    
    if (!validaCNPJ($('#cnpjPromocao').val())) {
        $('#cnpjPromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#cnpjPromocao').css("border", "none");
    }

    if (!validaInputTexto(formData['nome'])) {
        $('#nomePromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#nomePromocao').css("border", "none");
    }

    if (!validaInputTexto(formData['cidade'])) {
        $('#cidadePromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#cidadePromocao').css("border", "none");
    }
    if (!valido)
        alert("invalido!")
    return(valido);
}
;
