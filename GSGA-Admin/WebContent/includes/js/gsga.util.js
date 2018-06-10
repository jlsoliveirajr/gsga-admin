$(document).ready(function() {
	$("FORM").submit(function(e){
		if(!$(this).hasClass('no-loading')){
			displayBlock();
		}
    });
	$('.linha-resultado').on('click', function(){
		if(!$(this).hasClass('no-loading')){
			displayBlock();
		}
	});
	$('.sidebar-nav-link').on('click', function(){
		displayBlock();
	});	
	
	 $(".somenteNumero").bind("keyup blur focus", function(e) {
         e.preventDefault();
         var expre = /[^\d]/g;
         $(this).val($(this).val().replace(expre,''));
    });
});

function displayBlock(){
	$.blockUI({
				message: '<img class="loading-img" src="/GSGA-Admin/includes/img/circle-loading.gif"/>',
				css : {
					color : '#000',
					border : 'none',
					backgroundColor : 'transparent'
						
				}
			  }); 
}

function unDisplayBlock(){
	$.unblockUI;
}