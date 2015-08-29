
$(document).ready(function () {
    /* Alta Producto */
    $('#alta_producto').on('click', function (){
        //altaProducto();
        producto('alta');
    });
    
    $('#actualiza_producto').on('click', function (){
        actualizaProducto();
    });
    
});

function altaProducto() {
    var producto = {
        codigoBarras : $('#codigo_barras').val(),
        descripcion: $('#producto_descripcion').val(),
        descripcionCorta: $('#producto_descripcion_corta').val(),
        precioVenta: $('#producto_precio_venta').val(),
        existenciaMinima: $('#existencia_minima').val()
    };
    var url = '../producto/altaProducto';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(producto),
        success: function (producto) {
            alert('Successfull ' +producto.id);
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function producto(accion) {
    var producto = {
        codigoBarras : $('#codigo_barras').val(),
        descripcion: $('#producto_descripcion').val(),
        descripcionCorta: $('#producto_descripcion_corta').val(),
        precioVenta: $('#producto_precio_venta').val(),
        existenciaMinima: $('#existencia_minima').val()
    };
    
    var requestWrapper = {
        producto : producto,
        accion : accion
    }
    var url = '../producto/producto';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(requestWrapper),
        success: function (producto) {
            alert('Successfull ' +producto.id);
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function actualizaProducto() {
    var producto = {
        codigoBarras : $('#codigo_barras').val(),
        descripcion: $('#producto_descripcion').val(),
        descripcionCorta: $('#producto_descripcion_corta').val(),
        precioVenta: $('#producto_precio_venta').val(),
        existenciaMinima: $('#existencia_minima').val()
    };
    var url = '/producto/actualizaProducto';
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(producto),
        success: function (producto) {
            alert('Successfull ' +producto.id);
        },
        error: function () {
            alert('ERROR');
        }
    });
}
