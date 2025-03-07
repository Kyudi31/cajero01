import java.util.InputMismatchException;
import java.util.Scanner;
public class Cajero {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Variables y Constantes
        int Pin = 1234;
        double Saldo = 50000;
        int intentos = 3;
        boolean CuentaBloqueada = false;
        //autenticacion segun intentos 
        while(intentos > 0){
            System.out.println("Ingrese su pin: ");
            try{
                int PinIngresado = scanner.nextInt();
                if(PinIngresado == Pin){
                    System.out.println("Pin Correcto!.");
                    System.out.println("    ");
                    break;
                }
                else{
                    System.out.println("Pin incorrecto te quedan: " + intentos + " intentos.");
                    intentos --;
                } 
            } catch(InputMismatchException e){
                    scanner.nextLine();
                    intentos --;
                    System.out.println("Solo son numeros como pin, te quedan: "+ intentos + " intentos");
            }
        }
        if(intentos == 0){
            CuentaBloqueada = true;
            System.out.println("La tonta 3d cuenta bloqueada...");
            scanner.close();
            return;
         
        }
        int opcion;
        if(CuentaBloqueada == false)
            do{
            System.out.println("Bienvenido a NequiNicole");
            System.out.println("1. consultar chichigua");
            System.out.println("2. retirar money");
            System.out.println("3. Depositar. ");
            System.out.println("4. Cambiar pin. "); //este no se guarda despues del cierre de programa
            System.out.println("5. Open del parche. ");
            System.out.println("Seleccione socio : ");
            opcion = scanner.nextInt();
             //Manejo de opciones 
             switch (opcion) {
                case 1:
                    System.out.println("Ay mario, tenes: $" + Saldo + "lukas");
                    break;
                case 2:
                    System.out.println("Cuanto vas a sacar ome pobre: ");
                    double retiro = 0;
                    boolean Valido = false;                 
                    while(!Valido){
                        try{
                        retiro = scanner.nextDouble(); 
                        Valido = true;
                    } catch (InputMismatchException ex){
                        System.out.println("El numero a retirar tiene que ser un argumento valido...");
                        scanner.nextLine();
                        break;
                    }
                    if(retiro > 0 && retiro <= Saldo){                 
                        Saldo -= retiro; 
                        System.out.println("Se quedo mas pobre mano, tu nuevo saldo es : $" + Saldo);
                        break;
                    }
                    if(retiro > Saldo){
                        System.out.println("Tanta plata no tiene pai, su saldo es: $" + Saldo);
                    }
                    else{
                        System.out.println("¿Y exactamente para que retirar 0?");
                    }
                    }
                    break;
                case 3:

                    System.out.println("¿Cuanta plata va a depositar? : ");
                    try{
                        double Deposito = scanner.nextDouble();
                        if(Deposito > 0){
                            Saldo += Deposito;
                            System.out.println("Eso es todo pai, su nuevo saldo es: $" + Saldo);
                        }
                        else{
                            System.out.println("El deposito no ha sido efectuado debido a que el numero a depositar es 0 o menor que este...");
                        }
                    } catch(InputMismatchException ex){
                        System.out.println("Ingrese argumentos validos para hacer que el deposito sea posible...");
                        scanner.nextLine();
                    }
                    break;
                case 4:
                System.out.print("Ingrese su Pin actual para cambiarlo: ");
                int PinVerificacion;
                try {
                    PinVerificacion = scanner.nextInt();
                    if (PinVerificacion == Pin) {
                        System.out.print("Ingrese su nuevo PIN: ");
                        int NuevoPin = scanner.nextInt();
                        if (NuevoPin >= 1000 && NuevoPin <= 9999 && NuevoPin != Pin) {
                            Pin = NuevoPin;
                            System.out.println("¡PIN cambiado con exito!");
                        } else {
                            System.out.println("El nuevo PIN debe ser distinto al actual y tener 4 digitos.");
                        }
                    } else {
                        System.out.println("PIN incorrecto No se pudo cambiar...");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Solo 4 NUMEROS como pin.");
                    scanner.nextLine();                                 //Profe, ¿como se supone que se puede hacer desde la programacion estructurada que el nuevo pin ingresado reemplace al anterior
                }
                    break;
                case 5:
                System.out.println("Como dijo andrea suerte gonorrea");
                    break;
             }
        } while (opcion!=5);
            scanner.close();

        }
    }