package Heranca;

import Heranca.Empresa.Engenheiro;
import Heranca.Empresa.gerente;

public class executavel {
    public static void main(String[] args) {
        
        Engenheiro eng1 = new Engenheiro(nome:"jota",cpf:123, telefone:123,crea:"123");
        gerente ger1 = new gerente(nome:"Wolverine", cpf:321,Telefone:321);
        System.out.print(eng1);
        
    }


}
