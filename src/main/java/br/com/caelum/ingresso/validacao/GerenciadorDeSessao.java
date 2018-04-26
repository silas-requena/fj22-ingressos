package br.com.caelum.ingresso.validacao;

import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		
		LocalTime horarioSessaoExistente = sessaoExistente.getHorario();
		LocalTime horarioSessaoNova = sessaoNova.getHorario();
	
		boolean terminaAntes = sessaoNova.getHorarioTermino().isBefore(horarioSessaoExistente);
		boolean comecaDepois = sessaoExistente.getHorarioTermino().isBefore(horarioSessaoNova);
		
		System.out.println(sessaoExistente.getHorario() + " - " + sessaoExistente.getHorarioTermino());
		System.out.println(sessaoNova.getHorario() + " - " + sessaoNova.getHorarioTermino());
		
		System.out.println("\n \n \n");
		
		if (terminaAntes || comecaDepois) {
			return false;
		}
		return true;
		}

	public boolean cabe(Sessao sessaoNova) {
		
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
	}
}
