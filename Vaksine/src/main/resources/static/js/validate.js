jQuery(function($){
       $("#cpf").mask("000.000.000-00");
       $("#telefone").mask("(00) 0000-00009");
});
   

$(document).ready(function(){
      	  $("#form").validate({
      		   rules: {
                   nome: {
                   	   required: true,
                       maxlength: 40,
                       minlength: 6
                   },

                   nomeMae: {
                   	   required: true,
                       maxlength: 20,
                       minlength: 5
                   },

                   nomePai: {
                   	   required: true,
                   	   maxlength:40
                   },

                   dataNas: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   },
                   cpf: {
	                   	required: true,
	                   	maxlength: 14

                   },
                   tipoSanguineo: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

	                },
	                email: {
		                   	required: true,
		                   	maxlength: 40,
		                   	minlength: 5,
		                   	email:true
	
	                },
	                telefone: {
		                   	required: true,
		                   	maxlength: 15,
		                   	minlength: 5
	
	                },
	                endereco: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

	                },
                	senha: {
                   	required: true,
                   	maxlength: 15,
                   	minlength: 5

                	}
      		   }
      	   })
      })
      
      //----------------------------------------------------------------------------------------------
      
      
      
     
      $(document).ready(function(){
      	  $("#formPosto").validate({
      		   rules: {
      			 nomedoposto: {
                	   required:true,
                	   minlength:6
                	   
                   },

                   email: {
                   	   required: true,
                       maxlength: 20,
                       email:true,
                       minlength: 5
                   },

                  telefone: {
                   	   required: true,
                   	rangelength:[8,11],
                   	   number:true
                   	   
                   },

                   endereco: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   },

                   codigo: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   },
                   senha: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   },
                   confirmarsenha: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5,
	                   	equalTo: "#senha"

	                }
      		   }
      	   })
      })
      
      //-------------------------------------------------------------------------------------------
      
      
       $(document).ready(function(){
      	  $("#formAgente").validate({
      		   rules: {
                   nome: {
                   	   required: true,
                       maxlength: 40,
                       minlength: 6
                   },

                   cpf: {
                   	   required: true,
                       maxlength: 20,
                       minlength: 5
                   },

                   rg: {
                   	   required: true,
                   	   email: true
                   },

                   dataNascimento: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   },
                   senha: {
	                   	required: true,
	                   	maxlength: 15,
	                   	minlength: 5

                   }
      		   }
      	   })
      })
      
      