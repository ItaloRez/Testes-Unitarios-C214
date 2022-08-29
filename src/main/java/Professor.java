public class Professor {
    private String nome_do_professor;
    private String horario_de_atendimento;
    private String integral_ou_noturno;

    public Professor(
        String nome_do_professor,
        String horario_de_atendimento,
        String integral_ou_noturno
    ){
        this.nome_do_professor = nome_do_professor;
        this.horario_de_atendimento = horario_de_atendimento;
        this.integral_ou_noturno = integral_ou_noturno;
    }

    public String getNome_do_professor() {
        return nome_do_professor;
    }

    public void setNome_do_professor(String nome_do_professor) {
        this.nome_do_professor = nome_do_professor;
    }

    public String getHorario_de_atendimento() {
        return horario_de_atendimento;
    }

    public void setHorario_de_atendimento(String horario_de_atendimento) {
        this.horario_de_atendimento = horario_de_atendimento;
    }

    public String getIntegral_ou_noturno() {
        return integral_ou_noturno;
    }

    public void setIntegral_ou_noturno(String integral_ou_noturno) {
        this.integral_ou_noturno = integral_ou_noturno;
    }
}
