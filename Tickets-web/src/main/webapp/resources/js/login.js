/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var login_to_register_btn = 0;
$(document).ready(function () {
    init();
    /* Login */
    $('#login_btn').on('click', function (){
        if(validaCamposLogin()){
            if(loginUsuario()){
                $("#includedLogin").fadeOut();
            }else{
                alert('Datos de accesos incorrectos');
            }
        }
    });
    /* Register */
    $('#register_btn').on('click', function (){
        if(validaRegistroUsuario()){
            registraUsuario();
        }
    });
    
    $('#login_to_register_btn').on('click', function (){
        if(login_to_register_btn === 0){
            $('#divLogin').fadeOut();
            $('#divRegister').fadeIn();
            login_to_register_btn = 1;
        }else{
            $('#divRegister').fadeOut();
            $('#divLogin').fadeIn();
            login_to_register_btn = 0;
        }
    });
});

function init(){
    $('#divRegister').fadeOut();
    $("#validaUsername").fadeOut();
    $("#validaEmail").fadeOut();
    $("#validaPassword").fadeOut();
    $("#validaPassword2").fadeOut();
    $('#register_username').keyup(function (){
        if(validaUsername($(this).val())){
            $("#validaUsername").fadeOut();
            if(validaUsuarioExistente($('#register_username').val())){
                $("#validaUsername").fadeIn();
            }
        }else{
            $("#validaUsername").fadeIn();
        };
    });
    $("#register_email").keyup(function(){
        if(validaEmail($(this).val())){
            $("#validaEmail").fadeOut();
        }else{
            $("#validaEmail").fadeIn();
        };
    });
    $("#register_password").keyup(function(){
        if(validaPassword($(this).val())){
            $("#validaPassword").fadeOut();
        }else{
            $("#validaPassword").fadeIn();
        };
    });
    $("#register_password2").keyup(function(){
        if(validaCamposIguales($('#register_password').val(), $('#register_password2').val())){
            $("#validaPassword2").fadeOut(); 
        }else{
            $("#validaPassword2").fadeIn(); 
        }
    });
}

function loginUsuario() {
    var usuario = {};
    usuario.userName    = $('#login_username').val();
    usuario.password    = hex_md5($('#login_password').val());
    var retorno = false;
    var url = 'usuarios/login';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(usuario),
        async: false,
        success: function (usuario) {
            retorno = usuario;
        }
    });
    return retorno;
}

function registraUsuario() {
    var usuario = {};
    usuario.userName    = $('#register_username').val();
    usuario.password    = hex_md5($('#register_password').val());
    usuario.email       = $('#register_email').val();
    usuario.tipoUsuario = {};    
    usuario.tipoUsuario.id = '1';
    var url = 'usuarios/altaUsuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(usuario),
        success: function (usuario) {
            if(!usuario.error){
                alert("El usuario " +usuario.userName + " se ha insertado correctamente.");
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}
function validaRegistroUsuario(){
    if($('#register_username').val()===null || $('#register_username').val()===''){
        alert('El Nombre de Usuario es obligatorio.');
        return false;
    }
    if(!validaUsername($('#register_username').val())){
        alert('El Formato del Nombre de Usuario es incorrecto.');
        return false;
    }
    if(validaUsuarioExistente($('#register_username').val())){
        alert('El nombre de usuario ya se encuentra registrado.');
        return false;
    }
    if($('#register_email').val()===null || $('#register_email').val()===''){
        alert('El E-mail es obligatorio.');
        return false;
    }
    if(!validaEmail($('#register_email').val())){
        alert('El Formato del E-mail es incorrecto.');
        return false;
    }
    if($('#register_password').val()===null || $('#register_password').val()===''){
        alert('La Contraseña es obligatoria.');
        return false;
    }
    if(!validaPassword($('#register_password').val())){
        alert('El Formato del Password es incorrecto.');
        return false;
    }
    if($('#register_password2').val()===null || $('#register_password2').val()===''){
        alert('Debes de confirmar la contraseña.');
        return false;
    }
    if(!validaCamposIguales($('#register_password').val(), $('#register_password2').val())){
        alert('Los campos de Password no coinciden.');
        return false;
    }
    return true;
}
function validaCamposLogin(){
    if($('#login_username').val()===''){
        alert('Usuario Requerido');
    }else{
        if($('#login_password').val()===''){
            alert('Contraseña Requerida');
        }else{
            return true;
        }
    }
    return false;
}