
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_asiento').on('click', function (){
        asiento();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        consultaZonaCombo();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    consultaAsientos();
    
});

function consultaZonaCombo() {
    
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
                $("#cmbZona").append('<option value="'+zona[i].id+'">'+zona[i].nombre+'</option>');
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function consultaAsientos() {
    
    var url = 'asientos/consultaAsiento';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (asiento) {
            for (var i = 0; i < asiento.length; i++) {
                agregaLinea(asiento[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function asiento() {
    var accion = $('#accion').val();
    var asiento = {};
    if(accion== 'alta'){
        delete asiento.id;
    }else if(accion== 'editar'){
        asiento.id = $('#asiento_id').val();
    }
    asiento.nombre = $('#nombre').val();
    asiento.zona = {};
    asiento.zona.id = $('#cmbZona').val();
    asiento.fila = $('#fila').val();
    asiento.columna = $('#columna').val();
    
    var url = 'asientos/altaAsiento';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(asiento),
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

function actualizaEditar(asiento){
    var fila = $('#fila_asiento_'+asiento.id);
    fila.empty();
    fila.append( '<td class="text-center"><label id="evento_'+asiento.id+'" class="codigo">'+ asiento.id +'</label></td>'
        + ' <td>'+ asiento.nombre +'</td>'
        + ' <td>'+ asiento.zona.nombre +'</td>'
        + ' <td>'+ asiento.fila +'</td>'
        + ' <td>'+ asiento.columna +'</td>'
        + ' <td><a   id="btnDel_'+asiento.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' <a   id="btnEdit_'+asiento.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td> ');
    
    $('#btnDel_'+asiento.id).click(eliminaAsiento(asiento.id));
    $('#btnEdit_'+asiento.id).click(actualizaAsiento(asiento));

    

}

function limpiarCampos(){
    
    $('#asiento_id').val('');
    $('#nombre').val('');
}

function actualizaAsiento(asiento) {
    return function(){
        consultaZonaCombo();
        $('#asiento_id').val(asiento.id);
        $('#nombre').val(asiento.nombre);
        $('#zona').val(asiento.zona.id);
        $('#fila').val(asiento.fila);
        $('#columna').val(asiento.columna);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(asiento){
    
    $('#tbl_asientos > tbody:last').append( '<tr id="fila_asiento_'+asiento.id+'"> <td class="text-center"><label id="evento_'+asiento.id+'" class="codigo">'+ asiento.id +'</label></td>'
        + ' <td>'+ asiento.nombre +'</td>'
        + ' <td>'+ asiento.zona.nombre +'</td>'
        + ' <td>'+ asiento.fila +'</td>'
        + ' <td>'+ asiento.columna +'</td>'
        + ' <td><a   id="btnDel_'+asiento.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' <a   id="btnEdit_'+asiento.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td> </tr>');
    
    $('#btnDel_'+asiento.id).click(eliminaAsiento(asiento.id));
    $('#btnEdit_'+asiento.id).click(actualizaAsiento(asiento));
    numeroLinea++; 
}

function eliminaAsiento(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'asientos/bajaAsiento'
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            url: url,
            cache: false,
            data: JSON.stringify(id),
            success: function (producto) {
                fila.html(''); 
            },
            error: function () {
                alert('ERROR');
            }
        });
         
    };
}
