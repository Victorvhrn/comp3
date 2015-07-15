package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testeAlterarConsumidor.class, testeAlterarRefeicao.class, testeAlterarTicket.class,
		testeCriarConsumidor.class, testeCriarCurso.class, testeCriarDepartamento.class, testeCriarRefeicao.class,
		testeCriarTicket.class, testeListarConsumidor.class, testeListarCurso.class, testeListarDepartamento.class,
		testeListarRefeicao.class, testeListarTicket.class })
public class TodosOsTestesFuncionais {

}
