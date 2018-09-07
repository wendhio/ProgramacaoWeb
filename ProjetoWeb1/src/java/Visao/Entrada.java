/*
 * @Autor: Wendhio Thalison Neres dos Santos
 * @Matricula: 201600017249
 * @Turma: T02 - Programação para Web
 */
package Visao;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Turma;
import modelo.Aluno;
import modeloDao.ConsultaDAO;
/**
 *
 * @author wendhio
 */
@WebServlet(name = "Entrada", urlPatterns = {"/Entrada"})
public class Entrada extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ConsultaDAO dao = new ConsultaDAO();
        String mat = request.getParameter("matricula");
        String flag = dao.BuscaMatricula(mat);
        //Aluno aluno = dao.getAluno(mat);
        ArrayList<Turma> turma = dao.buscaTurma();
        Aluno aluno = dao.getAluno(mat);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          //  System.out.println(turma.get(1).getHorario());
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Entrada</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"entrada.css\">");
            out.println("</head>");
            out.println("<body>");
            if( flag == null){
                out.println("<script>window.alert(\"Matrícula Errada. Tente Novamente!\");"
                        + "location.href = 'http://localhost:8080/ProjetoWeb1/'"
                        + "</script>");
            }else{
            out.println("<div class = 'container'>");
            out.println("<form action=\"Servelet1\" class = 'forme'>\n"
                    + "<div class = 'nome'> Bem-Vindo,"+aluno.getNome_aluno()+"</div>"
                    + "	<table border = 1>\n"
                    + "     <tr>\n"
                    + "         <th>Codigo da disciplina</th>\n"
                    + "	 	<th>Nome da disciplina</th>	\n"
                    + "		<th>Carga horária semanal</th>\n"
                    + "		<th>Código da turma</th>\n"
                    + "		<th>Horários da turma</th>\n"
                    +"          <th>Selecionar</th> "
                    + "     </tr>\n");                
            for (int i = 0; i < turma.size(); i++) {
                out.println("<tr><td>" + turma.get(i).getCod_disc() + "</td>\n"
                        + "<td>" + turma.get(i).getNome_disc() + "</td>	\n"
                        + "<td>" + turma.get(i).getCarga_horaria() + "</td>\n"
                        + "<td>" + turma.get(i).getCod_turma() + "</td>\n"
                        + "<td>" + turma.get(i).getHorario() + "</td>\n"
                        + "<td><input type=\"checkbox\" name=\"turmas\" value="
                        + turma.get(i).getCod_turma() +">"
                        + "</tr>\n");
            }
            out.println("</table>\n"
                +"<button id=\"botao\" type=\"submit\">Matricular</button>\n"
                +"<input type=\"hidden\" name=\"matricula2\" value="+mat+" />\n"     
                + "</form></div>");         
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. 
    //Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
