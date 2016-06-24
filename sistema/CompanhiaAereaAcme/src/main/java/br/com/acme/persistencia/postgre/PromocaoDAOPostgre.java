package br.com.acme.persistencia.postgre;

import br.com.acme.exception.PromocaoDAOException;
import br.com.acme.negocio.dao.PromocaoDAO;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.regras.TipoPromocao;
import br.com.acme.persistencia.postgre.InicializadorBancoDadosDataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromocaoDAOPostgre implements PromocaoDAO {

    @Override
    public Promocao selectById(int idPromotion) throws PromocaoDAOException {
        Promocao pro = null;
        String sql = "SELECT id_promocao, descricao, tipo, data_validade FROM promocoes WHERE id_promocao = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idPromotion);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        String tipoPromocaoString = resultado.getString("tipo");
                        TipoPromocao tp = null;
                        
                        if(tipoPromocaoString.equals(TipoPromocao.DESCONTO_VALOR_PASSAGEM.toString())){
                            tp = TipoPromocao.DESCONTO_VALOR_PASSAGEM;
                        }
                        else if(tipoPromocaoString.equals(TipoPromocao.GRATIS.toString())){
                            tp = TipoPromocao.GRATIS;
                        }
                        
                        pro = new Promocao(
                                resultado.getInt("id_promocao"),
                                resultado.getString("descricao"),
                                tp,
                                Date.valueOf(resultado.getString("data_validade"))
                        );
                    }
                }
            }
        } catch (PromocaoDAOException ex) {
            throw new PromocaoDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pro;
    }

    @Override
    public List<Promocao> selectAll() throws PromocaoDAOException {
        List<Promocao> promocoes = new ArrayList<>();
        String sql = "SELECT id_promocao, descricao, tipo, data_validade FROM promocoes";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        String tipoPromocaoString = resultado.getString("tipo");
                        TipoPromocao tp = null;
                        
                        if(tipoPromocaoString.equals(TipoPromocao.DESCONTO_VALOR_PASSAGEM.toString())){
                            tp = TipoPromocao.DESCONTO_VALOR_PASSAGEM;
                        }
                        else if(tipoPromocaoString.equals(TipoPromocao.GRATIS.toString())){
                            tp = TipoPromocao.GRATIS;
                        }
                        
                        Promocao pro = new Promocao(
                                resultado.getInt("id_promocao"),
                                resultado.getString("descricao"),
                                tp,
                                 Date.valueOf(resultado.getString("data_validade"))
                        );
                        promocoes.add(pro);
                    }
                }
            }
        } catch (PromocaoDAOException ex) {
            throw new PromocaoDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return promocoes;
    }
}
