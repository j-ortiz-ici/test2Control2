import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }
    public static String getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }
    public static String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
    //Ejecuta el programa
    public static void startProgram(){
        System.out.println("Bienvenido.");
        while (true) {
            showMenu();
            int option = getMenuOption();
            validateMenu(option);
        }
    }
    //Muestra el menú
    public static void showMenu() {
        System.out.println("-------------");
        System.out.println("[1] Mostrar trabajadores.");
        System.out.println("[2] Registrar ingreso.");
        System.out.println("[3] Mostrar licencias.");
        System.out.println("[4] Registrar licencias médicas.");
        System.out.println("[0] Salir (S/N)");
    }
    //Valida el input del usuario
    public static int getMenuOption() {
        while (true) {
            String validacion = "01234";
            String input = getInput("Seleccione una opción:");
            if (validacion.indexOf(input) >= 0) {
                int option = Integer.parseInt(input);
                if (-1 < option && option < 5) {
                    return option;
                }
            }
            else {
                System.out.println("Opción inválida");
            }
        }
    }
    //Switch con las opciones del menú
    public static void validateMenu(int option) {
        switch (option) {
            case 1:
                System.out.println("Mostrando trabajadores");
                System.out.println("");
                break;
            case 2:

                break;
            case 3:
                System.out.println("Mostrando licencias");
                System.out.println("");
                break;
            case 4:

                break;
            case 0:
                salir();
                break;
        }
    }
    public static void salir(){
        String respuesta = getInput("Desea salir del programa? S/N");
        respuesta = respuesta.toLowerCase();
        if(respuesta.contains("s")){
            System.exit(0);
        }
        else if (respuesta.contains("n")){
            System.out.println("");
        }
    }

    public static String[] leerTrabajadores() {
        String textoTrabajadores = "";
        try {
            File archivo = new File("trabajadoresEmpresa.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            textoTrabajadores = br.readLine();
        } catch (Exception e) {
            System.out.println("Documento no disponible, por favor contactar con administrador.");
        }
        String[] trabajadores = textoTrabajadores.split(",");
        //System.out.println(Arrays.toString(trabajadores)); //Imprime lista de trabajadores
        return trabajadores;
    }
}
