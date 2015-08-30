
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_usuario').on('click', function (){
        usuario();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    $('#actualiza_producto').on('click', function (){
        
        });
    consultaUsuarios();
    
});

function consultaUsuarios() {
    
    var url = '../tipoUsuario/consultaTipoUsuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (usuarios) {
            for (var i = 0; i < usuarios.length; i++) {
                agregaLinea(usuarios[i]);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function usuario() {
    var accion = $('#accion').val();
    var usuario = {};
    if(accion== 'alta'){
        delete usuario.id;
        usuario.nombre = $('#usuario_nombre').val();
    }else if(accion== 'editar'){
        usuario.id = $('#usuario_id').val();
        usuario.nombre = $('#usuario_nombre').val();
    }
    
    var url = '../tipoUsuario/altaTipoUsuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(usuario),
        success: function (usuario) {
            if(accion== 'alta'){
                agregaLinea(usuario);
            }else if(accion== 'editar'){
                actualizaEditar(usuario);
            }
           
            $('#exampleModal').modal('hide');
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function actualizaEditar(usuario){
    var fila = $('#fila_usuario_'+usuario.id);
    fila.empty();
    fila.append('       <td class="text-center"><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    $('#btnDel_'+usuario.id).click(eliminaUsuario(usuario.id));
    $('#btnEdit_'+usuario.id).click(actualizaUsuario(usuario.id, usuario.nombre, usuario.apellido, usuario.userName, usuario.password, usuario.nombreCorto, usuario.tipoUsuarioId));
    

}

function limpiarCampos(){
    
    $('#usuario_id').val('');
    $('#usuario_nombre').val('');
}

function actualizaUsuario(id, nombre, apellido, userName, password, nombreCorto, tipoUsuarioId) {
    return function(){
        $('#usuario_id').val(id);
        $('#usuario_nombre').val(nombre);
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(usuario){
    $('#tbl_usuarios > tbody:last').append( '<tr id="fila_usuario_'+usuario.id+'">'
        + '<td class="hidden-sm hidden-xs text-center"><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-remove"></a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></a></td>'
        + '</tr>');
    
    $('#btnDel_'+usuario.id).click(eliminaUsuario(usuario.id));
    $('#btnEdit_'+usuario.id).click(actualizaUsuario(usuario.id, usuario.nombre, usuario.apellido, usuario.userName, usuario.password, usuario.nombreCorto, usuario.tipoUsuarioId));
    numeroLinea++; 
}

function eliminaUsuario(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = '../tipoUsuario/bajaTipoUsuario'
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
