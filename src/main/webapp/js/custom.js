 // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
      $(document).ready(function() {
          // seleccion por id => #example y ejecuta el plugin .DataTable();
          $('#table').DataTable();
      });
      
      function confirmar(nombre) {
    		
    		// The confirm() method returns true if the user clicked "OK", and false otherwise. 
    		if ( confirm('¿ Estas seguro que quires eliminar ' + nombre + ' ?') ){
    			
    			console.debug(' continua el evento por defceto del ancla ');
    			
    		}else {
    			console.debug(' prevenimos o detenemos el evento del ancla ');
    			event.preventDefault();
    		}
    		
    	};

function cifrar() {
		
		console.log('cifrar y conseguir hash');
		
		//recupero el valor de la contraseña del input a traves de su ID
		var contrasenia = document.getElementById('password').value;		
		
		//consigo el hash mediante la libreria incluida en el pie.jsp
		var hash = md5(contrasenia);
		
		//guardo en el atributo value del input el codigo hash
		document.getElementById('password').value = hash;		
		
		// comprobar si hay que confirmar la contraseña
		var inputRePass = document.getElementById('repassword');
		
		// comprobar que exista el input#repass, si no existe tiene valor undefined
		if ( inputRePass ){                        
			
			var rehash = md5(inputRePass.value);
			inputRePass.value = rehash;
		}	
				
		//enviar formulario
		return true; // si ponemos false no se envia el formulario
		
};