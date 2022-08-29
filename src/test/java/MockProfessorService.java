import java.lang.reflect.Array;
import java.util.ArrayList;

public class MockProfessorService implements ProfessorService{

    @Override
    public String buscaHorarioAtendimento(String nome_do_professor){
        switch(nome_do_professor) {
            case "Renzo":
                return ProfessorConst.RENZO;
            case "Yvo":
                return ProfessorConst.YVO;
            case "Marcelo":
                return ProfessorConst.MARCELO;
            case "Crhistopher":
                return ProfessorConst.CHRISTOPHER;
            default:
                return ProfessorConst.INEXISTENTE;
        }
    }

    @Override
    public ArrayList<String> buscaListaProfessores(){

        ArrayList<String> professores = new ArrayList<String>();
        professores.add("Renzo");
        professores.add("Yvo");
        professores.add("Marcelo");
        professores.add("Christopher");

        return professores;
    }
}
