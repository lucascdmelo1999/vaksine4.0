jQuery(function($){
       $("#cpf").mask("000.000.000-00");
       $("#telefone").mask("(00) 00000-0000");
       
       
});
jQuery(function($){

    $("#telefonePosto").mask("(00) 00000-0000");
    $("#rg").mask("00.000.000-0");
    
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
      			 nomePosto: {
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
	                   	maxlength: 25,
	                   	minlength: 5
                   	   
                   },

                   endereco: {
	                   	required: true,
	                   	minlength: 5

                   },

                   codigo: {
	                   	required: true,
	                   	minlength: 5

                   },
                   "perfilUsuarioPosto.senha": {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 6

                   },
                   "perfilUsuarioPosto.senha2": {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 6,
	                   	equalTo: "perfilUsuarioPosto.senha"

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
                   	   required: true
                   },

                   rg: {
                   	   required: true
                   },

                   dataNascimento: {
	                   	required: true,
	                   	date:true,
	                   	minlength: 4

                   },
                   email: {
	                   	required: true,
	                   	minlength: 5,
	                   	email

                  },
                   senha: {
	                   	required: true,
	                   	maxlength: 25,
	                   	minlength: 6

                   },
                   confirmarSenha:{
                	   required: true,
                	   maxlength: 25,
	                   minlength: 6,
                	   equalTo: "#senha"
                   }
      		   }
      	   })
      })
      
      //--------------------------------------------------------------------------------------------
      
          $(document).ready(function(){
      	  $("#formCadastroVacina").validate({
      		   rules: {
                   nome: {
                   	   required: true,
                       maxlength: 40,
                       minlength: 3
                   },

                   "loteVacina.quantidade": {
                   	   required: true,                   
                       minlength: 2
                   },
                   "loteVacina.validade":{
                	   required: true,
                	   date:true
                   },
                   "loteVacina.detalhe":{
                	   required:true,
                	   minlength:10
                   }
      		   }
      	   })
      })
      
      //-------------------------------------------------------------------------------------------------------
      
      $(document).ready(function(){
      	  $("#formPesquisaAgente").validate({
      		   rules: {
      			   email: {
                   	   required: true,
                       email:true
                   }
      		   }
      	   })
      })
      
      //-------------------------------------------------------------------------------------------------------
      
         $(document).ready(function(){
      	  $("#formDeletarVacina").validate({
      		   rules: {
      			   nome: {
                   	   required: true,
                   	   minlength:3
                   }
      		   }
      	   })
         })
      	   
      //-------------------------------------------------------------------------------------------------------
      	   
      	   $(document).ready(function(){
      	  $("#formLoginUsuario").validate({
      		   rules: {
      			   cpf: {
                   	   	required: true,
                   	   	minlength:6
                   },
                   senha:{
                	   	required:true,
                   		cpf:true
                   }
      		   }
      	   })
      })
      
      //-------------------------------------------------------------------------------------------------------
      
      $(document).ready(function(){
      	  $("#formPostoLogin").validate({
      		   rules: {
      			   matricula: {
                   	   	required: true,
                   	   	minlength:6
                   },
                   senha:{
                	   	required:true,
                   		cpf:true
                   }
      		   }
      	   })
      })
      
      //-------------------------------------------------------------------------------------------------------
      
      $(document).ready(function(){
      	  $("#listarVacina").validate({
      		   rules: {
      			   nome: {
                   	   	required: true
                   }
      		   }
      	   })
      })
      
      
      