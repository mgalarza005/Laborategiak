package DIP;

import java.util.HashMap;
import java.util.Map;

public class Covid19Pacient extends Pacient{
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


	public Map<Symptom, Integer> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Map<Symptom, Integer> symptoms) {
		this.symptoms = symptoms;
	}

	double calcCovid19Impact(Afection a, Increment i, Impact im) {

		double impact;

		
		//calculate afection
		double afection = a.calculateAfections();


		//calculate increment
		
		double increment=i.calculateIncrement(getYears(),afection);


		//calculate impact
		

		impact= im.calculateImpact(getYears(),afection, increment);


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