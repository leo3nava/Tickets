
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_zona').on('click', function (){
        zonas();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        consultaMapasCombo();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    consultaZonas();
    
});

function consultaMapasCombo() {
    
    var url = 'mapas/consultaMapa';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (mapa) {
            for (var i = 0; i < mapa.length; i++) {
                $("#cmbMapa").append('<option value="'+mapa[i].id+'">'+mapa[i].nombre+'</option>');
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function consultaZonas() {
    
    var url = 'zonas/consultaZona';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (zona) {
            for (var i = 0; i < zona.length; i++) {
                agregaLinea(zona[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function zonas() {
    var accion = $('#accion').val();
    var zona = {};
    if(accion== 'alta'){
        delete zona.id;

    }else if(accion== 'editar'){
        zona.id = $('#zona_id').val();
    }
    zona.nombre = $('#nombre').val();
    zona.mapa = {};
    zona.mapa.id = $('#cmbMapa').val();
    
    var url = 'zonas/altaZona';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(zona),
        success: function (eventoResponse) {
            if(accion== 'alta'){
                agregaLinea(eventoResponse);
            }else if(accion== 'editar'){
                actualizaEditar(eventoResponse);
            }
           
            $('#exampleModal').modal('hide');
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function actualizaEditar(zona){
    var fila = $('#fila_evento_'+zona.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="evento_'+zona.id+'" class="codigo">'+ zona.id +'</label></td>'
        + ' <td>'+ zona.nombre +'</td>'
        + ' <td>'+ zona.mapa.nombre +'</td>'
        + ' <td><a   id="btnDel_'+zona.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+zona.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    
    $('#btnDel_'+zona.id).click(eliminaZona(zona.id));
    $('#btnEdit_'+zona.id).click(actualizaZona(zona));

    

}

function limpiarCampos(){
    
    $('#zona_id').val('');
    $('#nombre').val('');
}

function actualizaZona(zona) {
    return function(){
        $('#zona_id').val(zona.id);
        $('#nombre').val(zona.nombre);
        $('#cmbMapa').val(zona.mapa.nombre);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(zona){
    
    $('#tbl_zonas > tbody:last').append( '<tr> <td class="text-center"><label id="evento_'+zona.id+'" class="codigo">'+ zona.id +'</label></td>'
        + ' <td>'+ zona.nombre +'</td>'
        + ' <td>'+ zona.mapa.nombre +'</td>'
        + ' <td><a   id="btnDel_'+zona.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' <a   id="btnEdit_'+zona.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td> </tr>');
    
    $('#btnDel_'+zona.id).click(eliminaZona(zona.id));
    $('#btnEdit_'+zona.id).click(actualizaZona(zona));
    numeroLinea++; 
}

function eliminaZona(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'zonas/bajaZona'
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            url: url,
            cache: false,
            data: JSON.stringify(id),
            success: function (zona) {
                fila.html(''); 
            },
            error: function () {
                alert('ERROR');
            }
        });
         
    };
}
