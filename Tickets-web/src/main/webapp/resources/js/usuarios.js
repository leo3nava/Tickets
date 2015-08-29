
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_usuario').on('click', function (){
        usuario($('#accion').val());
    });
    
    $('#btnAgregar').on('click',function(){
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    $('#actualiza_producto').on('click', function (){
        
        });
    consultaUsuarios();
    
});

function consultaUsuarios() {
    
    var url = '../usuarios/consultaUsuarios';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        success: function (usuarios) {
            var usuario;
            for (var i = 0; i < usuarios.length; i++) {
                agregaLinea(usuarios[i]);
            }
            $('#tbl_usuarios').DataTable();
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function usuario(accion) {
    var usuario = {};
    if(accion== 'alta'){
        delete usuario.id;
        usuario.nombre = $('#usuario_nombre').val();
        usuario.apellido = $('#usuario_apellido').val();
        usuario.userName = $('#usuario_username').val();
        usuario.password = $('#usuario_password').val();
        usuario.nombreCorto = $('#usuario_nombre_corto').val();
        usuario.tipoUsuarioId = $('#usuario_tipo').val();
    }else if(accion== 'editar'){
        usuario.id = $('#usuario_id').val();
        usuario.nombre = $('#usuario_nombre').val();
        usuario.apellido = $('#usuario_apellido').val();
        usuario.userName = $('#usuario_username').val();
        usuario.password = $('#usuario_password').val();
        usuario.nombreCorto = $('#usuario_nombre_corto').val();
        usuario.tipoUsuarioId = $('#usuario_tipo').val();
    }
    
    var url = '../usuarios/altaUsuario';
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
    $('#usuario_id').val(id);
    var fila = $('#fila_usuario_'+usuario.id);
    fila.empty().append('       <td class="text-center"><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td>'+ usuario.userName +'</td>'
        + ' <td>'+ usuario.nombreCorto +'</td>'
        + ' <td>'+ usuario.tipoUsuarioId +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" class="delete_row pull-right btn btn-default">Eliminar</a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" class="delete_row pull-right btn btn-default">Editar</a></td>');

}

function actualizaUsuario(id, nombre, apellido, userName, password, nombreCorto, tipoUsuarioId) {
    return function(){
        $('#usuario_id').val(id);
        $('#usuario_nombre').val(nombre);
        $('#usuario_apellido').val(apellido);
        $('#usuario_username').val(userName);
        $('#usuario_password').val(password);
        $('#usuario_nombre_corto').val(nombreCorto);
        $('#usuario_tipo').val(tipoUsuarioId);
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(usuario){
    $('#tbl_usuarios > tbody:last').append( '<tr id="fila_usuario_'+usuario.id+'>'
        + '<td class="text-center"><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td>'+ usuario.userName +'</td>'
        + ' <td>'+ usuario.nombreCorto +'</td>'
        + ' <td>'+ usuario.tipoUsuarioId +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" class="delete_row pull-right btn btn-default">Eliminar</a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" class="delete_row pull-right btn btn-default">Editar</a></td>'
        + '</tr>');
    /*
    $('#addr'+numeroLinea).html('<td><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td>'+ usuario.userName +'</td>'
        + ' <td>'+ usuario.nombreCorto +'</td>'
        + ' <td>'+ usuario.tipoUsuarioId +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" class="delete_row pull-right btn btn-default">Eliminar</a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" class="delete_row pull-right btn btn-default">Editar</a></td>');*/

    //$('#tbl_usuarios').append('<tr id="addr'+(numeroLinea+1)+'"></tr>');
    
    $('#btnDel_'+usuario.id).click(eliminaUsuario(usuario.id));
    $('#btnEdit_'+usuario.id).click(actualizaUsuario(usuario.id, usuario.nombre, usuario.apellido, usuario.userName, usuario.password, usuario.nombreCorto, usuario.tipoUsuarioId));
    numeroLinea++; 
}

function eliminaUsuario(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = '../usuarios/bajaUsuario'
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
