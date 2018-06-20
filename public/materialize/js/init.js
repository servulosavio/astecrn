(function($){
  $(function(){

    
	$('.modal').modal();
	$('.button-collapse').sideNav();
    $('.parallax').parallax();
    $('select').material_select();
    $(document).ready(function () { 
        var $fone = $("#telefone");
        var $cpf = $("#cpf");
        var $cnpj = $("#cnpj");
        var $cep = $("#cep");
        var $rg = $("#rg");
        var $dtNascimento = $("#dtNascimento");
        var $semestre = $("#semestre");
        var $vencimento = $("#vencimento");
        var $valor = $("#valor");
        
        
        $cpf.mask('000.000.000-00', {reverse: false});
        $cnpj.mask('00.000.000/0000-00', {reverse: false});
        $cep.mask('00000-000', {reverse: false});
        $rg.mask('000.000.000', {reverse: false});
        $fone.mask('(00) 00000-0000', {reverse: false});
        $dtNascimento.mask('00/00/0000', {reverse: false});
        $semestre.mask('0000.0', {reverse: false});
        $vencimento.mask('00/00/0000', {reverse: false});
        $valor.mask('000.000.000.000,00', {reverse: true});
        
        
    });
    
    $('.sidenav').sidenav();
    
    function showToast(message, duration) {
        Materialize.toast(message, duration);
     }
    
    
    
    
    
    
    

    
    

  }); // end of document ready
})(jQuery); // end of jQuery name space