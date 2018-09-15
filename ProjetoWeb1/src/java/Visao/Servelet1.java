package Visao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Turma;
import modeloDao.ConsultaDAO;

@WebServlet(name = "Servelet1", urlPatterns = {"/Servelet1"})
public class Servelet1 extends HttpServlet {
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
        String [] turmas = request.getParameterValues("turmas");
        ConsultaDAO dao = new ConsultaDAO();
        String aluno = request.getParameter("matricula2");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<meta charset='UTF-8'/>");
            out.println("<head>");
            out.println("<title>Solicitação de Matricula</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"servelet1.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class = 'container'><form class = 'forme'>");
                out.println("<table class = 'tabela1'>\n"
                        + "<caption class = 'nome'>DADOS DO ALUNO</caption>"
                    + "     <tr>\n"
                    + "         <th>Matricula</th>\n"
                    + "	 	<th>Nome da Aluno</th>	\n"
                    + "		<th>Curso</th>\n" 
                    +"</tr>\n");
                Aluno alunos = dao.getAluno(aluno);
                out.println("<tr><td>" + alunos.getMat_aluno()+ "</td>\n"
                        + "     <td>" + alunos.getNome_aluno()+ "</td>	\n"
                        + "	<td>" + alunos.getNome_curso()+ "</td>\n"
                        
                        
                        + "</tr>\n"
                );
            out.println("</table>");
            out.println( "<table class='tabela2'>\n"
                    + "<caption class = 'nome'>TURMAS SELECIONADAS</caption>"
                    + " <tr>\n"
                    + " <th>Codigo da disciplina</th>\n"
                    + " <th>Nome da disciplina</th>	\n"
                    + " <th>Carga horária semanal</th>\n"
                    + "	<th>Código da turma</th>\n"
                    + "	<th>Horários da turma</th>\n"
                    + " </tr>\n");                
            for (int i = 0; i < turmas.length; i++) {
                Turma turma = dao.selecionaTurma(turmas[i]);
                System.out.println(turmas[i]);
                out.println("<tr><td>" + turma.getCod_disc() + "</td>\n"
                        + "     <td>" + turma.getNome_disc() + "</td>	\n"
                        + "	<td>" + turma.getCarga_horaria() + "</td>\n"
                        + "	<td>" + turma.getCod_turma() + "</td>\n"
                        + "	<td>" + turma.formatHorario() + "</td>\n"           
                        + "</tr>\n");
            }
            out.println("</table>");
            out.println("</form></div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
