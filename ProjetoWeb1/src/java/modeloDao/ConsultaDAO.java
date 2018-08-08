package modeloDao;

import controlador.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Turma;


public class ConsultaDAO {
    private Connection con = null;
    public ConsultaDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public ArrayList<Turma> buscaTurma(){
        ArrayList<Turma> turmas = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from turma");
            
            while(rs.next()){
                Turma turma = new Turma();
                turma.setCod_turma(rs.getString("cod_turma"));
                turma.setHorario(rs.getString("horario"));
                turma.setCod_disc(rs.getString("cod_disc"));
                turma.setNome_disc(rs.getString("nome_disc"));
                turma.setCarga_horaria(rs.getString("carga_horaria"));
                turmas.add(turma);
            }
        } catch (SQLException ex) {
            System.out.println("Erro em turma" +ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turmas;
    }
}
