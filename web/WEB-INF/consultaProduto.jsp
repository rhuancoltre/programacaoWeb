<%-- 
    Document   : consultaProduto
    Created on : 16/10/2015, 20:29:56
    Author     : Rhuan Coltre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Produto</title>
        <style type="text/css">
            #principal { text-align: center }
            body{background-color: #111111;}
            h1 { color: #50FC00; } label { color: #FFFFFF; }
        </style>
    </head>
    <body>
        <div id="principal" >
            <h1>Consulta Produto</h1>

            <button onclick="window.location = 'CadastrarProduto'">Cadastrar </button>
            <%-- <a href="CadastrarProduto"> Cadastrar</a> --- Solicitando por Link--%> 
            <br /><br />

            <form method="GET" action="ConsultaProduto" >
                <label>Descrição:</label>
                <input type="text" name="busca" value="">
                <input type="submit" value="Buscar" >
            </form>
        </div>
    </body>
</html>
