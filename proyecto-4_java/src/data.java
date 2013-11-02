/**      
 *     A simple class wich save the final data to print
 * 
 *      @authors: 
 *      César Alberto Trejo Juárez (cesaratj27 at gmail.com)
 *      Magnus Henkel (magnus.henkel at zoho.com)
 *      
 *          Created on: Oct 31, 2013
 */
import java.util.*;

public class data implements Comparable<data>{
	private int idData;
	private int cpCountedData;
	private int delMunData;
	private String nameEdo;

	public data(int cp, String edo, int delMun, int id){
		this.cpCountedData = cp;
		this.nameEdo = edo;
		this.delMunData = delMun;
		this.idData = id;
	}

	@Override
    public String toString() {

        return nameEdo + "\t\t\t" + cpCountedData + "\t\t\t" + delMunData + "\n";
    }

    @Override
    public int compareTo(data o) {
    	return this.cpCountedData-o.cpCountedData;
    }

    @Override
    public int hashCode() {
    	return cpCountedData + nameEdo.hashCode() + idData;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
        	return false;
        }

        if (getClass() != obj.getClass()) {
        	return false;
        }

        final data other = (data) obj;

        if (this.cpCountedData != other.cpCountedData) {
        	return false;
        }

        if (!Objects.equals(this.nameEdo, other.nameEdo)) {
            return false;
        }

        if (this.cpCountedData != other.cpCountedData) {
        	return false;
        }
        return true;
    }
}
