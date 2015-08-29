/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function IsEmail(email) {
  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return regex.test(email);
}

function validaVacio(valor, nombreCampo){
    if(valor === ''){
        alert('El campo ' + nombreCampo + ' no puede permanecer vacio.');
        return;
    }
}

function validaCamposIguales(valorCampo1, valorCampo1, nombreCampo1, nombreCampo2){
    
    if (valorCampo1 !== valorCampo1) {

    }
}

