package ISP;

import java.util.HashMap;
import java.util.Map;

public class Covid19Pacient extends Pacient implements Yearsable{
	String name;
	Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();

	public void addSymptom(Symptom c, Integer w){
		symptoms.put(c,w);
	}
	
	public void showSymptoms(){
		for (Symptom s: symptoms.keySet())
			s.show();
	}
	public void cure(){
		for (Symptom s: symptoms.keySet())
			if(!(s instanceof IncurableSymptom)) {
				s.cure();
			}
			
	}
	

	double calcCovid19Impact() {

		double impact;

		
		//calculate afection
		Afection a= new Afection(symptoms);
		double afection = a.calculateAfections();


		//calculate increment
		Increment i=new Increment();
		double increment=i.calculateIncrement(this,afection);


		//calculate impact
		Impact im= new Impact();

		impact= im.calculateImpac(getYears() ,afection, increment);


		return impact;
	}
	int sanatedDays() {
		int max=0;
		for (Symptom s:symptoms.keySet())
			if(max<s.affectedDays) {
				max=s.affectedDays;
			}
		return max;

	}

	
}