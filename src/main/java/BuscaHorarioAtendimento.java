import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class BuscaHorarioAtendimento {

    ProfessorService professorService;

    public BuscaHorarioAtendimento(ProfessorService professorService){
        this.professorService = professorService;
    }

    public Professor buscaHorarioAtendimento(String nome_do_professor){

        String professorJson = professorService.buscaHorarioAtendimento(nome_do_professor);

        JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

        return new Professor(
            jsonObject.get("nome_do_professor").getAsString(),
            jsonObject.get("horario_de_atendimento").getAsString(),
            jsonObject.get("integral_ou_noturno").getAsString()
        );
    }

    public Boolean verificaProfessorNaLista(String nome_do_professor){

        ArrayList<String> professores = professorService.buscaListaProfessores();

        boolean professorNaLista = professores.contains(nome_do_professor);

        return professorNaLista;
    }

    public ArrayList<String> buscaListaProfessores(){

        ArrayList<String> professores = professorService.buscaListaProfessores();

        return professores;
    }
}
