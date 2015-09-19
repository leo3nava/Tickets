

$(document).ready(function () {
    $('#alta_recinto').on('click', function (){
        recinto();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    consultaRecinto();
    
});

function consultaRecinto() {
    
    var url = 'recinto/consultaRecinto';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (recinto) {
            for (var i = 0; i < recinto.length; i++) {
                agregaLinea(recinto[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function recinto() {
    var accion = $('#accion').val();
    var recinto = {};
    if(accion== 'alta'){
        delete recinto.id;

    }else if(accion== 'editar'){
        recinto.id = $('#evento_id').val();
    }
    //recinto.titularId = $('#titularId').val();
    recinto.nombre = $('#nombre').val();
    recinto.direccion = $('#direccion').val();
    recinto.telefono = $('#telefono').val();
    recinto.ciudadId = $('#ciudadId').val();
    recinto.email = $('#email').val();
    recinto.paginaWeb = $('#paginaWeb').val();
    
    var url = 'recinto/altaRecinto';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(recinto),
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

function actualizaEditar(recinto){
    var fila = $('#fila_evento_'+recinto.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="evento_'+recinto.id+'" class="codigo">'+ recinto.id +'</label></td>'
        + ' <td>'+ recinto.numeroEvento +'</td>'
        + ' <td>'+ recinto.fechaEvento +'</td>'
        + ' <td>'+ recinto.fechaEventoAlterna +'</td>'
        + ' <td>'+ recinto.fechaInicioVenta +'</td>'
        + ' <td>'+ recinto.fechaFinVenta +'</td>'
        + ' <td>'+ recinto.activo +'</td>'
        + ' <td>'+ recinto.fechaFinVenta +'</td>'
        + ' <td>'+ recinto.nombreAlterno +'</td>'
        + ' <td>'+ recinto.descripcion +'</td>'
        + ' <td><a   id="btnDel_'+recinto.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+recinto.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    
    $('#btnDel_'+recinto.id).click(eliminaEvento(recinto.id));
    $('#btnEdit_'+recinto.id).click(actualizaEvento(recinto));

    

}

function limpiarCampos(){
    
    $('#evento_id').val('');
    $('#numeroEvento').val('');
}

function actualizaEvento(recinto) {
    return function(){
        $('#evento_id').val(recinto.id);
        $('#numeroEvento').val(recinto.numeroEvento);
        $('#fechaEvento').val(recinto.fechaEvento);
        $('#fechaEventoAlterna').val(recinto.fechaEventoAlterna);
        $('#fechaFinVenta').val(recinto.fechaFinVenta);
        $('#activo').val(recinto.activo);
        $('#fechaFinVenta').val(recinto.fechaFinVenta);
        $('#nombre_alterno').val(recinto.nombre_alterno);
        $('#descripcion').val(recinto.descripcion);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(recinto){
    $('#exampleModal').modal('hide');
    $('#tbl_recinto > tbody:last').append( '<tr> <td class="text-center"><label id="evento_'+recinto.id+'" class="codigo">'+ recinto.id +'</label></td>'
        + ' <td>'+ recinto.titularId +'</td>'
        + ' <td>'+ recinto.nombre +'</td>'
        + ' <td>'+ recinto.direccion +'</td>'
        + ' <td>'+ recinto.telefono +'</td>'
        + ' <td>'+ recinto.ciudad +'</td>'
        + ' <td>'+ recinto.email +'</td>'
        + ' <td>'+ recinto.paginaWeb +'</td>'
        + ' <td>'
        + '     <a id="btnEdit_'+recinto.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-pencil"></span></a>'
        + '     <a id="btnDel_'+recinto.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' </td></tr> ');
    
    $('#btnDel_'+recinto.id).click(eliminaEvento(recinto.id));
    $('#btnEdit_'+recinto.id).click(actualizaEvento(recinto));
    numeroLinea++; 
}

function eliminaEvento(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'recinto/bajaRecinto'
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
