$(document).ready(function(){
	$('#btn-salvar').click(function(){
		$('#form-cadastro-parametrizacao').submit();
	});
});

function download(linha){
	$('#form-download-' + linha).submit();
}

function editar(indice){
	window.location.href = '/GSGA-Admin/parametrizacao/editar.do?indiceParametrizacao='+indice;
}

function removerCabecalho(linha){
	window.location.href = '/GSGA-Admin/parametrizacao/removerCabecalho.do?indiceCabecalho='+linha;
}

function removerColuna(linha){
	window.location.href = '/GSGA-Admin/parametrizacao/removerColuna.do?indiceColuna='+linha;
}