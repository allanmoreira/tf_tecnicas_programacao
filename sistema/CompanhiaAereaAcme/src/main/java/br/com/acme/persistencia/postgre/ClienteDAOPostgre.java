package br.com.acme.persistencia.postgre;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.negocio.dao.ClienteDAO;
import br.com.acme.negocio.modelo.Cliente;
import br.com.acme.persistencia.derby.InicializadorBancoDadosDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOPostgre implements ClienteDAO {

    @Override
    public Cliente selectByCpf(String cpf) throws ClienteDAOException {
        Cliente cli = null;
        String sql = "SELECT id_cliente, nome, rg, cpf, numero_passaporte FROM clientes WHERE cpf = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, cpf);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        cli = new Cliente(
                                resultado.getInt("id_cliente"),
                                resultado.getString("nome"),
                                resultado.getString("rg"),
                                resultado.getString("cpf"),
                                resultado.getString("numero_passaporte")
                        );
                    }
                }
            }
        } catch (ClienteDAOException ex) {
            throw new ClienteDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cli;
    }

    @Override
    public List<Cliente> selectAll() throws ClienteDAOException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nome, rg, cpf, numero_passaporte FROM clientes";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        Cliente cli = new Cliente(
                                resultado.getInt("id_cliente"),
                                resultado.getString("nome"),
                                resultado.getString("rg"),
                                resultado.getString("cpf"),
                                resultado.getString("numero_passaporte")
                        );
                        clientes.add(cli);
                    }
                }
            }
        } catch (ClienteDAOException ex) {
            throw new ClienteDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
}
