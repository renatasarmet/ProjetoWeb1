/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaEmail(email) {
    var expReg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return expReg.test(String(email).toLowerCase());
}

function validaNaoVazio(texto) {
    if (texto === '')
        return false;

    return true;
}

function validaInputTexto(texto) {
    return (validaNaoVazio(texto) && (/^[A-Za-z\s]+$/.test(texto)));
}

function validaCNPJ(c) {
    var b = [6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2];

    if ((c = c.replace(/[^\d]/g, "")).length !== 14)
        return false;

    if (/0{14}/.test(c))
        return false;

    for (var i = 0, n = 0; i < 12; n += c[i] * b[++i])
        ;
    if (c[12] !== (((n %= 11) < 2) ? 0 : 11 - n))
        return false;

    for (var i = 0, n = 0; i <= 12; n += c[i] * b[i++])
        ;
    if (c[13] !== (((n %= 11) < 2) ? 0 : 11 - n))
        return false;

    return true;
}
;

function validaURL(url) {
    var re = /^(http[s]?:\/\/){0,1}(www\.){0,1}[a-zA-Z0-9\.\-]+\.[a-zA-Z]{2,5}[\.]{0,1}/;
    if (!re.test(url)) {
        return false;
    }
    return true;
}

var mascaraTelefone = function (val) {
    return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
};
