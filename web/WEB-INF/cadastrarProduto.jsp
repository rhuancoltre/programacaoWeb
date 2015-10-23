<%-- 
    Document   : cadastrarProduto
    Created on : 16/10/2015, 20:54:54
    Author     : Rhuan Coltre
--%>



<%@page import="br.grupointegrado.cadastroProduto.modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String mensagemErro = (String) request.getAttribute("mensagem_erro");
    Produto produto = (Produto) request.getAttribute("produto");
    if (produto == null)
        produto = new Produto (0, "", 0, 0, "", null);
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
        <style type="text/css">
            #principal { text-align: center }
            body{background-color: #111;}
            h1 { color: #50FC00; } label { color: #FFFFFF; }
            p { color: #FF0000; }
        </style>
        <script type="text/javascript" language="javascript">
            function validaForm() {
                //validar nome
                d = document.cadastro;
                if (d.descricao.value == "") {
                    alert("O campo " + d.descricao.name + " deve ser preenchido!");
                    d.descricao.focus();
                    return false;
                }
                //validar numeros)
                if (isNaN(d.quantidade.value)) {
                    alert("O campo " + d.quantidade.name + " deve conter apenas numeros!");
                    d.quantidade.focus();
                    return false;
                }

                //validar valor
                if (isNaN(d.valor.value)) {
                    alert("O campo " + d.valor.name + " deve conter apenas numeros!");
                    d.valor.focus();
                    return false;
                }

                //Validar Fornecedor
                if (d.fornecedor.value == "") {
                    alert("O campo " + d.fornecedor.name + " deve ser preenchido!");
                    d.fornecedor.focus();
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div id="principal" >
            <h1>Cadastro de Produtos</h1>
            <% if (mensagemErro != null) {%>
            <p><%= mensagemErro%></p>

            <% } %>


            <form name="cadastro" method="POST" action="CadastrarProduto" onSubmit="return validaForm();"> 
                <input type="hidden" name="id" value="<%= produto.getId() %>"/>
                <label>Descrição:</label>
                <input type="text" name="descricao" value="<%= produto.getDescricao() %>">
                <br />
                <label>Quantidade:</label>
                <input type="text" name="quantidade" value="<%= produto.getQuantidade() %>">
                <br />
                <label>Valor:</label>
                <input type="text" name="valor" value="<%= produto.getValor() %>">
                <br />
                <label>Fornecedor:</label>
                <input type="text" name="fornecedor" value="<%= produto.getFornecedor() %>">
                <br />
                <label>Ultima compra</label>
                <input type="Date" name="ultima_compra" value="<%= produto.getUlimaCompraString()%>">
                <br />

                <input type="submit" value="Salvar" >

            </form>

        </div>
        <a href="ConsultaProduto" > <big>Voltar</big> </a>

    </body>
</html>
