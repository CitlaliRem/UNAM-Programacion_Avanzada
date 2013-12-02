/**
*
*
*/
import java.io.*;
import java.util.*;

public class AdminActions{
        //ArrayList usersBanned = new ArrayList();
		private static final String BLACKLIST = "./blacklist.xml"; 
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

	public static void ShowBlockedUsers(ArrayList<String> blockedUsers) {
		ArrayList<String> usersBanned= Server.usersBanned;
		
		System.out.println("size or usersBanned " + usersBanned.size());
    	if(usersBanned.isEmpty()) {
    		Server.readFileIntoArray(usersBanned, BLACKLIST);
    	}

    	for (int j = 0; j < usersBanned.size(); j++) {
        	String temp = usersBanned.get(j);
        	System.out.println(temp);
		}
	}

        public boolean action(){
                BufferedReader order = new BufferedReader(new InputStreamReader(System.in));
                //System.out.println("****welcome to admin panel***");
                while(true){
                try{
                	System.out.println("Options: block (b) /unblock (u) /show blocked users (s) /quit (q)");
                	System.out.print("Type option: ");
                        accion = order.readLine();
                        //System.out.println("Your order is: "+accion);
                        if(accion.startsWith("b")){
                        	String reoffending = "0";
                        	System.out.println("Name of user to be blocked: ");
                        	String blockUser = order.readLine();
                            //tmpAccion = accion.substring(accion.indexOf(' ')+1);
                            tmpAccion = blockUser.substring(blockUser.indexOf(' ')+1);
                            //tmpAccion = Tools.capitalizeFirstLetter(tmpAccion);
                            System.out.println(tmpAccion+" Banned");
                            //Server.usersBanned.add(tmpAccion);
                            Tools.propSetter(tmpAccion, reoffending, BLACKLIST , "blocked Users");
                            SaveFile("./banned.txt",Server.usersBanned);
                            return true;

                        }
                        else if(accion.startsWith("u")){
                        	System.out.println("Name of user to be unblocked: ");
                        	String unBlockUser = order.readLine();
                        	System.out.println("unblock user: " + unBlockUser);
                        	String reoffending = "0";
                                tmpAccion = unBlockUser.substring(unBlockUser.indexOf(' ')+1);
                                System.out.println("unblock user after tmpAction" + tmpAccion);
                                //tmpAccion = Tools.capitalizeFirstLetter(tmpAccion);
                                if(Server.usersBanned.contains(tmpAccion)){
                                        System.out.println(tmpAccion+" unblocked");
                                        //Server.usersBanned.remove(tmpAccion);
                                        Tools.propEraser(tmpAccion, BLACKLIST);
                                        SaveFile("./banned.txt",Server.usersBanned);
                                }
                                else{
                                        System.out.println("ERROR: User not found");
                                }
                                return true;
                        } else if (accion.startsWith("s")) {
                        	ShowBlockedUsers(Server.usersBanned);
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