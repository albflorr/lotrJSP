<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/script.js"></script>
</head>
<body>
    <div class="card">
        <h1>Forja tu Leyenda</h1>
        <form action="generar" method="POST" onsubmit="return validarFormulario()">
            Nombre: <input type="text" id="nombre" name="nombre"><br>
            Raza: 
            <select name="raza">
                <option value="HOBBIT">Hobbit</option>
                <option value="ELFO">Elfo</option>
                <option value="ENANO">Enano</option>
                <option value="HUMANO">Humano</option>
            </select><br>
            <button type="submit">Generar Personaje</button>
        </form>
    </div>

    <h2>H&eacute;roes en la Tierra Media</h2>
    <table border="1">
        <c:forEach var="p" items="${listaPersonajes}">
            <tr>
                <td>${p.nombre}</td>
                <td>${p.tipoRaza}</td>
                <td>${p.habilidadEspecial}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>