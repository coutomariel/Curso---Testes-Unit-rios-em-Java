package br.ce.wcaquino.servicos;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {

		// Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario();
		usuario.setNome("Mariel Vieira Couto");

		Filme filme = new Filme();
		filme.setNome("O Regresso");
		filme.setPrecoLocacao(5.00);
		filme.setEstoque(1);

		// Ação
		Locacao locacao = service.alugarFilme(usuario, filme);

		// Verificação
		Assert.assertTrue(locacao.getValor() == 5.00);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

	}

}
