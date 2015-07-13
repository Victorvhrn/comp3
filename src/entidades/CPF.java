package entidades;

import controladores.ccu.exceptions.CPFIncompletoException;
import controladores.ccu.exceptions.CPFInvalidoException;

public class CPF {
	
	private int[] digitos;
	
	public CPF(int... digitos) throws CPFInvalidoException, CPFIncompletoException{
		if (digitos.length != 11){
			throw new CPFIncompletoException(this.toString());
		}else{
			// usando o clone = nao permitir alteracoes externas a classe CPF nos valores do array
			this.digitos = digitos.clone();
			if(!this.cpfValido())
				throw new CPFInvalidoException(this.toString());
		}
	}
	
	private boolean cpfValido() {
		int[] dv = getListaDigitosVerificadores();
		int[] v = new int[2];
		
		v[0] = digitos[0]+2*digitos[1]+3*digitos[2];
		v[0] += 4*digitos[3]+5*digitos[4]+6*digitos[5];
		v[0] += 7*digitos[6]+8*digitos[7]+9*digitos[8];
		v[0] = v[0] % 11;
		v[0] = v[0] % 10;
		
		v[1] = digitos[0]+2*digitos[1]+3*digitos[2];
		v[1] += 4*digitos[3]+5*digitos[4]+6*digitos[5];
		v[1] += 7*digitos[6]+8*digitos[7]+9*digitos[8];
		v[1] = v[1] % 11;
		v[1] = v[1] % 10;
		
		return v[0] == dv[0] && v[1] == dv[1];
	}

	public int getDigitosVerificadores(){
		return digitos[9]*10 + digitos[10];
	}

	public int[] getListaDigitosVerificadores(){
		return new int[]{digitos[9], digitos[10]};
	}

	public int[] getListaDigitos(){
		return digitos.clone();
	}
	@Override
	public String toString() {
		String results = "";
		for (int i = 0; i < digitos.length; i++) {
			results += ""+digitos[i];
		}
		return results;
	}
	
	@Override
	public boolean equals(Object obj) {
		CPF outro = (CPF) obj;
		int[] digitosOutro = outro.getListaDigitos();
		
		boolean iguais = true;
		for (int i = 0; i < digitos.length; i++) {
			if (digitos[i]!= digitosOutro[i]){
				iguais = false;
				break;
			}
		}
		return iguais;
	}
	
	public static CPF fromString(String digitos) throws CPFInvalidoException, CPFIncompletoException{
		int[] arrayDigitos = new int[digitos.length()];
		
		for (int i = 0; i < arrayDigitos.length; i++) {
			arrayDigitos[i] = Integer.parseInt(""+digitos.charAt(i)); 
		}
		
		CPF cpf = new CPF(arrayDigitos);
		return cpf;
	}
}
