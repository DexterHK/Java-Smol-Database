package StudentenVerwaltung.Domain;

//Composition
	public class GradeUnit {
		/*public final double  EINSPLUS = 0.75;
		public final double EINS = 1.0;
		public final double EINSMINUS = 1.25;
		public final double ZWEIPLUS = 1.75;
		public final double ZWEI = 2.0;
		public final double ZWEIMINUS = 2.25;
		public final double DREIPLUS = 2.75;
		public final double DREI = 3.0;
		public final double	DREIMINUS = 3.25;
		public final double	VIERPLUS = 3.75;
		public final double	VIER = 4;
		public final double	VIERMINUS = 4.25;
		public final double	F�NF = 5.0;
		*/
		private double value;
		
		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public GradeUnit(double value)
		{
			this.value = value;
		}
	}