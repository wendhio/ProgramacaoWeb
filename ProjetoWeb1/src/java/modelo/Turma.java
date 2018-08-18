package modelo;

public class Turma {
    private String cod_turma;
    private String horario;
    private String cod_disc;
    private String nome_disc;
    private String carga_horaria;

    public String getCod_turma() { return cod_turma;}

    public void setCod_turma(String cod_turma) {
        this.cod_turma = cod_turma;
    }

    public String getHorario() { return horario; }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCod_disc() { return cod_disc;}

    public void setCod_disc(String cod_disc) {
        this.cod_disc = cod_disc;
    }

    public String getNome_disc() { return nome_disc; }

    public void setNome_disc(String nome_disc) {
        this.nome_disc = nome_disc;
    }

    public String getCarga_horaria() { return carga_horaria; }

    public void setCarga_horaria(String carga_horaria) {
        this.carga_horaria = carga_horaria;
    } 
}
