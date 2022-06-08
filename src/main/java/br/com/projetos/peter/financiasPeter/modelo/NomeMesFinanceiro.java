package br.com.projetos.peter.financiasPeter.modelo;

public enum NomeMesFinanceiro {
	
	JANEIRO {
		@Override
		public String nomeMes(int mes) {
			return "Jan - 2022";
		}
	},
	FEVEREIRO {
		@Override
		public String nomeMes(int mes) {
			return "Fev - 2022";
		}
	},
	MARCO {
		@Override
		public String nomeMes(int mes) {
			return "Mar - 2022";
		}
	},
	ABRIL {
		@Override
		public String nomeMes(int mes) {
			return "Abr - 2022";
		}
	},
	MAIO {
		@Override
		public String nomeMes(int mes) {
			return "Mai - 2022";
		}
	},
	JUNHO {
		@Override
		public String nomeMes(int mes) {
			return "Jun - 2022";
		}
	},
	JULHO {
		@Override
		public String nomeMes(int mes) {
			return "Jul - 2022";
		}
	},
	AGOSTO {
		@Override
		public String nomeMes(int mes) {
			return "Ago - 2022";
		}
	},
	SETEMBRO {
		@Override
		public String nomeMes(int mes) {
			return "Set - 2022";
		}
	},
	OUTUBRO {
		@Override
		public String nomeMes(int mes) {
			return "Out - 2022";
		}
	},
	NOVEMBRO {
		@Override
		public String nomeMes(int mes) {
			return "Nov - 2022";
		}
	},
	DEZEMBRO {
		@Override
		public String nomeMes(int mes) {
			return "Dez - 2022";
		}
	};
	
	public abstract String nomeMes(int mes);
}
