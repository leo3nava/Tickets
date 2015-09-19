
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_usuario').on('click', function (){
        usuario();
    });
    
    $('#btnAgregar').on('click',function(){
        limpiarCampos();
        consultaTipoUsuarioCombo();
        $('#exampleModal').modal('show');
        $('#accion').val('alta');
    });
    
    $('#actualiza_producto').on('click', function (){
        
        });
    consultaUsuarios();
    
});

function consultaTipoUsuarioCombo() {
    
    var url = 'tipoUsuario/consultaTipoUsuario';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(),
        async: false,
        success: function (tipoUsuario) {
            for (var i = 0; i < tipoUsuario.length; i++) {
                $("#cmbTipoUsuario").append('<option value="'+tipoUsuario[i].id+'">'+tipoUsuario[i].nombre+'</option>');
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function consultaUsuarios() {
    
    var url = 'usuarios/consultaUsuarios';
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
        //$('#tbl_usuarios').DataTable();
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
    }else if(accion== 'editar'){
        usuario.id = $('#usuario_id').val();
    }
    usuario.nombre = $('#usuario_nombre').val();
    usuario.apellido = $('#usuario_apellido').val();
    usuario.userName = $('#usuario_username').val();
    usuario.password = $('#usuario_password').val();
    usuario.nombreCorto = $('#usuario_nombre_corto').val();
    usuario.tipoUsuario = {};
    usuario.tipoUsuario.id = $('#cmbTipoUsuario').val();
    
    var url = 'usuarios/altaUsuario';
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
        + ' <td>'+ usuario.userName +'</td>'
        + ' <td>'+ usuario.nombreCorto +'</td>'
        + ' <td>'+ usuario.tipoUsuario.nombre +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" href="#" class="text-center"><span class="glyphicon glyphicon-remove"></span></a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></span></a></td>');
    $('#btnDel_'+usuario.id).click(eliminaUsuario(usuario.id));
    $('#btnEdit_'+usuario.id).click(actualizaUsuario(usuario.id, usuario.nombre, usuario.apellido, usuario.userName, usuario.password, usuario.nombreCorto, usuario.tipoUsuarioId));
    

}

function limpiarCampos(){
    
    $('#usuario_id').val('');
    $('#usuario_nombre').val('');
    $('#usuario_apellido').val('');
    $('#usuario_username').val('');
    $('#usuario_password').val('');
    $('#usuario_nombre_corto').val('');
    $('#usuario_tipo').val('');
}

function actualizaUsuario(id, nombre, apellido, userName, password, nombreCorto, tipoUsuarioId) {
    return function(){
        consultaTipoUsuarioCombo();
        $('#usuario_id').val(id);
        $('#usuario_nombre').val(nombre);
        $('#usuario_apellido').val(apellido);
        $('#usuario_username').val(userName);
        $('#usuario_password').val(password);
        $('#usuario_nombre_corto').val(nombreCorto);
        $('#cmbTipoUsuario').val(tipoUsuarioId);
        $('#accion').val('editar');
        $('#exampleModal').modal('show');
    }
}

var numeroLinea=1;
function agregaLinea(usuario){
    $('#tbl_usuarios > tbody:last').append( '<tr id="fila_usuario_'+usuario.id+'">'
        + '<td class="hidden-sm hidden-xs text-center"><label id="usuario_'+usuario.id+'" class="codigo">'+ usuario.id +'</label></td>'
        + ' <td>'+ usuario.nombre +'</td>'
        + ' <td>'+ usuario.userName +'</td>'
        + ' <td>'+ usuario.nombreCorto +'</td>'
        + ' <td >'+ usuario.tipoUsuario.nombre +'</td>'
        + ' <td><a   id="btnDel_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-remove"></a></td>'
        + ' <td><a   id="btnEdit_'+usuario.id+'" href="#"  class="text-center"><span class="glyphicon glyphicon-pencil"></a></td>'
        + '</tr>');
    
    $('#btnDel_'+usuario.id).click(eliminaUsuario(usuario.id));
    $('#btnEdit_'+usuario.id).click(actualizaUsuario(usuario.id, usuario.nombre, usuario.apellido, usuario.userName, usuario.password, usuario.nombreCorto, usuario.tipoUsuario.id));
    numeroLinea++; 
}

function eliminaUsuario(id) {
    return function() {
        var fila = $(this).closest('tr');  
        var url = 'usuarios/bajaUsuario'
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
