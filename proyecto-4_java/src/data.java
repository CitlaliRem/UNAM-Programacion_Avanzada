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

public class data implements Comparable<Data>{
        private int id;
        private int zipCode;
        private int township;
        private String state;

        public data(int cp, String edo, int delMun, int id){
                this.zipCode = cp;
                this.state = edo;
                this.township = delMun;
                this.id = id;
        }

    @Override
    public String toString() {

        return township + "\t\t\t\t\t" + zipCode + "\t\t\t\t\t" + state + "\n";
    }

    @Override
    public int compareTo(Data o) {
            return this.zipCode-o.zipCode;
    }

    @Override
    public int hashCode() {
            return zipCode + state.hashCode() + id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
                return false;
        }

        if (getClass() != obj.getClass()) {
                return false;
        }

        final Data other = (Data) obj;

        if (this.zipCode != other.zipCode) {
                return false;
        }
/*
        if (!Objects.equals(this.nameEdo, other.nameEdo)) {
            return false;
        }
*/
        if (this.zipCode != other.zipCode) {
                return false;
        }
        return true;
    }
}
