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

public class data{
	public int idData;
	public int cpCountedData;
	public int delMunData;
	public String nameEdo;

	public data(int id, String edo, int cp, int delMun){
		this.idData = id;
		this.nameEdo = edo;
		this.cpCountedData = cp;
		this.delMunData = delMun;
	}

	@Override
    public String toString() {

        return "Estado: " + nameEdo + "\t\tNo CPs: " + cpCountedData + "\t\tNo Delegaciones/Municipios: "+ delMunData +"\n";
    }
}
