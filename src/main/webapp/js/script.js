/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function validarFormulario() {
    const nombre = document.getElementById("nombre").value;
    if (nombre.length < 3) {
        alert("El nombre del héroe debe tener al menos 3 letras");
        return false;
    }
    return true;
}

