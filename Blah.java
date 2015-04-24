
import java.util.Scanner;
import java.io.*;

class Blah {
    public static void main(String args[]) throws Exception {
        File f;
        Scanner s;
        Interpretador b;
        String linhas[] = new String[2000]; // arquivo pode ter, no máximo, 2000 linhas.

        f = new File(args[0]);
        s = new Scanner(f);

        b = new Interpretador();

        // Lemos todas as linhas do arquivo para dentro do
        // vetor "linhas".
        int i = 0;
        while(s.hasNext()) {    // pegando o numero de linhas
            linhas[i] = s.nextLine();
            i++;
        }
		      // Inicializamos o interpretador com o vetor de linhas. A partir
        // desse ponto, o objeto "b" irá interpretar o código lido do arquivo.
        b.interpreta(linhas);  // chamado o metodo do interpretador com a quantidade de linhas para imprimir.
    }
}
