



import java.util.Scanner;

public class Nomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Matriz para 10 empleados y 12 campos
        String[][] empleados = new String[10][12];

        int opcion;
        do {
            System.out.println("\n--- NÓMINA EMPRESA XYZ ---");
            System.out.println("Valores en RD$ - Febrero 2026");
            System.out.println("1. Crear Nómina");
            System.out.println("2. Modificar Registro");
            System.out.println("3. Mostrar Nómina");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    for(int i=0; i<10; i++){
                        System.out.println("\nEmpleado " + (i+1));
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Apellido: ");
                        String apellido = sc.nextLine();
                        System.out.print("Año ingreso: ");
                        String anio = sc.nextLine();
                        System.out.print("Departamento/Puesto: ");
                        String puesto = sc.nextLine();
                        System.out.print("Salario Neto: ");
                        double salario = sc.nextDouble();
                        System.out.print("Préstamo (0 si no aplica): ");
                        double prestamo = sc.nextDouble();
                        sc.nextLine();

                        // Código
                        String codigo = (i+1) + nombre.charAt(0) + "" + apellido.charAt(0) + anio;

                        // Cálculos
                        double sfs = salario * 0.0304;
                        double sfse = salario * 0.0709;
                        double afp = salario * 0.0287;
                        double afpe = salario * 0.0710;
                        double isr = (salario - sfs - afp) * 0.0287; // ejemplo simplificado
                        double totalDesc = sfs + afp + isr + prestamo;
                        double sTotal = salario - totalDesc;

                        // Guardar en matriz
                        empleados[i][0] = codigo;
                        empleados[i][1] = puesto;
                        empleados[i][2] = nombre;
                        empleados[i][3] = apellido;
                        empleados[i][4] = String.valueOf(salario);
                        empleados[i][5] = String.valueOf(prestamo);
                        empleados[i][6] = String.valueOf(sfs);
                        empleados[i][7] = String.valueOf(sfse);
                        empleados[i][8] = String.valueOf(afp);
                        empleados[i][9] = String.valueOf(afpe);
                        empleados[i][10] = String.valueOf(isr);
                        empleados[i][11] = String.valueOf(sTotal);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese número de empleado a modificar (1-10): ");
                    int num = sc.nextInt()-1;
                    sc.nextLine();
                    System.out.print("Nuevo salario: ");
                    double nuevoSalario = sc.nextDouble();
                    sc.nextLine();
                    empleados[num][4] = String.valueOf(nuevoSalario);
                    System.out.println("Registro actualizado.");
                    break;

                case 3:
                    System.out.println("\n--- LISTA DE NÓMINA ---");
                    for(int i=0; i<10; i++){
                        for(int j=0; j<12; j++){
                            System.out.print(empleados[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    break;
            }
        } while(opcion != 4);

        sc.close();
    }
}
