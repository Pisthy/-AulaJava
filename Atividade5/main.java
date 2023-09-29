package Atividade5;
import java.util.Scanner;
//Arthur Alves de Sousa, Jorge Igor Barros Gomes, Marcus Vinícius Costa da Silva, Octávio Leite Neto

import Atividade5.Estoque.banana;
import Atividade5.Estoque.frutasgeral;
import Atividade5.Estoque.laranja;
import Atividade5.Estoque.maca;
import Atividade5.Estoque.maracuja;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         System.out.println("Bem vindo a Portfruit: Maior importadora de frutas do mercado");
        System.out.println("Informe o usuário: ");
        String usuario = scanner.nextLine();
        System.out.println("Informe a senha do usuário: ");
        String senhausuariousuario = scanner.nextLine();
        
        String usuarioCorreto = "admin";
        String senhaCorreto = "admin123@456";
        if (usuario.equals(usuarioCorreto) && senhausuariousuario.equals (senhaCorreto)){
                System.out.println("Login bem-sucedido!");
        } else {
                System.out.println("Usuário ou senha incorretos. Tente novamente.");
                    System.exit(0);
        }


        scanner.close();
        banana b1 = new banana((float) 4.00,"banana",01,70);
        maracuja m1 = new maracuja((float) 6.25,"maracujá",02,400);
        laranja l1 = new laranja("Laranja", 03, 300, (float)2.30);
        maca ma1 = new maca("Maça", 04, 1020, (float)10.30);
        System.out.println(b1);
        System.out.println(m1);
        System.out.println(l1);
        System.out.println(ma1);
    }
}