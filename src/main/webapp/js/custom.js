 // ejecuta la funcion cuando todo el documento de html DOM este listo y cargado
      $(document).ready(function() {
          // seleccion por id => #example y ejecuta el plugin .DataTable();
          $('#table').DataTable();
      });

function init() {
	console.log('Documento cargado y listo');
	
};

function buscarUsuario(event) {
	 //console.debug(event);
	 const nombre = event.target.value;
	 console.debug(`valor del input ${nombre}`);
	 
	 let elNombreHelp = document.getElementById('nombreHelp');
	 let elLogIn = document.getElementById('logIn');

		const endpointURL ='http://localhost:8080/perfumes/api/usuario?nombre='+nombre;
		console.debug('endpoint %s', endpointURL);
		
				var xhttp = new XMLHttpRequest();
				xhttp.onreadystatechange = function() {
				  if (this.readyState == 4 && this.status == 200) {
		
					console.debug('response esta lista status %s texto %s ', this.status, this.responseText);
					
						elNombreHelp.innerHTML = 'nombre no disponible';
					  	elNombreHelp.classList.add('text-danger');
					  	elNombreHelp.classList.remove('text-success');
						elLogIn.setAttribute('disabled','disabled');
				
					
					}
						if (this.readyState == 4 && this.status == 204) {
						elNombreHelp.innerHTML = 'nombre disponible';
						elNombreHelp.classList.add('text-success');
						elNombreHelp.classList.remove('text-danger');
						elLogIn.removeAttribute('disabled');
					}
						
				 }
			
				xhttp.open("GET", endpointURL, true);
				//ATENCION: esto hace la peticion,
				//pero como es asincrono, debemos programar la respuesta dentro del metodo xhttp.onreadystatechange
				xhttp.send();
				};
				
/**
 * Cambia el tipo de un input para que sea 'text' o 'password'
 * @param idElemnt id del elemento a cambiar
 */
function showHidePass(idElement){

	let elInput = document.getElementById(idElement);	
	elInput.type = ( elInput.type == 'password' ) ? 'text' : 'password';
};
      
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




