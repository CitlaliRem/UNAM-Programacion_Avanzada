/**      
 *     A simple class wich save the final data to print
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 31, 2013
 */

//public abstract class data implements Comparable{
public class Data implements Comparable<Object>{
	public int idData;
	public int cpCountedData;
	public int delMunData;
	public String nameEdo;

	public Data(int id, String edo, int cp, int delMun){
		this.idData = id;
		this.nameEdo = edo;
		this.cpCountedData = cp;
		this.delMunData = delMun;
	}

	@Override
    public String toString() {
        return delMunData + "\t\t\t\t" + cpCountedData + "\t\t\t\t" + nameEdo + "\n";
    }

    
    public int compareTo(Object o) {
        //return this.cpCountedData-o.cpCountedData;
        return 0;
    }
}
