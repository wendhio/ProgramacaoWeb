package modeloDao;

import controlador.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Aluno;
import modelo.Turma;


public class ConsultaDAO {
    private Connection con = null;
    public ConsultaDAO(){
        con = ConnectionFactory.getConnection();
    }
    //Buscar se a matricula que o usuario digitou existe no banco de dados.
    public String BuscaMatricula( String mat){
        String matricula = null; 
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT mat_aluno FROM aluno WHERE mat_aluno = '"+mat+"'");
            while(rs.next()){
                matricula = rs.getString("mat_aluno");
            }       
        } catch (SQLException ex) {
            System.out.println("Erro busca aluno!"+ex);
        }
        return matricula; 
    }
    //Busca todas as turmas disponivel no BD para qual o aluno poderá inscrever-se.
    public ArrayList<Turma> buscaTurma(){
        ArrayList<Turma> turmas = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select cod_turma,horario,t.cod_disc,nome_disc,carga_horaria from turma as t inner join disciplina as d on t.cod_disc = d.cod_disc");
            
            while(rs.next()){
                Turma turma = new Turma();
                turma.setCod_turma(rs.getString("cod_turma"));
                turma.setHorario(rs.getString("horario"));
                turma.setCod_disc(rs.getString("cod_disc"));
                turma.setNome_disc(rs.getString("nome_disc"));
                turma.setCarga_horaria(rs.getString("carga_horaria"));
                turmas.add(turma);
            }
            return turmas;
        } catch (SQLException ex) {
            System.out.println("Erro em busca turma" +ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return turmas;
    }
    // Metódo seleciona as turmas para inscrição
    public Turma selecionaTurma(String cod){
        Turma turma = new Turma();
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select cod_turma,horario,t.cod_disc,nome_disc,carga_horaria from turma as t inner join disciplina as d on t.cod_disc = d.cod_disc WHERE t.cod_turma = '"+cod+"'");
            
            while(rs.next()){
                
                turma.setCod_turma(rs.getString("cod_turma"));
                turma.setHorario(rs.getString("horario"));
                turma.setCod_disc(rs.getString("cod_disc"));
                turma.setNome_disc(rs.getString("nome_disc"));
                turma.setCarga_horaria(rs.getString("carga_horaria"));
                
            }
            return turma;
        } catch (SQLException ex) {
            System.out.println("Erro em busca turma" +ex);
        }
        return turma;
    }
    
    public Aluno getAluno(String mat){
        Statement stmt = null;
        ResultSet rs = null;
        Aluno aluno= null;
        try {
            aluno = new Aluno();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT al.mat_aluno, al.nome_aluno, c.nome_curso, c.cod_curso FROM aluno as al inner join curso as c using(cod_curso)WHERE al.mat_aluno ='"+ mat+"'");
            while(rs.next()){
                aluno.setMat_aluno(rs.getString("mat_aluno"));
                aluno.setNome_aluno(rs.getString("nome_aluno"));
                aluno.setCod_curso(rs.getString("cod_curso"));   
                aluno.setNome_curso(rs.getString("nome_curso"));
            }
            return aluno;
        } catch (SQLException ex) {
            System.out.println("Erro aluno!" +ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return aluno;
    }
    
}
