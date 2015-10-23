package br.grupointegrado.cadastroProduto.filtros;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Rhuan Coltre
 */
public class ConexaoFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        /*
        * Alguns servidores como o TOMCAT vem como padrão ISSO_8859_1.
        */
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        Connection conexao = null;
        try {
             conexao = abrirConexao();
             request.setAttribute("conexao", conexao);
            //Encaminha a requisição a diante
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ex.printStackTrace(); //Imprime no console qual o erro.
            //continua lançando a exceção, para não ignnora-la
            throw new RuntimeException(ex);
        } finally {
            //fecha a conexão, independente de erros
            fecharConexao(conexao);

        }

    }

    /**
     * Abre uma conexão com o banco de dados MySQL
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection abrirConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");                     // Apos add a biblioteca - 1º Criando Conexao com Banco
        String url = "jdbc:mysql://localhost:3306/cadastroProdutos"; //URL inserida como localhost pois está hospedado no PC

        return DriverManager.getConnection(url, "root", "root"); //Conectando no Banco com usuario "root" e senha "root"
    }

    /**
     * Fecha a conexão com o banco de dados MySQL, e ignora possíveis erros
     *
     * @param conn Conexão a ser fechada.
     */
    public void fecharConexao(Connection conn) {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }

}
