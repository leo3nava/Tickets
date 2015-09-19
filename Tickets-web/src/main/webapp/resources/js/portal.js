/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $("#includedContent").load("punto_venta.html");
    $('#botonhome').on('click', function (){
        $("#includedContent").load("punto_venta.html", function() {
            initPuntoVenta();
        });
        
    });
    
    $('#botonadmin').on('click', function (){
        $("#includedContent").load("catalogos/producto.html", function() {
            includeJavascript('resources/js/producto.js');
        });
    });
    
    $('#btnUsuario').on('click', function (){
        $("#includedContent").load("catalogos/usuarios.html", function() {
            includeJavascript('resources/js/usuarios.js');
        });
    });
    $('.menuUsuarios').click(function(){ 
        $("#contenedor-principal").load("catalogos/usuarios.html", function() {
            $("#modal").load("catalogos/usuariosModal.html", function() {
                includeJavascript('resources/js/usuarios.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    });
    
    $('.menuTipoUsuario').click(function(){ 
        $("#contenedor-principal").load("catalogos/tipoUsuario.html", function() {
            $("#modal").load("catalogos/tipoUsuarioModal.html", function() {
                includeJavascript('resources/js/catalogos/tipoUsuario.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    $('.menuEventos').click(function(){ 
        $("#contenedor-principal").load("catalogos/eventos.html", function() {
            $("#modal").load("catalogos/eventosModal.html", function() {
                includeJavascript('resources/js/catalogos/eventos.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    $('.menuEventoFechas').click(function(){ 
        $("#contenedor-principal").load("catalogos/eventoFechas.html", function() {
            $("#modal").load("catalogos/eventoFechasModal.html", function() {
                includeJavascript('resources/js/catalogos/eventoFechas.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    $('.menuRecinto').click(function(){ 
        $("#contenedor-principal").load("catalogos/recinto.html", function() {
            $("#modal").load("catalogos/recintoModal.html", function() {
                includeJavascript('resources/js/catalogos/recinto.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
});


function includeJavascript(src) {
    if (document.createElement && document.getElementsByTagName) {
        var head_tag = document.getElementsByTagName('head')[0];
        var script_tag = document.createElement('script');
        script_tag.setAttribute('type', 'text/javascript');
        script_tag.setAttribute('src', src);
        head_tag.appendChild(script_tag);
    }
}