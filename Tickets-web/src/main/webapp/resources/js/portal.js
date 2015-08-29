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
        $("#includedContent").load("../catalogos/producto.html", function() {
            includeJavascript('../resources/js/producto.js');
        });
    });
    
    $('#btnUsuario').on('click', function (){
        $("#includedContent").load("../catalogos/usuarios.html", function() {
            includeJavascript('../resources/js/usuarios.js');
        });
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