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
    
    $('.menuMapas').click(function(){ 
        $("#contenedor-principal").load("recintosMap/mapas.html", function() {
            $("#modal").load("recintosMap/mapasModal.html", function() {
                includeJavascript('resources/js/recintos/mapas.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    $('.menuZonas').click(function(){ 
        $("#contenedor-principal").load("recintosMap/zonas.html", function() {
            $("#modal").load("recintosMap/zonasModal.html", function() {
                includeJavascript('resources/js/recintos/zonas.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    $('.menuAsientos').click(function(){ 
        $("#contenedor-principal").load("recintosMap/asientos.html", function() {
            $("#modal").load("recintosMap/asientosModal.html", function() {
                includeJavascript('resources/js/recintos/asientos.js');
            });
        });
        $('#jumbotron').hide();
        return false;
    }); 
    
    consultaPrincipalEventos();
});

function consultaPrincipalEventos() {
    
    var url = 'principal/consultaEventos';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (evento) {
            for (var i = 0; i < evento.length; i++) {
                agregaEvento(evento[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function agregaEvento(evento){            
                          
    for (var i = 0; i < evento.eventoFechas.length; i++) {
        var src = "data:image/jpg;base64," +evento.eventoFechas[i].imagenEvento;
    
        $('#eventos').append( '<div class="post clearfix">'
            + '     <a href="#" class="thumb pull-left">'
            + '         <img class="img-thumbnail" src="'+src+'" alt="">'
            + '     </a>'
            + '     <h2 class="post-title">'
            + '         <a href="#">'+evento.nombre+'</a>'
            + '     </h2>'
            + '     <p><span class="post-fecha">Auditorio Nacional</span></p>'
            + '     <p class="post-contenido text-justify">'
            + '         México, D.F.<br>'
            + '         26 de Diciembre de 2015<br>'
            + '         Gira Alejandro.'
            + '     </p>'
            + '     <div class="contenedor-botones">'
            + '         <a href="#" class="btn btn-primary">Boletos</a>'
            + '         <a href="#" class="btn btn-success">Descripcion</a>'
            + '     </div>'
            + ' </div>');
    }
    
//$('#btnDel_'+evento.id).click(eliminaEvento(evento.id));
//$('#btnEdit_'+evento.id).click(actualizaEvento(evento));
//numeroLinea++; 
}


function includeJavascript(src) {
    if (document.createElement && document.getElementsByTagName) {
        var head_tag = document.getElementsByTagName('head')[0];
        var script_tag = document.createElement('script');
        script_tag.setAttribute('type', 'text/javascript');
        script_tag.setAttribute('src', src);
        head_tag.appendChild(script_tag);
    }
}