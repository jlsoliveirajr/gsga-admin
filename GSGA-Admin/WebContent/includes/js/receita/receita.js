$(document).ready(function(){
	$('#importar').click(function(){
		$('#arquivo').click();
	})
	
	$('#arquivo').change(function(){
		$('#nome-arquivo').val($(this)[0].files[0].name);
		$('#form-importacao-arquivo').submit();
	});
});

function download(linha){
	$('#indiceParametrizacao' + linha).val($('#tipoParametrizacao').val());
	$('#form-download-' + linha).submit();
}