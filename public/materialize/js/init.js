(function($){
  $(function(){

    
	$('.modal').modal();
	$('.button-collapse').sideNav();
    $('.parallax').parallax();
    $('select').material_select();
    $(document).ready(function () { 
        var $fone = $("#telefone");
        var $cpf = $("#cpf");
        var $rg = $("#rg");
        var $dt_nascimento = $("#dt_nascimento")
        
        $cpf.mask('000.000.000-00', {reverse: false});
        $rg.mask('000.000.000', {reverse: false});
        $fone.mask('(00) 00000-0000', {reverse: false});
        $dt_nascimento.mask('00/00/0000', {reverse: false});
    });
    
    $('.sidenav').sidenav();
    
    
    
    
    
    
    

    
    

  }); // end of document ready
})(jQuery); // end of jQuery name space