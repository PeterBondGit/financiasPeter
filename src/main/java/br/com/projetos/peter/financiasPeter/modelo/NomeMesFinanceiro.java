package br.com.projetos.peter.financiasPeter.modelo;

public enum NomeMesFinanceiro {
	
	MES {
		@Override
		public String nomeMes(int mes) {
			if ( mes == 1 ) {
				return "Jan - 2022";
			} else if (mes == 2) {
				return "Fev - 2022";
			} else if (mes == 3) {
				return "Mar - 2022";
			} else if (mes == 4) {
				return "Abr - 2022";
			} else if (mes == 5) {
				return "Mai - 2022";
			} else if (mes == 6) {
				return "Jun - 2022";
			} else if (mes == 7) {
				return "Jul - 2022";
			} else if (mes == 8) {
				return "Ago - 2022";
			} else if (mes == 9) {
				return "Set - 2022";
			} else if (mes == 10) {
				return "Out - 2022";
			} else if (mes == 11) {
				return "Nov - 2022";
			} else if (mes == 12) {
				return "Dez - 2022";
			} else {
				return "";
			}
		}
	};
	
	public abstract String nomeMes(int mes);
}
