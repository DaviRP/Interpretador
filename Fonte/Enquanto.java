//Dalton Luiz Pimmel
//dalton.cco1@gmail.com

// Classe dos laços, recebe as linhas e testas se as condições são verdasdeira ou falsa, e retorna a linha aonde deve -se continuar
// o cidigo. 

class Enquanto{

	Interpretador in;
	private String[] tok, aux;
	private int cont;
	private boolean h = false;
	private int c = 0, ly, r = 0, controle = 0, k;
	LinhaCondicoes[] log = new LinhaCondicoes[1000000]; 
	
	public Enquanto(Interpretador i){
		this.in = i;
	}
	
	public int Enquan(String[] linha, int l){
		
		String rec = " "; // recebe a linha do enquanto
		rec = linha[l].replaceAll("\\s+"," ");
		c = 0;
		int QuantLinhas = l;;
		double e = 0, d = 0; // recebe os valores das condições.
		aux = rec.trim().split(" ");
		ly = l; // recebe a linha atual, onde achou o enqunato, controle do laço.
		
			for(k = l + 1; k < linha.length && linha[k] != null; k++){
				linha[k] = linha[k].replace("\\s+"," ");
				//linha[k] = in.EspacoEmBranco(linha[k]); // passa no laço retirando os espaçoes em branco.
				linha[k] = linha[k].trim();
				QuantLinhas++;
				if(linha[k].length() > 1 && linha[k] != null){	
					tok = linha[k].trim().split(" ");
					if(tok[0].equals("enquanto")) c++;
					if(linha[k].equals("fim enquanto")){
						r = QuantLinhas; // r recebe a linha aonde achou o fim enquanto
						controle++;
						if(c != 0){
							c--;
							continue;
						}
						
						for(int hh = 0; log[hh] != null; hh++){
							if(log[hh].getFim() == r){
								if(log[hh].getInicio() == l)break;
								else in.erro.Erro19(l);
							}
							
						}
						
						break;		
					}
				}
			}
			if(controle == 0) in.erro.Erro19(l);	
			c = 0;
			controle = 0;
			
			if(in.isInt(aux[1]) || in.isDouble(aux[1])) d = Double.parseDouble(aux[1]);		
			else d = in.RetornaValor(aux[1], l);
				
			if(in.TestaString(aux[3])) e = Double.parseDouble(aux[3]);		
			else e = in.RetornaValor(aux[3], l);
		
			boolean t = in.log.Log(aux, d, e);
			int gg;
			for(gg = 0; gg < log.length; gg++){
				if(log[gg] == null){
					log[gg] = new LinhaCondicoes(l, r, t);
					break;
			}
			
				
				
		}	
				if(t) return ly;
				return r;				
	}

	// quando achou o fim enquanto, o metodo fim recebe a linha, e verifica a posicao que tem que é igual a que recebeu de parametro, e verifica se é verdadeiro ou falso,e retorna aonde deve continuar.
	public int Fim(int con){
		for(int i = 0; i < log.length && log[i] != null; i++){
			if(con == log[i].getFim()){
				if(log[i].getVer()) return log[i].getInicio() - 1;
				return (log[i].getFim());
			}
		}
		in.erro.Erro19(con);
		return 0;
	}
	// Metodo da Função Break
	public int Break(int cont, String[] l){
		int n = cont;
		for(int o = cont + 1; o < l.length; o++){	
			if(l[o].length() > 0 && l[o] != null){
				n++;  // recebe o primeiro fim enquanto
				l[o] = l[o].replaceAll("\\s+"," ");
				l[o] = l[o].trim();
				if(l[o].equals("fim enquanto")) break;
			}
		}
		for(int i = 0; log[i] != null; i++){
			if(log[i].getFim() == n) return log[i].getFim();
		}
		return 0;
	}
	
	public int Continue(){
		return (cont - 1);
	}

}
