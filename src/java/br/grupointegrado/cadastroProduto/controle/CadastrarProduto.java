package br.grupointegrado.cadastroProduto.controle;

import br.grupointegrado.cadastroProduto.modelo.Produto;
import br.grupointegrado.cadastroProduto.modelo.ProdutoDAO;
import br.grupointegrado.cadastroProduto.util.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rhuan Coltre
 */
public class CadastrarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/cadastrarProduto.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Recuperando o preenchimento do formulario
        int id = util.stringParaInt(req.getParameter("id"));
        String descricao = req.getParameter("descricao");
        double quantidade = util.stringParaDouble(req.getParameter("quantidade"));
        double valor = util.stringParaDouble(req.getParameter("valor"));
        String fornecedor = req.getParameter("fornecedor");
        Date ultimaCompra = util.stringParaData(req.getParameter("ultima_compra"));

        // Cria uma instancia do produto com os parâmetros do formulario
        Produto produto = new Produto(id, descricao, quantidade, valor, fornecedor, ultimaCompra);

        // Recupera a conexão criada pelo filtro
        Connection conexao = (Connection) req.getAttribute("conexao");

        //Instancia o DAO passando a conexao aberta
        ProdutoDAO dao = new ProdutoDAO(conexao);
        try {
            dao.inserir(produto);
            //Se a inserção ocorrer com sucesso, encaminha para pagina de consulta
            resp.sendRedirect("ConsultaProduto");

        } catch (SQLException ex) {
            ex.printStackTrace();

            //Se ocorrer algum erro, mantem o usuário na pagina de cadastro e mostra mensagem de erro
            String mensagemErro = "Não foi possível inserir o produto no banco de dados.";
            req.setAttribute("mensagem_erro", mensagemErro);
            req.setAttribute("produto", produto);
            req.getRequestDispatcher("/WEB-INF/cadastrarProduto.jsp").forward(req, resp);
        }

    }

}
