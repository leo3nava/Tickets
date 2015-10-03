/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var exprUsername = /^[a-z\d_]{4,15}$/i;
var exprEmail = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
var exprPassword = /(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/;

function validaUsername(valor) {
    if( valor != "" && exprUsername.test(valor)){
        return true;
    }else{
        return false;
    }
}
function validaEmail(valor) {
    if( valor != "" && exprEmail.test(valor)){
        return true;
    }else{
        return false;
    }
}
function validaPassword(valor) {
    if( valor != "" && exprUsername.test(valor)){
        return true;
    }else{
        return false;
    }
}
function validaCamposIguales(valor1, valor2){
    if(valor1===valor2){
        return true;
    }else{
        return false;
    }
}
/**
 * @author  Eduardosco Chavez
 *          DEV SYMPHONY
 * @description Valida si existe registrado Nombre de Usuario.
 * @return {boolean} True: Existe usuario
 * @argument {String} nombreUsuario Usuario a Validar
 */
function validaUsuarioExistente(nombreUsuario){
    var url = 'usuarios/validanombreusuario';
    var retorno = false;
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: nombreUsuario,
        async: false,
        success: function (nombreUsuario) {
            retorno = nombreUsuario;
        }
    });
    return retorno;
}