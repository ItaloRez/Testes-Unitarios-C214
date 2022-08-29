import java.util.ArrayList;

public interface ProfessorService {
    public String buscaHorarioAtendimento(String nome_do_professor);
    public ArrayList<String> buscaListaProfessores();
}
