import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TesteBuscaHorarioAtendimento {

    private ProfessorService service;
    private  BuscaHorarioAtendimento buscaHorarioAtendimento;

    @Before
    public void setUp(){
        service = new MockProfessorService();
        buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);
    }

    @Test
    public void testeBuscaHorarioProfessorRenzo(){
        Professor professor = buscaHorarioAtendimento.buscaHorarioAtendimento("Renzo");

        assertEquals("Renzo", professor.getNome_do_professor());
        assertEquals("10:30 até 12:10", professor.getHorario_de_atendimento());
        assertEquals("integral", professor.getIntegral_ou_noturno());
    }


    @Test
    public void testeBuscaHorarioProfessorInexistente(){
        ProfessorService service = new MockProfessorService();
        BuscaHorarioAtendimento buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);

        Professor professor = buscaHorarioAtendimento.buscaHorarioAtendimento("asdgas");

        assertEquals("Inexistente", professor.getNome_do_professor());
        assertEquals("Inexistente", professor.getHorario_de_atendimento());
        assertEquals("Inexistente", professor.getIntegral_ou_noturno());
    }

    @Test
    public void testeHorarioInicialMenorQueHorarioFinal(){
        ProfessorService service = new MockProfessorService();
        BuscaHorarioAtendimento buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);

        Professor professor = buscaHorarioAtendimento.buscaHorarioAtendimento("Renzo");

        Boolean testeHorario = false;

        Integer horasInicial = Integer.parseInt(professor.getHorario_de_atendimento().substring(0, 2));
        Integer minutosInicial = Integer.parseInt(professor.getHorario_de_atendimento().substring(3, 5));

        Integer horasFinal = Integer.parseInt(professor.getHorario_de_atendimento().substring(10, 12));
        Integer minutosFinal = Integer.parseInt(professor.getHorario_de_atendimento().substring(13, 15));

        if(horasFinal > horasInicial){
            testeHorario = true;
        }else if(horasFinal == horasInicial) {
            if(minutosFinal > minutosInicial){
                testeHorario = true;
            }
        }else {
            testeHorario = false;
        }

        assertTrue(testeHorario);
    }

    @Test
    public void testaProfessorGuaracyNaLista(){
        ProfessorService service = new MockProfessorService();
        BuscaHorarioAtendimento buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);

        Boolean professorNaLista = buscaHorarioAtendimento.verificaProfessorNaLista("Guaracy");

        assertFalse(professorNaLista);
    }

    @Test
    public void testaProfessorMarceloHorarioNoturno(){
        ProfessorService service = new MockProfessorService();
        BuscaHorarioAtendimento buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);

        Professor professor = buscaHorarioAtendimento.buscaHorarioAtendimento("Marcelo");

        assertFalse(professor.getIntegral_ou_noturno().equals("noturno"));
    }

    @Test
    public void testaTodosProfessoresHorarioIntegral(){

        ProfessorService service = new MockProfessorService();
        BuscaHorarioAtendimento buscaHorarioAtendimento = new BuscaHorarioAtendimento(service);

        ArrayList<String> professores = buscaHorarioAtendimento.buscaListaProfessores();

        boolean verificaTodosProfessoresHorarioIntegral = true;

        for(String professor : professores){
            Professor p = buscaHorarioAtendimento.buscaHorarioAtendimento(professor);
            if(p.getIntegral_ou_noturno().equals("noturno")){
                verificaTodosProfessoresHorarioIntegral = false;
            }
        }

        assertFalse(verificaTodosProfessoresHorarioIntegral);

    }


}
