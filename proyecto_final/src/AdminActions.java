/**
*
*
*/
import java.io.*;
import java.util.*;

public class AdminActions{
        //ArrayList usersBanned = new ArrayList();
        String accion;
        String tmpAccion;

        /*public AdminActions(ArrayList tmpUsersBanned){
                this.usersBanned = tmpUsersBanned;

        }*/

        public void SaveFile(String toFileWrite,ArrayList<String> usersBanned) {
/*
for (int j = 0; j < chatLog.size(); j++) {
String temp = chatLog.get(j);
System.out.println(temp);
}
*/
                PrintWriter logFile = null;
                try {
                        logFile = new PrintWriter(new FileWriter(toFileWrite));
                } catch (IOException e) {
                        System.out.println("ERROR: Can't open logfile");
                }
                
                for (int i = 0; i < usersBanned.size(); i++) {
                        logFile.print("*");
                        logFile.print(usersBanned.get(i));
                        logFile.println("#");
                }
                logFile.close();
        }

        public boolean action(){
                BufferedReader order = new BufferedReader(new InputStreamReader(System.in));
                //System.out.println("****welcome to admin panel***");
                while(true){
                try{
                        accion = order.readLine();
                        System.out.println("Your order is: "+accion);
                        if(accion.startsWith("block")){
                                tmpAccion = accion.substring(accion.indexOf(' ')+1);
                                tmpAccion = Tools.capitalizeFirstLetter(tmpAccion);
                                System.out.println(tmpAccion+" Banned");
                                Server.usersBanned.add(tmpAccion);
                                SaveFile("./banned.txt",Server.usersBanned);
                                return true;

                        }
                        else if(accion.startsWith("unlock")){
                                tmpAccion = accion.substring(accion.indexOf(' ')+1);
                                tmpAccion = Tools.capitalizeFirstLetter(tmpAccion);
                                if(Server.usersBanned.contains(tmpAccion)){
                                        System.out.println(tmpAccion+" Done");
                                        Server.usersBanned.remove(tmpAccion);
                                        SaveFile("./banned.txt",Server.usersBanned);
                                }
                                else{
                                        System.out.println("ERROR: User not found");
                                }
                                return true;
                        }
                        else if(accion.equals("q")){
                                return false;
                        }
                        //SaveFile("./banned.txt",Server.usersBanned);
                }catch(IOException e){
                                System.out.println("ERROR:");
                        }
                }

        }

}
