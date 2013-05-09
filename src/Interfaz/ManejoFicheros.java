package Interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class ManejoFicheros {

	/**
	 * @return String con el path, si no existe nos devolvera "No existe", en
	 *         este caso, obligaremos al usuario cargar una nueva fuente de
	 *         datos
	 * 
	 * 
	 * 
	 */
	public String cargarFConfiguracion() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String path = null;

		try {
			// Apertura del fichero y creacion de BufferedReader
			// para poder
			// hacer una lectura comoda (disponer del metodo
			// readLine()).
			archivo = new File("configuracion");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			String pathValido = null;
			while ((linea = br.readLine()) != null) {
				// Crear variable que vaya aumentando y seleccione cada vez un
				// case distinto

				pathValido = linea;
			}
			System.out.println(pathValido);
			/**
			 * Validar Path
			 */
			if (pathValido == null) {
				System.out.println("Tratar el pathValido = null");
				path = "No existe";
			} else {
				File file2 = new File(pathValido);
				if (file2.isFile()) {
					System.out.println("Es file");
					path = pathValido;
					// Cargar fuente datos
				} else {
					System.out.println("No es file");
					path = "No existe";
					// Cargar nueva fuente de datos
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return path;
	}

	/**
	 * 
	 */
	public void guardarConfiguracionPath(File archivoElegido) {
		/**
		 * Guardar ruta para la proxima vez que abramos el programa
		 */
		File archivo = null;
		FileWriter fr = null;
		PrintWriter pw = null;
		try {
			fr = new FileWriter("configuracion", false);
			pw = new PrintWriter(fr);

			pw.println(archivoElegido.getPath());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fr)
					fr.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public File cargarRuta() {
		File archivoElegido = null;
		// Crear un objeto FileChooser
		JFileChooser fc = new JFileChooser();
		// Mostrar la ventana para abrir archivo y recoger la
		// respuesta
		// En el parámetro del showOpenDialog se indica la ventana
		// al que estará asociado. Con el valor this se asocia a la
		// ventana que la abre.
		int respuesta = fc.showOpenDialog(null);
		// Comprobar si se ha pulsado Aceptar
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			// Crear un objeto File con el archivo elegido
			archivoElegido = fc.getSelectedFile();
			System.out.println(archivoElegido.getPath());

			// Mostrar el nombre del archvivo en un campo de texto
			// archivoElegido.setText(archivoElegido.getName());

		}
		return archivoElegido;
	}
}
