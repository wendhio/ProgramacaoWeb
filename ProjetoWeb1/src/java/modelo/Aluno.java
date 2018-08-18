package modelo;

public class Aluno {
    private String mat_aluno;
    private String nome_aluno;
    private String cod_curso;
    private String nome_curso;

    public String getMat_aluno() {
        return mat_aluno;
    }

    public void setMat_aluno(String mat_aluno) {
        this.mat_aluno = mat_aluno;
    }

    public String getNome_aluno() { return nome_aluno; }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getCod_curso() { return cod_curso; }
    
    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNome_curso() { return nome_curso; }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }
}
