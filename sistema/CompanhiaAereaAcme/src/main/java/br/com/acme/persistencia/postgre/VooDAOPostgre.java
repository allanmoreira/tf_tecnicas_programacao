package br.com.acme.persistencia.postgre;

import br.com.acme.exception.VooDAOException;
import br.com.acme.negocio.dao.VooDAO;
import br.com.acme.negocio.modelo.Aeronave;
import br.com.acme.negocio.modelo.Aeroporto;
import br.com.acme.negocio.modelo.Chegada;
import br.com.acme.negocio.modelo.LinhaAerea;
import br.com.acme.negocio.modelo.Partida;

import java.util.List;

import br.com.acme.negocio.modelo.Voo;
import br.com.acme.persistencia.derby.InicializadorBancoDadosDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VooDAOPostgre implements VooDAO {

    @Override
    public Voo selectById(int idVoo) throws VooDAOException {
        Voo voo = null;
        String sql = "SELECT \"voos\".\"id_voo\", \"voos\".\"id_linha_aerea_id\", \"voos\".\"id_aeronaves_id\", \"voos\".\"tempo_estimado\", \"voos\".\"id_partida_id\", \n"
                + "\"voos\".\"id_chegada_id\", \"linhas_aereas\".\"id_linha_aerea\", \"linhas_aereas\".\"nome\", \"linhas_aereas\".\"id_alianca_id\", \"aeronaves\".\"id_aeronave\", \n"
                + "\"aeronaves\".\"fabricante\", \"aeronaves\".\"modelo\", \"aeronaves\".\"numero_de_assentos\", \"partidas\".\"id_partida\", \"partidas\".\"data_partida\", \n"
                + "\"partidas\".\"hora_partida\", \"partidas\".\"id_aeroporto_id\", \"aeroportos\".\"id_aeroporto\", \"aeroportos\".\"latitude\", \"aeroportos\".\"longitude\", \n"
                + "\"aeroportos\".\"nome\", \"chegadas\".\"id_chegada\", \"chegadas\".\"data_chegada\", \"chegadas\".\"hora_chegada\", \"chegadas\".\"id_aeroporto_id\", \n"
                + "T7.\"id_aeroporto\", T7.\"latitude\", T7.\"longitude\", T7.\"nome\" \n"
                + "FROM \"voos\" \n"
                + "INNER JOIN \"linhas_aereas\" ON (\"voos\".\"id_linha_aerea_id\" = \"linhas_aereas\".\"id_linha_aerea\") \n"
                + "INNER JOIN \"aeronaves\" ON (\"voos\".\"id_aeronaves_id\" = \"aeronaves\".\"id_aeronave\") \n"
                + "INNER JOIN \"partidas\" ON (\"voos\".\"id_partida_id\" = \"partidas\".\"id_partida\") \n"
                + "INNER JOIN \"aeroportos\" ON (\"partidas\".\"id_aeroporto_id\" = \"aeroportos\".\"id_aeroporto\") \n"
                + "INNER JOIN \"chegadas\" ON (\"voos\".\"id_chegada_id\" = \"chegadas\".\"id_chegada\") \n"
                + "INNER JOIN \"aeroportos\" T7 ON (\"chegadas\".\"id_aeroporto_id\" = T7.\"id_aeroporto\") \n"
                + "WHERE \"voos\".\"id_voo\" = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idVoo);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        Aeronave aeronave = new Aeronave(
                                resultado.getInt(13),
                                resultado.getString(12),
                                resultado.getString(11),
                                resultado.getString(10)
                        );
                        Aeroporto aeroPartida = new Aeroporto(
                                resultado.getString(18),
                                resultado.getString(19),
                                resultado.getString(20),
                                resultado.getString(21)
                        );
                        Aeroporto aeroChegada = new Aeroporto(
                                resultado.getString(26),
                                resultado.getString(27),
                                resultado.getString(28),
                                resultado.getString(29)
                        );

                        Partida partida = new Partida(
                                resultado.getInt(14),
                                resultado.getDate(15),
                                resultado.getString(16),
                                aeroPartida
                        );
                        Chegada chegada = new Chegada(
                                resultado.getInt(22),
                                resultado.getDate(23),
                                resultado.getString(24),
                                aeroChegada);
                        LinhaAerea linhaAerea = new LinhaAerea(
                                resultado.getString(7),
                                resultado.getString(8)
                        );
                        voo = new Voo(
                                resultado.getInt(1),
                                resultado.getInt(4),
                                aeronave,
                                linhaAerea,
                                partida,
                                chegada
                        );
                    }
                }
            }
        } catch (VooDAOException ex) {
            throw new VooDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voo;
    }

    /**
     * Busca os vôos disponíveis para compra de passagem, ou seja, vôos com
     * partida de hoje em diante.
     *
     * @return
     * @throws VooDAOException
     */
    @Override
    public List<Voo> selectAll() throws VooDAOException {
        List<Voo> voos = new ArrayList<>();
        String sql = "SELECT \"voos\".\"id_voo\", \"voos\".\"id_linha_aerea_id\", \"voos\".\"id_aeronaves_id\", \"voos\".\"tempo_estimado\", \"voos\".\"id_partida_id\", \n"
                + "\"voos\".\"id_chegada_id\", \"linhas_aereas\".\"id_linha_aerea\", \"linhas_aereas\".\"nome\", \"linhas_aereas\".\"id_alianca_id\", \"aeronaves\".\"id_aeronave\", \n"
                + "\"aeronaves\".\"fabricante\", \"aeronaves\".\"modelo\", \"aeronaves\".\"numero_de_assentos\", \"partidas\".\"id_partida\", \"partidas\".\"data_partida\", \n"
                + "\"partidas\".\"hora_partida\", \"partidas\".\"id_aeroporto_id\", \"aeroportos\".\"id_aeroporto\", \"aeroportos\".\"latitude\", \"aeroportos\".\"longitude\", \n"
                + "\"aeroportos\".\"nome\", \"chegadas\".\"id_chegada\", \"chegadas\".\"data_chegada\", \"chegadas\".\"hora_chegada\", \"chegadas\".\"id_aeroporto_id\", \n"
                + "T7.\"id_aeroporto\", T7.\"latitude\", T7.\"longitude\", T7.\"nome\" \n"
                + "FROM \"voos\" \n"
                + "INNER JOIN \"linhas_aereas\" ON (\"voos\".\"id_linha_aerea_id\" = \"linhas_aereas\".\"id_linha_aerea\") \n"
                + "INNER JOIN \"aeronaves\" ON (\"voos\".\"id_aeronaves_id\" = \"aeronaves\".\"id_aeronave\") \n"
                + "INNER JOIN \"partidas\" ON (\"voos\".\"id_partida_id\" = \"partidas\".\"id_partida\") \n"
                + "INNER JOIN \"aeroportos\" ON (\"partidas\".\"id_aeroporto_id\" = \"aeroportos\".\"id_aeroporto\") \n"
                + "INNER JOIN \"chegadas\" ON (\"voos\".\"id_chegada_id\" = \"chegadas\".\"id_chegada\") \n"
                + "INNER JOIN \"aeroportos\" T7 ON (\"chegadas\".\"id_aeroporto_id\" = T7.\"id_aeroporto\") \n"
                + "WHERE \"partidas\".\"data_partida\" > now()";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        Aeronave aeronave = new Aeronave(
                                resultado.getInt(13),
                                resultado.getString(12),
                                resultado.getString(11),
                                resultado.getString(10)
                        );
                        Aeroporto aeroPartida = new Aeroporto(
                                resultado.getString(18),
                                resultado.getString(19),
                                resultado.getString(20),
                                resultado.getString(21)
                        );
                        Aeroporto aeroChegada = new Aeroporto(
                                resultado.getString(26),
                                resultado.getString(27),
                                resultado.getString(28),
                                resultado.getString(29)
                        );

                        Partida partida = new Partida(
                                resultado.getInt(14),
                                resultado.getDate(15),
                                resultado.getString(16),
                                aeroPartida
                        );
                        Chegada chegada = new Chegada(
                                resultado.getInt(22),
                                resultado.getDate(23),
                                resultado.getString(24),
                                aeroChegada);
                        LinhaAerea linhaAerea = new LinhaAerea(
                                resultado.getString(7),
                                resultado.getString(8)
                        );
                        Voo voo = new Voo(
                                resultado.getInt(1),
                                resultado.getInt(4),
                                aeronave,
                                linhaAerea,
                                partida,
                                chegada
                        );
                        voos.add(voo);
                    }
                }
            }
        } catch (VooDAOException ex) {
            throw new VooDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return voos;
    }
}
