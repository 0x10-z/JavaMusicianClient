LIFELINE de VISUAL PARADIGM
===========================



Quien toque algo del VP que escriba la fecha con su nombre en el mismo formato que el primero. 
Hay que ir añadiendolos uno encima de otro, es decir el siguiente que lo haga justo debajo de este texto. Y si se hace lo de un integrande,
añadir justo al final de la fila hecha un "HECHO". No cuesta nada rellenar esto asi y facilita mucho el trabajo en grupo despues.




19 de marzo de 2013 - Iker:



AÑADIDO:
	
	-Añadido atributo discografia en SuperGrupo y su respectiva funcionalidad en el diagrama de CLASES. Es una lista de Discos.

	-Añadido un atributo esFavorito en Disco y Cancion que guarda el numero de favoritos que tiene. setEsFavorito() aumenta en 1 el atributo.

	-Añadida una clase favorito con listaFavoritosCanciones y listaFavoritosDiscos que tienen un metodo actualizarListaCanciones() y actualizarListaDiscos()
	 que comprueban el atributo esFavorito que contiene el numero de likes que tienen y los ordena por un algoritmo de ordenacion mayor a menor. 


POR HACER:
	-Todos los atributos de SuperGrupo se heredan a Grupo y Solista asi como sus metodos abstractos. Habra que implementarlos independientemente. (AUN NO)

	-Decidir que tipo de lista sera listaIntegrantes de la clase Grupo. (AUN NO)

	-Los metodos setBiografia() y getBiografia() hay que pensar si mantenerlos o dejar solamente anadirHitoBiografia(pHito:string) donde se 
	añade el hito automaticamente a la biografia como lista de string. Creo que mejor lo segundo (Si os parece bien, hacer diagrama de secuencia)

	-Hacer Diagrama de secuencia de setReserva de la clase Reserva.

	-Hacer diagrama de secuencia de busquedaPorGenero(): Disco, busquedaPorTituloDisco(): Disco, busquedaPorTituloCancion(): Cancion, busquedaPorAutor(): Lista<Disco>.

	-Hacer diagrama de secuencia de getDuracion() de Disco que no tiene ningun atributo duracion. Pero si tiene un metodo getDuracion() que nos devuelve
	 el resultado de la suma de la duracion de todas las canciones de la lista tracklist.

