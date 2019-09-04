package infra;

import domain.Lance;
import domain.Leilao;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LeilaoDao implements RepositorioDeLeiloes {

    private Connection conexao;

    public LeilaoDao() {
        try {
            this.conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost/leilao?useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Calendar data(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    @Override
    public void salva(Leilao leilao) {
        try {
            String sql = "INSERT INTO LEILAO (DESCRICAO, DATA, ENCERRADO) VALUES (?,?,?);";
            PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, leilao.getDescricao());
            ps.setBoolean(3, leilao.isEncerrado());

            ps.execute();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                leilao.setId(generatedKeys.getInt(1));
            }

            for (Lance lance : leilao.getLances()) {
                sql = "INSERT INTO LANCES (LEILAO_ID, USUARIO_ID, VALOR) VALUES (?,?,?);";
                PreparedStatement ps2 = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps2.setInt(1, leilao.getId());
                ps2.setDouble(3, lance.getValor());

                ps2.execute();
                ps2.close();

            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Leilao> encerrados() {
        return null;
    }

    @Override
    public List<Leilao> correntes() {
        return null;
    }

    @Override
    public void atualiza(Leilao leilao) {

    }
}
