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
                       maxlength: 40,
                       minlength: 6
                   },

                   nomePai: {
                   	   required: true,
                   	   maxlength:40,
                   	   minlength: 6
                   },

                   dataNas: {
	                   	required: true

                   },
                   cpf: {
	                   	required: true

                   },
                   tipoSanguineo: {
	                   	required: true,
	                   	maxlength: 5,
	                   	minlength: 2

	                },
	                email: {
		                   	required: true,
		                   	maxlength: 50,
		                   	minlength: 5,
		                   	email:true
	
	                },
	                telefone: {
		                   	required: true,
		                   	maxlength: 25,
		                   	minlength: 5
	
	                },
	                endereco: {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 5

	                },
                	senha: {
                   	required: true,
                   	maxlength: 35,
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
                       maxlength: 50,
                       email:true,
                       minlength: 5
                   },

                  telefone: {
                   	   required: true,
                   	   number:true
                   	   
                   },

                   endereco: {
	                   	required: true,
	                   	minlength: 5

                   },

                   codigo: {
	                   	required: true,
	                   	minlength: 5

                   },
                   senha: {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 6

                   },
                   confirmarsenha: {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 6,
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
                       minlength: 5
                   },

                   rg: {
                   	   required: true,
                   	   email: true
                   },

                   dataNascimento: {
	                   	required: true,
	                   	minlength: 5

                   },
                   senha: {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 5

                   },
                   confirmarSenha:{
                	   required: true,
                	   maxlength: 25,
	                   minlength: 5,
                	   equalTo: "#senha"
                   }
      		   }
      	   })
      })
      
      //--------------------------------------------------------------------------------------------
      
          $(document).ready(function(){
      	  $("#formVacina").validate({
      		   rules: {
                   nome: {
                   	   required: true,
                       maxlength: 40,
                       minlength: 6
                   },

                   cpf: {
                   	   required: true,                   
                       minlength: 5
                   }
      		   }
      	   })
      })
      
      