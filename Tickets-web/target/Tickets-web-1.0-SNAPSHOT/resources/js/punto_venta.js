var numeroLinea=1;
$(document).ready(function () {
    
    
    
    
});

function initPuntoVenta(){
    $('#btnAgregaProducto').on("click", function(event){
        agregarItem();
    });
}

function getIdSelections($table) {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}
function agregarItem() {

    var codigoBarras = $('#codigoProducto').val();
    //var numero = $('#numero').val();
    var ventaId = $('#ventaId').val();
    var numero = '1';
    
    var url = '/puntoVenta/agregarItem';
    var data = {
        codigoBarras: codigoBarras, 
        numero: numero,
        ventaId: ventaId
    };
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(data),
        success: function (response) {
            if(!response.error){
                $('#ventaId').val(response.venta.id);
                agregaLinea(response.producto);
            }else{x
                alert(response.errorMsj);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function agregaLinea(producto){
    $('#addr'+numeroLinea).html("<td><label id='id_"+producto.id+"' class='codigo'>"+ producto.id +"</label></td>\n\
                            <td>1</td>\n\
                            <td>"+producto.descripcion+"</td>\n\\n\
                             <td>"+producto.precioVenta+"</td>\n\
                            <td>"+producto.precioVenta+"</td>\n\
                            <td><a   id='btnDel_"+producto.codigoBarras+"' class='delete_row pull-right btn btn-default'>Delete Row</a></td>");

    $('#tab_logic').append('<tr id="addr'+(numeroLinea+1)+'"></tr>');
    
    
    $('#btnDel_'+producto.codigoBarras).click(function(){
        var productoId = $(this).closest('tr').find('.codigo').html();
        var cantidad = $(this).closest('tr').find('.cantidad').html();
        var numero = $(this).closest('tr').find('.numero').html();
        eliminarItem(productoId, numero, cantidad);
        $(this).closest('tr').html('');                            //Elimina la linea de la tabla
         
        
    });
    numeroLinea++; 
}

function eliminarItem(productoId, numero, cantidad) {

    numero = '1';
    cantidad = 1;
    var url = '/puntoVenta/eliminarItem';
    var data = {
        productoId: productoId, 
        numero: numero,
        cantidad: cantidad
    };
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(data),
        success: function (response) {
            if(!response.error){
                //agregaLinea(response.producto);
            }else{
                alert(response.errorMsj);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}

function pagar(productoId, numero, cantidad) {

    numero = '1';
    cantidad = 1;
    var url = '/puntoVenta/eliminarItem';
    var data = {
        productoId: productoId, 
        numero: numero,
        cantidad: cantidad
    };
    $.ajax({
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        cache: false,
        data: JSON.stringify(data),
        success: function (response) {
            if(!response.error){
                //agregaLinea(response.producto);
            }else{
                alert(response.errorMsj);
            }
        },
        error: function () {
            alert('ERROR');
        }
    });
}
