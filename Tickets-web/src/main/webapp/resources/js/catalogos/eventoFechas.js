

$(document).ready(function () {
    /* Alta Producto */
    $('#alta_evento_fechas').on('click', function (){
        eventoFechas();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
        $('.datepicker').datepicker({
        });
    });
    
    $('#actualiza_producto').on('click', function (){
        
        });
    consultaEventoFechas();
    
});

function consultaEventoFechas() {
    
    var url = 'eventoFechas/consultaEventoFechas';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (eventoFechas) {
            for (var i = 0; i < eventoFechas.length; i++) {
                agregaLinea(eventoFechas[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function eventoFechas() {
    var accion = $('#accion').val();
    
    $("#formEventoFechas").ajaxForm({
        success:function(data) { 
            if(accion== 'alta'){
                agregaLinea(data);
            }else if(accion== 'editar'){
                actualizaEditar(data);
            }
           
            
        },
        dataType:"json"
    }).submit();

}

function actualizaEditar(eventoFechas){
    var fila = $('#fila_evento_'+eventoFechas.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="evento_'+eventoFechas.id+'" class="codigo">'+ eventoFechas.id +'</label></td>'
        + ' <td>'+ eventoFechas.numeroEvento +'</td>'
        + ' <td>'+ eventoFechas.fechaEvento +'</td>'
        + ' <td>'+ eventoFechas.fechaEventoAlterna +'</td>'
        + ' <td>'+ eventoFechas.fechaInicioVenta +'</td>'
        + ' <td>'+ eventoFechas.fechaFinVenta +'</td>'
        + ' <td>'+ eventoFechas.activo +'</td>'
        + ' <td>'+ eventoFechas.fechaFinVenta +'</td>'
        + ' <td>'+ eventoFechas.nombreAlterno +'</td>'
        + ' <td>'+ eventoFechas.descripcion +'</td>'
        + ' <td><a   id="btnDel_'+eventoFechas.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+eventoFechas.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    
    $('#btnDel_'+eventoFechas.id).click(eliminaEvento(eventoFechas.id));
    $('#btnEdit_'+eventoFechas.id).click(actualizaEvento(eventoFechas));

    

}

function limpiarCampos(){
    
    $('#evento_id').val('');
    $('#numeroEvento').val('');
}

function actualizaEvento(eventoFechas) {
    return function(){
        $('#evento_id').val(eventoFechas.id);
        $('#numeroEvento').val(eventoFechas.numeroEvento);
        $('#fechaEvento').val(eventoFechas.fechaEvento);
        $('#fechaEventoAlterna').val(eventoFechas.fechaEventoAlterna);
        $('#fechaFinVenta').val(eventoFechas.fechaFinVenta);
        $('#activo').val(eventoFechas.activo);
        $('#fechaFinVenta').val(eventoFechas.fechaFinVenta);
        $('#nombre_alterno').val(eventoFechas.nombre_alterno);
        $('#descripcion').val(eventoFechas.descripcion);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(eventoFechas){
    $('#exampleModal').modal('hide');
    var src = "data:image/jpg;base64," +eventoFechas.imagenEvento;
    $('#tbl_eventoFechas > tbody:last').append( '<tr> <td class="text-center"><label id="evento_'+eventoFechas.id+'" class="codigo">'+ eventoFechas.id +'</label></td>'
        + ' <td>'+ eventoFechas.numeroEvento +'</td>'
        + ' <td>'+ eventoFechas.fechaEvento +'</td>'
        + ' <td>'+ eventoFechas.fechaEventoAlterna +'</td>'
        + ' <td>'+ eventoFechas.fechaFinVenta +'</td>'
        + ' <td>'+ eventoFechas.activo +'</td>'
        + ' <td>'+ eventoFechas.tipoVentasId +'</td>'
        + ' <td><img id="ItemPreview" src="'+src+'" height="42" width="42"/></td>'
        + ' <td>'
        + '     <a id="btnEdit_'+eventoFechas.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-pencil"></span></a>'
        + '     <a id="btnDel_'+eventoFechas.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' </td></tr> ');
    
    $('#btnDel_'+eventoFechas.id).click(eliminaEvento(eventoFechas.id));
    $('#btnEdit_'+eventoFechas.id).click(actualizaEvento(eventoFechas));
    numeroLinea++; 
}

function eliminaEvento(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'eventoFechas/bajaEventoFechas'
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
