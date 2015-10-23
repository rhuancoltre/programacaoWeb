package br.grupointegrado.cadastroProduto.modelo;

import br.grupointegrado.cadastroProduto.util.util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe responsável por realizar a comunicação com os Produtos do banco de
 * dados
 *
 * @author Rhuan Coltre
 */
public class ProdutoDAO {

    // Conexão com o banco de dados criada no ConexãoFiltro
    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * Insere o Produto no Banco de Dados
     *
     * @param produto
     */
    public void inserir(Produto produto) throws SQLException {

        String sql = "INSERT INTO produto "
                + "(descricao, quantidade, valor, fornecedor, ultima_compra)"
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement st = conexao.prepareStatement(sql);
        st.setString(1, produto.getDescricao());
        st.setDouble(2, produto.getQuantidade());
        st.setDouble(3, produto.getValor());
        st.setString(4, produto.getFornecedor());
        st.setDate(5, util.dateParaSQL(produto.getUltimaCompra()));

        st.execute();
        st.close();
    }

    /**
     * Altera os dados do Produto no Banco de Dados
     *
     * @param produto
     */
    public void alterar(Produto produto) throws SQLException {

        /**
         * String sql = "UPDATE produto SET" + " descricao = ?," + " quantidade
         * = ?," + " valor = ?," + " fornecedor = ?," + " ultima_compra = ?
         * WHERE id = ?";
         *
         * PreparedStatement st = conexao.prepareStatement(sql); st.setString(1,
         * produto.getDescricao()); st.setDouble(2, produto.getQuantidade());
         * st.setDouble(3, produto.getValor()); st.setString(4,
         * produto.getFornecedor()); st.setDate(5, new
         * Date(produto.getUltimaCompra().getTime()));
         *
         * st.execute(); st.close
        *
         */
    }

    /**
     * Exclui o produto do banco de dados
     *
     * @param produto
     */
    public void excluir(Produto produto) throws SQLException {

        /**
         * String sql = "DELETE FROM produto where id = ?";
         *
         * PreparedStatement st = conexao.prepareStatement(sql); st.setInt(1,
         * produto.getId());
         *
         * st.execute(); st.close();
        *
         */
    }
}
