
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_evento').on('click', function (){
        evento();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        consultaRecintoCombo();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    consultaEventos();
    
});

function consultaRecintoCombo() {
    
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
                $("#cmbRecinto").append('<option value="'+recinto[i].id+'">'+recinto[i].nombre+'</option>');
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function consultaEventos() {
    
    var url = 'eventos/consultaEvento';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (evento) {
            for (var i = 0; i < evento.length; i++) {
                agregaLinea(evento[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function evento() {
    var accion = $('#accion').val();
    var evento = {};
    if(accion== 'alta'){
        delete evento.id;

    }else if(accion== 'editar'){
        evento.id = $('#evento_id').val();
    }
    evento.nombre = $('#nombre').val();
    evento.titularId = $('#titular').val();
    evento.recinto = {};
    evento.recinto.id = $('#cmbRecinto').val();
    evento.categoriaId = $('#categoria').val();
    evento.comentario1 = $('#comentario1').val();
    evento.comentario2 = $('#comentario2').val();
    evento.nombreAlterno = $('#nombre_alterno').val();
    evento.descripcion = $('#descripcion').val();
    
    var url = 'eventos/altaEvento';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(evento),
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

function actualizaEditar(evento){
    var fila = $('#fila_evento_'+evento.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="evento_'+evento.id+'" class="codigo">'+ evento.id +'</label></td>'
        + ' <td>'+ evento.nombre +'</td>'
        + ' <td>'+ evento.titularId +'</td>'
        + ' <td>'+ evento.recintoId +'</td>'
        + ' <td>'+ evento.categoriaId +'</td>'
        + ' <td>'+ evento.comentario1 +'</td>'
        + ' <td>'+ evento.comentario2 +'</td>'
        + ' <td>'+ evento.nombreAlterno +'</td>'
        + ' <td>'+ evento.descripcion +'</td>'
        + ' <td><a   id="btnDel_'+evento.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+evento.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    
    $('#btnDel_'+evento.id).click(eliminaEvento(evento.id));
    $('#btnEdit_'+evento.id).click(actualizaEvento(evento));

    

}

function limpiarCampos(){
    
    $('#evento_id').val('');
    $('#nombre').val('');
}

function actualizaEvento(evento) {
    return function(){
        $('#evento_id').val(evento.id);
        $('#nombre').val(evento.nombre);
        $('#titular').val(evento.titular);
        $('#recinto').val(evento.recinto);
        $('#categoria').val(evento.categoria);
        $('#comentario1').val(evento.comentario1);
        $('#comentario2').val(evento.comentario2);
        $('#nombre_alterno').val(evento.nombre_alterno);
        $('#descripcion').val(evento.descripcion);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(evento){
    $.each(evento, function(key, value){
        if($.isArray(evento.value)){
            $.each(value, function(key, value){
                console.log(key, value);
            }); 
        }
        /* $.each(value, function(key, value){
            console.log(key, value);
        });*/
        console.log(key, value);
    });
    
    $('#tbl_eventos > tbody:last').append( '<tr> <td class="text-center"><label id="evento_'+evento.id+'" class="codigo">'+ evento.id +'</label></td>'
        + ' <td>'+ evento.nombre +'</td>'
        + ' <td>'+ evento.titularId +'</td>'
        + ' <td>'+ evento.recinto.nombre +'</td>'
        + ' <td>'+ evento.categoriaId +'</td>'
        + ' <td>'+ evento.comentario1 +'</td>'
        + ' <td>'+ evento.comentario2 +'</td>'
        + ' <td>'+ evento.nombreAlterno +'</td>'
        + ' <td>'+ evento.descripcion +'</td>'
        + ' <td><a   id="btnDel_'+evento.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' <a   id="btnEdit_'+evento.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td> </tr>');
    
    $('#btnDel_'+evento.id).click(eliminaEvento(evento.id));
    $('#btnEdit_'+evento.id).click(actualizaEvento(evento));
    numeroLinea++; 
}

function eliminaEvento(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'eventos/bajaEvento'
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
