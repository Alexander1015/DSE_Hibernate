package sv.udb.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import sv.udb.model.Students;

public class MainApp {

	public static void main(String[] args) {
		int opcion = 0;
		Students students;
		EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
		while (opcion != 5) {
			String message = "Elija una opcion:\n"
					+ "1. Crear un nuevo Estudiante\n"
					+ "2. Buscar un Estudiante\n"
					+ "3. Actualizar un Estudiante\n"
					+ "4. Eliminar un Estudiante\n"
					+ "5. Salir";
			opcion = Integer.parseInt(JOptionPane.showInputDialog(message));
			switch (opcion) {
				case 1:
					students = new Students();
					students.setId(null);
					// --
					students.setFirstName(JOptionPane.showInputDialog("Digite el nombre del estudiante"));
					students.setLastName(JOptionPane.showInputDialog("Digite el apellido del estudiante"));
					students.setEmail(JOptionPane.showInputDialog("Digite el correo del estudiante"));
					students.setPhone(Integer.parseInt(JOptionPane.showInputDialog("Digite el telefono del estudiante")));
					students.setCarnet(JOptionPane.showInputDialog("Digite el carnet del estudiante"));
					// --
					JOptionPane.showMessageDialog(null, students);
					entity.getTransaction().begin();
					entity.persist(students);
					// Guarda lo realizado anteriormente
					entity.getTransaction().commit();
					JOptionPane.showMessageDialog(null, "Estudiante registrado...");
					break;
	
				case 2:
					students = new Students();
					students = entity.find(Students.class, Long.parseLong(JOptionPane.showInputDialog("Digite el id del estudiante a buscar")));
					if (students != null) {
						JOptionPane.showMessageDialog(null, students);
					} else {
						message = "Estudiante no encontrado...\nMostrando datos de estudiantes:\n";
						List<Students> listStudents= new ArrayList<>();
						// Esto hace referencia a la clase Students no a la tabla de la BD
						Query query = entity.createQuery("SELECT s FROM Students s"); 
						listStudents = query.getResultList();
						for (Students s : listStudents) {
							message +=  s + "\n";
						}
						JOptionPane.showMessageDialog(null, message);
					}
	
					break;
				case 3:
					students = new Students();
					students = entity.find(Students.class, Long.parseLong(JOptionPane.showInputDialog("Digite el id del producto a actualizar")));
					if (students != null) {
						JOptionPane.showMessageDialog(null, students);
						// --
						students.setFirstName(JOptionPane.showInputDialog("Digite el nombre del estudiante"));
						students.setLastName(JOptionPane.showInputDialog("Digite el apellido del estudiante"));
						students.setEmail(JOptionPane.showInputDialog("Digite el correo del estudiante"));
						students.setPhone(Integer.parseInt(JOptionPane.showInputDialog("Digite el telefono del estudiante")));
						students.setCarnet(JOptionPane.showInputDialog("Digite el carnet del estudiante"));
						// --
						entity.getTransaction().begin();
						entity.merge(students);
						// Guarda lo realizado anteriormente
						entity.getTransaction().commit();
						JOptionPane.showMessageDialog(null, "Estudiante actualizado...");
					} else {
						JOptionPane.showMessageDialog(null, "Estudiante no encontrado...");
					}
					break;
				case 4:
					students = new Students();
					students = entity.find(Students.class, Long.parseLong(JOptionPane.showInputDialog("Digite el id del estudiante a eliminar")));
					if (students != null) {
						JOptionPane.showMessageDialog(null,students);
						entity.getTransaction().begin();
						entity.remove(students);
						// Guarda lo realizado anteriormente
						entity.getTransaction().commit();
						JOptionPane.showMessageDialog(null,"Estudiante eliminado...");
					} else {
						JOptionPane.showMessageDialog(null,"Estudiante no encontrado...");
					}
					break;
				case 5:
					entity.close();
					JPAUtil.shutdown();
				break;
	
				default:
					JOptionPane.showMessageDialog(null,"Opción no válida...");
					break;
			}
		}
	}

}
