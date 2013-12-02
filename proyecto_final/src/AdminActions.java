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
	String tmpAccionCap;


	public static void ShowBlockedUsers(HashSet<String> blockedUsers) {
		HashSet<String> usersBanned= Server.usersBanned;

		if(usersBanned.isEmpty()) {
			Server.readFileIntoArray(usersBanned, BLACKLIST);
		}

		for(String temp : usersBanned){
			System.out.println(temp);
		}
	}
	

	public boolean action(){
		BufferedReader order = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
				System.out.println("Options: block (b) /unblock (u) /show blocked users (s) /quit (q)");
				System.out.print("Type option: ");
				accion = order.readLine();
				if(accion.startsWith("b")) {
					String reoffending = "0";
					System.out.println("Name of user to be blocked: ");
					String blockUser = order.readLine();
					tmpAccion = blockUser.substring(blockUser.indexOf(' ')+1);
					System.out.println(tmpAccion + " banned");

					Tools.propSetter(tmpAccion, reoffending, BLACKLIST , "blocked Users");
					Server.usersBanned.add(tmpAccion);

					return true;

				} else if(accion.startsWith("u")) {
					System.out.println("Name of user to be unblocked: ");
					String unBlockUser = order.readLine();
					System.out.println("Unblock user: " + unBlockUser);
					String reoffending = "0"; // variable que se podría usar para la cuenta cuantas veces fue bloqueado

					tmpAccion = unBlockUser.substring(unBlockUser.indexOf(' ')+1);
					System.out.println("unblock user after tmpAction" + tmpAccion);
					tmpAccionCap = Tools.capitalizeFirstLetter(tmpAccion);

					if(Server.usersBanned.contains(tmpAccion)) {
						System.out.println(tmpAccion + " unblocked");
						Tools.propEraser(tmpAccion, BLACKLIST);
						Server.usersBanned.remove(tmpAccion);

					} else if(Server.usersBanned.contains(tmpAccionCap)) {
						System.out.println(tmpAccion + " unblocked");
						Tools.propEraser(tmpAccion, BLACKLIST);
						Server.usersBanned.remove(tmpAccionCap);
					} else {
						System.out.println("User is not blocked");
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