package StudentenVerwaltung.Domain;

//Composition
	public class GradeUnit {

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