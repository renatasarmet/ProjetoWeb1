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
    
    // key: nome
    if (!validaInputTexto(formData.get('nome'))) {
        $('#nomePromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#nomePromocao').css("border", "none");
    }
    
    // key: preço
    if (!validaNaoVazio(formData.get('preco'))) {
        $('#precoPromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#precoPromocao').css("border", "none");
    }
    
    // key: data
    if (!validaNaoVazio(formData.get('data_sessao'))) {
        $('#dataPromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#dataPromocao').css("border", "none");
    }
    
    // key: horario
    if (!validaNaoVazio(formData.get('horario_sessao'))) {
        $('#horarioPromocao').css("border-color", "red");
        valido = false;
    } else {
        $('#horarioPromocao').css("border", "none");
    }

    if (!valido)
        alert("invalido!")
    return(valido);
}
;
