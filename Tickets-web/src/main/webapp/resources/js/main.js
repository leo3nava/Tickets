/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    /*  Signon  */
    $('.login_btn1').on('click', function (e) {
        e.preventDefault();
        $(this).toggleClass('opned');
        $('#login').toggleClass('active');
        $('#signin').toggleClass('inactive');
    });
    $('#register_link').on('click', function (e) {
        e.preventDefault();
        $(this).toggleClass('opned');
        $('#login').toggleClass('active');
        $('#signin').toggleClass('active');
    });
    
    /* Login */
    $('#login_btn2').on('click', function (){
        loginUsuario();
    })
    
    /* Register */
    $('#register_btn').on('click', function (){
        registraUsuario();
    })
});

function loginUsuario() {
    var usuario = {
        nombreUsuario: $('#login_username').val(),
        pass: hex_md5($('#login_password').val())
    };
    var url = '/home/loginusuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(usuario),
        success: function (usuario) {
            alert('Successfull ' +usuario.nombreUsuario);
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function registraUsuario() {
    validaVacio($('#register_password').val(), "Contraseña");
    validaVacio($('#register_password2').val(), "Contraseña");
    validaVacio($('#register_username').val(), "Usuario");
    validaVacio($('#register_email').val(), "Email");
    if ($('#register_password') !== $('#register_password2')) {

    }
    var usuario = {
        nombreUsuario: $('#register_username').val(),
        pass: hex_md5($('#register_password').val()),
        email: $('#register_email').val()
    };
    var url = '/home/registrausuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(usuario),
        success: function (usuario) {
            if(!usuario.error){
                alert("Se inserto producto correctamente: " +usuario.id);
            }else{
                alert(usuario.descripcionCorta);
            }
            
        },
        error: function () {
            alert('ERROR');
        }
    });
}