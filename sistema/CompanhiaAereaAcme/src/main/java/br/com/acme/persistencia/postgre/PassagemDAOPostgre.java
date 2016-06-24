package br.com.acme.persistencia.postgre;

import br.com.acme.exception.ClienteDAOException;
import br.com.acme.exception.PassagemDAOException;
import br.com.acme.negocio.dao.PassagemDAO;
import br.com.acme.negocio.modelo.Aeronave;
import br.com.acme.negocio.modelo.Aeroporto;
import br.com.acme.negocio.modelo.Alianca;
import br.com.acme.negocio.modelo.Assento;
import br.com.acme.negocio.modelo.Chegada;
import br.com.acme.negocio.modelo.Cliente;
import br.com.acme.negocio.modelo.LinhaAerea;
import br.com.acme.negocio.modelo.Partida;
import br.com.acme.negocio.modelo.Passagem;
import java.util.List;
import br.com.acme.negocio.modelo.Promocao;
import br.com.acme.negocio.modelo.Voo;
import br.com.acme.negocio.regras.StatusPassagem;
import br.com.acme.persistencia.postgre.InicializadorBancoDadosDataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassagemDAOPostgre implements PassagemDAO {

    @Override
    public void insert(Passagem passagem) throws PassagemDAOException {
        String sql = "INSERT INTO public.passagens(\n"
                + "            status, data_compra, preco_de_compra, id_assento_id, \n"
                + "            id_cliente_id, id_voo_id)\n"
                + "    VALUES ( ?, ?, ?, ?, \n"
                + "            ?, ?)";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, passagem.getStatus().toString());
                comando.setDate(2, passagem.getDataCompra());
                comando.setBigDecimal(3, passagem.getPrecoCompra());
                comando.setInt(4, passagem.getAssento().getIdAssento());
                comando.setInt(5, passagem.getCliente().getIdCliente());
                comando.setInt(6, passagem.getVoo().getIdVoo());
                comando.executeUpdate();
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na inserção. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adiciona o assento escolhido à passagem
     *
     * @param passagem
     * @throws PassagemDAOException
     */
    @Override
    public void updateAssento(Passagem passagem) throws PassagemDAOException {
        String sql = "UPDATE public.passagens\n"
                + "   SET id_passagem=?, status=?, data_compra=?, preco_de_compra=?, id_assento_id=?, \n"
                + "       id_cliente_id=?, id_voo_id=?\n"
                + " WHERE id_passagem = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setString(1, passagem.getStatus().toString());
                comando.setDate(2, passagem.getDataCompra());
                comando.setBigDecimal(3, passagem.getPrecoCompra());
                comando.setInt(4, passagem.getAssento().getIdAssento());
                comando.setInt(5, passagem.getCliente().getIdCliente());
                comando.setInt(6, passagem.getVoo().getIdVoo());
                comando.setInt(7, passagem.getIdPassagem());
                comando.executeUpdate();
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na inserção. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Passagem selectById(int idPassagem) throws PassagemDAOException {
        Passagem pass = null;
        String sql = "SELECT \"passagens\".\"id_passagem\", \"passagens\".\"id_cliente_id\", \"passagens\".\"status\", \"passagens\".\"data_compra\", \"passagens\".\"preco_de_compra\", \n"
                + "\"passagens\".\"promocoes_id\", \"passagens\".\"id_assento_id\", \"passagens\".\"id_voo_id\", \"clientes\".\"id_cliente\", \"clientes\".\"nome\", \"clientes\".\"rg\", \n"
                + "\"clientes\".\"cpf\", \"clientes\".\"numero_passaporte\", \"assentos\".\"id_assento\", \"assentos\".\"id_aeronave_id\", \"assentos\".\"tipo\", \"aeronaves\".\"id_aeronave\", \n"
                + "\"aeronaves\".\"fabricante\", \"aeronaves\".\"modelo\", \"aeronaves\".\"numero_de_assentos\", \"voos\".\"id_voo\", \"voos\".\"id_linha_aerea_id\", \"voos\".\"id_aeronaves_id\", \n"
                + "\"voos\".\"tempo_estimado\", \"voos\".\"id_partida_id\", \"voos\".\"id_chegada_id\", \"linhas_aereas\".\"id_linha_aerea\", \"linhas_aereas\".\"nome\", \n"
                + "\"linhas_aereas\".\"id_alianca_id\", T7.\"id_aeronave\", T7.\"fabricante\", T7.\"modelo\", T7.\"numero_de_assentos\", \"partidas\".\"id_partida\", \n"
                + "\"partidas\".\"data_partida\", \"partidas\".\"hora_partida\", \"partidas\".\"id_aeroporto_id\", \"aeroportos\".\"id_aeroporto\", \"aeroportos\".\"latitude\", \n"
                + "\"aeroportos\".\"longitude\", \"aeroportos\".\"nome\", \"chegadas\".\"id_chegada\", \"chegadas\".\"data_chegada\", \"chegadas\".\"hora_chegada\", \"chegadas\".\"id_aeroporto_id\", \n"
                + "T11.\"id_aeroporto\", T11.\"latitude\", T11.\"longitude\", T11.\"nome\" FROM \"passagens\" \n"
                + "INNER JOIN \"clientes\" ON (\"passagens\".\"id_cliente_id\" = \"clientes\".\"id_cliente\") \n"
                + "INNER JOIN \"assentos\" ON (\"passagens\".\"id_assento_id\" = \"assentos\".\"id_assento\") \n"
                + "INNER JOIN \"aeronaves\" ON (\"assentos\".\"id_aeronave_id\" = \"aeronaves\".\"id_aeronave\") \n"
                + "INNER JOIN \"voos\" ON (\"passagens\".\"id_voo_id\" = \"voos\".\"id_voo\") \n"
                + "INNER JOIN \"linhas_aereas\" ON (\"voos\".\"id_linha_aerea_id\" = \"linhas_aereas\".\"id_linha_aerea\") \n"
                + "INNER JOIN \"aeronaves\" T7 ON (\"voos\".\"id_aeronaves_id\" = T7.\"id_aeronave\") \n"
                + "INNER JOIN \"partidas\" ON (\"voos\".\"id_partida_id\" = \"partidas\".\"id_partida\") \n"
                + "INNER JOIN \"aeroportos\" ON (\"partidas\".\"id_aeroporto_id\" = \"aeroportos\".\"id_aeroporto\") \n"
                + "INNER JOIN \"chegadas\" ON (\"voos\".\"id_chegada_id\" = \"chegadas\".\"id_chegada\") \n"
                + "INNER JOIN \"aeroportos\" T11 ON (\"chegadas\".\"id_aeroporto_id\" = T11.\"id_aeroporto\")\n"
                + " WHERE \"passagens\".\"id_passagem\" = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idPassagem);
                try (ResultSet resultado = comando.executeQuery()) {
                    if (resultado.next()) {
                        PromocaoDAOPostgre p = new PromocaoDAOPostgre();
                        Promocao promocao = p.selectById(resultado.getInt(6));
                        Cliente cliente = new Cliente(
                                resultado.getInt(9),
                                resultado.getString(10),
                                resultado.getString(11),
                                resultado.getString(12),
                                resultado.getString(13)
                        );
                        Aeronave aeronave = new Aeronave(
                                resultado.getInt(20),
                                resultado.getString(19),
                                resultado.getString(18),
                                resultado.getString(17)
                        );
                        Assento assento = new Assento(
                                resultado.getInt(14),
                                resultado.getString(15),
                                true,
                                aeronave
                        );
                        Aeroporto aeroPartida = new Aeroporto(
                                resultado.getString(38),
                                resultado.getString(39),
                                resultado.getString(40),
                                resultado.getString(41)
                        );
                        Aeroporto aeroChegada = new Aeroporto(
                                resultado.getString(46),
                                resultado.getString(47),
                                resultado.getString(48),
                                resultado.getString(49)
                        );

                        Partida partida = new Partida(
                                resultado.getInt(34),
                                resultado.getDate(35),
                                resultado.getString(36),
                                aeroPartida
                        );
                        Chegada chegada = new Chegada(
                                resultado.getInt(42),
                                resultado.getDate(43),
                                resultado.getString(44),
                                aeroChegada);
                        LinhaAerea linhaAerea = new LinhaAerea(
                                resultado.getString(27),
                                resultado.getString(28)
                        );
                        Voo voo = new Voo(
                                resultado.getInt(21),
                                resultado.getInt(24),
                                aeronave,
                                linhaAerea,
                                partida,
                                chegada
                        );
                        StatusPassagem status;
                        String statusSt = resultado.getString(3);
                        if(statusSt.equalsIgnoreCase("Pendente")){
                            status = StatusPassagem.PENDENTE;
                        }else{
                            status = StatusPassagem.UTILIZADA;
                        }

                        pass = new Passagem(
                                resultado.getInt(1),
                                status,
                                resultado.getDate(4),
                                resultado.getBigDecimal(5),
                                promocao,
                                cliente,
                                assento,
                                voo
                        );
                    }
                }
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pass;
    }

    @Override
    public List<Passagem> selectAll() throws PassagemDAOException {
        List<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT \"passagens\".\"id_passagem\", \"passagens\".\"id_cliente_id\", \"passagens\".\"status\", \"passagens\".\"data_compra\", \"passagens\".\"preco_de_compra\", \n"
                + "\"passagens\".\"promocoes_id\", \"passagens\".\"id_assento_id\", \"passagens\".\"id_voo_id\", \"clientes\".\"id_cliente\", \"clientes\".\"nome\", \"clientes\".\"rg\", \n"
                + "\"clientes\".\"cpf\", \"clientes\".\"numero_passaporte\", \"assentos\".\"id_assento\", \"assentos\".\"id_aeronave_id\", \"assentos\".\"tipo\", \"aeronaves\".\"id_aeronave\", \n"
                + "\"aeronaves\".\"fabricante\", \"aeronaves\".\"modelo\", \"aeronaves\".\"numero_de_assentos\", \"voos\".\"id_voo\", \"voos\".\"id_linha_aerea_id\", \"voos\".\"id_aeronaves_id\", \n"
                + "\"voos\".\"tempo_estimado\", \"voos\".\"id_partida_id\", \"voos\".\"id_chegada_id\", \"linhas_aereas\".\"id_linha_aerea\", \"linhas_aereas\".\"nome\", \n"
                + "\"linhas_aereas\".\"id_alianca_id\", T7.\"id_aeronave\", T7.\"fabricante\", T7.\"modelo\", T7.\"numero_de_assentos\", \"partidas\".\"id_partida\", \n"
                + "\"partidas\".\"data_partida\", \"partidas\".\"hora_partida\", \"partidas\".\"id_aeroporto_id\", \"aeroportos\".\"id_aeroporto\", \"aeroportos\".\"latitude\", \n"
                + "\"aeroportos\".\"longitude\", \"aeroportos\".\"nome\", \"chegadas\".\"id_chegada\", \"chegadas\".\"data_chegada\", \"chegadas\".\"hora_chegada\", \"chegadas\".\"id_aeroporto_id\", \n"
                + "T11.\"id_aeroporto\", T11.\"latitude\", T11.\"longitude\", T11.\"nome\" FROM \"passagens\" \n"
                + "INNER JOIN \"clientes\" ON (\"passagens\".\"id_cliente_id\" = \"clientes\".\"id_cliente\") \n"
                + "INNER JOIN \"assentos\" ON (\"passagens\".\"id_assento_id\" = \"assentos\".\"id_assento\") \n"
                + "INNER JOIN \"aeronaves\" ON (\"assentos\".\"id_aeronave_id\" = \"aeronaves\".\"id_aeronave\") \n"
                + "INNER JOIN \"voos\" ON (\"passagens\".\"id_voo_id\" = \"voos\".\"id_voo\") \n"
                + "INNER JOIN \"linhas_aereas\" ON (\"voos\".\"id_linha_aerea_id\" = \"linhas_aereas\".\"id_linha_aerea\") \n"
                + "INNER JOIN \"aeronaves\" T7 ON (\"voos\".\"id_aeronaves_id\" = T7.\"id_aeronave\") \n"
                + "INNER JOIN \"partidas\" ON (\"voos\".\"id_partida_id\" = \"partidas\".\"id_partida\") \n"
                + "INNER JOIN \"aeroportos\" ON (\"partidas\".\"id_aeroporto_id\" = \"aeroportos\".\"id_aeroporto\") \n"
                + "INNER JOIN \"chegadas\" ON (\"voos\".\"id_chegada_id\" = \"chegadas\".\"id_chegada\") \n"
                + "INNER JOIN \"aeroportos\" T11 ON (\"chegadas\".\"id_aeroporto_id\" = T11.\"id_aeroporto\")\n";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        PromocaoDAOPostgre p = new PromocaoDAOPostgre();
                        Promocao promocao = p.selectById(resultado.getInt(6));
                        Cliente cliente = new Cliente(
                                resultado.getInt(9),
                                resultado.getString(10),
                                resultado.getString(11),
                                resultado.getString(12),
                                resultado.getString(13)
                        );
                        Aeronave aeronave = new Aeronave(
                                resultado.getInt(20),
                                resultado.getString(19),
                                resultado.getString(18),
                                resultado.getString(17)
                        );
                        Assento assento = new Assento(
                                resultado.getInt(14),
                                resultado.getString(15),
                                true,
                                aeronave
                        );
                        Aeroporto aeroPartida = new Aeroporto(
                                resultado.getString(38),
                                resultado.getString(39),
                                resultado.getString(40),
                                resultado.getString(41)
                        );
                        Aeroporto aeroChegada = new Aeroporto(
                                resultado.getString(46),
                                resultado.getString(47),
                                resultado.getString(48),
                                resultado.getString(49)
                        );

                        Partida partida = new Partida(
                                resultado.getInt(34),
                                resultado.getDate(35),
                                resultado.getString(36),
                                aeroPartida
                        );
                        Chegada chegada = new Chegada(
                                resultado.getInt(42),
                                resultado.getDate(43),
                                resultado.getString(44),
                                aeroChegada);
                        LinhaAerea linhaAerea = new LinhaAerea(
                                resultado.getString(27),
                                resultado.getString(28)
                        );
                        Voo voo = new Voo(
                                resultado.getInt(21),
                                resultado.getInt(24),
                                aeronave,
                                linhaAerea,
                                partida,
                                chegada
                        );
                        StatusPassagem status;
                        String statusSt = resultado.getString(3);
                        if(statusSt.equalsIgnoreCase("Pendente")){
                            status = StatusPassagem.PENDENTE;
                        }else{
                            status = StatusPassagem.UTILIZADA;
                        }

                        Passagem pass = new Passagem(
                                resultado.getInt(1),
                                status,
                                resultado.getDate(4),
                                resultado.getBigDecimal(5),
                                promocao,
                                cliente,
                                assento,
                                voo
                        );
                        passagens.add(pass);
                    }
                }
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

    /**
     * Cumpre pedido do enunciado, que pede a tela de consulta das passagens.
     *
     * @param idCliente
     * @return
     * @throws PassagemDAOException
     */
    @Override
    public List<Passagem> selectAllByCliente(int idCliente) throws PassagemDAOException {
        List<Passagem> passagens = new ArrayList<>();
        String sql = "SELECT \"passagens\".\"id_passagem\", \"passagens\".\"id_cliente_id\", \"passagens\".\"status\", \"passagens\".\"data_compra\", \"passagens\".\"preco_de_compra\", \n"
                + "\"passagens\".\"promocoes_id\", \"passagens\".\"id_assento_id\", \"passagens\".\"id_voo_id\", \"clientes\".\"id_cliente\", \"clientes\".\"nome\", \"clientes\".\"rg\", \n"
                + "\"clientes\".\"cpf\", \"clientes\".\"numero_passaporte\", \"assentos\".\"id_assento\", \"assentos\".\"id_aeronave_id\", \"assentos\".\"tipo\", \"aeronaves\".\"id_aeronave\", \n"
                + "\"aeronaves\".\"fabricante\", \"aeronaves\".\"modelo\", \"aeronaves\".\"numero_de_assentos\", \"voos\".\"id_voo\", \"voos\".\"id_linha_aerea_id\", \"voos\".\"id_aeronaves_id\", \n"
                + "\"voos\".\"tempo_estimado\", \"voos\".\"id_partida_id\", \"voos\".\"id_chegada_id\", \"linhas_aereas\".\"id_linha_aerea\", \"linhas_aereas\".\"nome\", \n"
                + "\"linhas_aereas\".\"id_alianca_id\", T7.\"id_aeronave\", T7.\"fabricante\", T7.\"modelo\", T7.\"numero_de_assentos\", \"partidas\".\"id_partida\", \n"
                + "\"partidas\".\"data_partida\", \"partidas\".\"hora_partida\", \"partidas\".\"id_aeroporto_id\", \"aeroportos\".\"id_aeroporto\", \"aeroportos\".\"latitude\", \n"
                + "\"aeroportos\".\"longitude\", \"aeroportos\".\"nome\", \"chegadas\".\"id_chegada\", \"chegadas\".\"data_chegada\", \"chegadas\".\"hora_chegada\", \"chegadas\".\"id_aeroporto_id\", \n"
                + "T11.\"id_aeroporto\", T11.\"latitude\", T11.\"longitude\", T11.\"nome\" FROM \"passagens\" \n"
                + "INNER JOIN \"clientes\" ON (\"passagens\".\"id_cliente_id\" = \"clientes\".\"id_cliente\") \n"
                + "INNER JOIN \"assentos\" ON (\"passagens\".\"id_assento_id\" = \"assentos\".\"id_assento\") \n"
                + "INNER JOIN \"aeronaves\" ON (\"assentos\".\"id_aeronave_id\" = \"aeronaves\".\"id_aeronave\") \n"
                + "INNER JOIN \"voos\" ON (\"passagens\".\"id_voo_id\" = \"voos\".\"id_voo\") \n"
                + "INNER JOIN \"linhas_aereas\" ON (\"voos\".\"id_linha_aerea_id\" = \"linhas_aereas\".\"id_linha_aerea\") \n"
                + "INNER JOIN \"aeronaves\" T7 ON (\"voos\".\"id_aeronaves_id\" = T7.\"id_aeronave\") \n"
                + "INNER JOIN \"partidas\" ON (\"voos\".\"id_partida_id\" = \"partidas\".\"id_partida\") \n"
                + "INNER JOIN \"aeroportos\" ON (\"partidas\".\"id_aeroporto_id\" = \"aeroportos\".\"id_aeroporto\") \n"
                + "INNER JOIN \"chegadas\" ON (\"voos\".\"id_chegada_id\" = \"chegadas\".\"id_chegada\") \n"
                + "INNER JOIN \"aeroportos\" T11 ON (\"chegadas\".\"id_aeroporto_id\" = T11.\"id_aeroporto\")\n"
                + " WHERE \"clientes\".\"id_cliente\" = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, idCliente);
                try (ResultSet resultado = comando.executeQuery()) {
                    while (resultado.next()) {
                        PromocaoDAOPostgre p = new PromocaoDAOPostgre();
                        Promocao promocao = p.selectById(resultado.getInt(6));
                        Cliente cliente = new Cliente(
                                resultado.getInt(9),
                                resultado.getString(10),
                                resultado.getString(11),
                                resultado.getString(12),
                                resultado.getString(13)
                        );
                        Aeronave aeronave = new Aeronave(
                                resultado.getInt(20),
                                resultado.getString(19),
                                resultado.getString(18),
                                resultado.getString(17)
                        );
                        Assento assento = new Assento(
                                resultado.getInt(14),
                                resultado.getString(15),
                                true,
                                aeronave
                        );
                        Aeroporto aeroPartida = new Aeroporto(
                                resultado.getString(38),
                                resultado.getString(39),
                                resultado.getString(40),
                                resultado.getString(41)
                        );
                        Aeroporto aeroChegada = new Aeroporto(
                                resultado.getString(46),
                                resultado.getString(47),
                                resultado.getString(48),
                                resultado.getString(49)
                        );

                        Partida partida = new Partida(
                                resultado.getInt(34),
                                resultado.getDate(35),
                                resultado.getString(36),
                                aeroPartida
                        );
                        Chegada chegada = new Chegada(
                                resultado.getInt(42),
                                resultado.getDate(43),
                                resultado.getString(44),
                                aeroChegada);
                        LinhaAerea linhaAerea = new LinhaAerea(
                                resultado.getString(27),
                                resultado.getString(28)
                        );
                        Voo voo = new Voo(
                                resultado.getInt(21),
                                resultado.getInt(24),
                                aeronave,
                                linhaAerea,
                                partida,
                                chegada
                        );
                        StatusPassagem status;
                        String statusSt = resultado.getString(3);
                        if(statusSt.equalsIgnoreCase("Pendente")){
                            status = StatusPassagem.PENDENTE;
                        }else{
                            status = StatusPassagem.UTILIZADA;
                        }

                        Passagem pass = new Passagem(
                                resultado.getInt(1),
                                status,
                                resultado.getDate(4),
                                resultado.getBigDecimal(5),
                                promocao,
                                cliente,
                                assento,
                                voo
                        );
                        passagens.add(pass);
                    }
                }
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na busca. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passagens;
    }

    /**
     * Adiciona a chave estrangeira da promoção na passagem e altera o valor da
     * passagem.
     *
     * @param promocao
     * @param passagem
     * @throws PassagemDAOException
     */
    @Override
    public void adicionarPromocaoAPassagem(Promocao promocao, Passagem passagem) throws PassagemDAOException {
        String sql = "UPDATE public.passagens\n"
                + "   SET promocoes_id=?\n"
                + " WHERE id_passagem = ?";
        try (Connection conexao = InicializadorBancoDadosDataSource.conectarBd()) {
            try (PreparedStatement comando = conexao.prepareStatement(sql)) {
                comando.setInt(1, passagem.getPromocao().getIdPromocao());
                comando.setInt(2, passagem.getIdPassagem());
                comando.executeUpdate();
            }
        } catch (PassagemDAOException ex) {
            throw new PassagemDAOException("Falha na inserção. " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AssentoDAOPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
