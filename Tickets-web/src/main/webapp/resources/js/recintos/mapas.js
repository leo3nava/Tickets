
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_evento').on('click', function (){
        mapas();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        consultaRecintoCombo();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    consultaMapas();
    
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

function consultaMapas() {
    
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
                agregaLinea(mapa[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function mapas() {
    var accion = $('#accion').val();
    var mapa = {};
    if(accion== 'alta'){
        delete mapa.id;

    }else if(accion== 'editar'){
        mapa.id = $('#mapa_id').val();
    }
    mapa.nombre = $('#nombre').val();
    mapa.recinto = {};
    mapa.recinto.id = $('#cmbRecinto').val();
    
    var url = 'mapas/altaMapa';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(mapa),
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

function actualizaEditar(mapa){
    var fila = $('#fila_evento_'+mapa.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="evento_'+mapa.id+'" class="codigo">'+ mapa.id +'</label></td>'
        + ' <td>'+ mapa.nombre +'</td>'
        + ' <td>'+ mapa.recinto.id +'</td>'
        + ' <td><a   id="btnDel_'+mapa.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+mapa.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    
    $('#btnDel_'+mapa.id).click(eliminaMapa(mapa.id));
    $('#btnEdit_'+mapa.id).click(actualizaMapa(mapa));

    

}

function limpiarCampos(){
    
    $('#mapa_id').val('');
    $('#nombre').val('');
}

function actualizaMapa(mapa) {
    return function(){
        $('#mapa_id').val(mapa.id);
        $('#nombre').val(mapa.nombre);
        $('#recinto').val(mapa.recinto.nombre);
        
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(mapa){

    $('#tbl_mapas > tbody:last').append( '<tr> <td class="text-center"><label id="evento_'+mapa.id+'" class="codigo">'+ mapa.id +'</label></td>'
        + ' <td>'+ mapa.nombre +'</td>'
        + ' <td>'+ mapa.recinto.nombre +'</td>'
        + ' <td><a   id="btnDel_'+mapa.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a>'
        + ' <a   id="btnEdit_'+mapa.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td> </tr>');
    
    $('#btnDel_'+mapa.id).click(eliminaMapa(mapa.id));
    $('#btnEdit_'+mapa.id).click(actualizaMapa(mapa));
    numeroLinea++; 
}

function eliminaMapa(id) {
    return function() { 
        var fila = $(this).closest('tr');  
        var url = 'mapas/bajaEvento'
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
