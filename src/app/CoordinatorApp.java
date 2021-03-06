package app;

import java.util.ArrayList;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import ClientApp.Client;
import ClientApp.ClientHelper;
import CoordinatorApp.CoordinatorPOA;
import gui.CoordinatorGui;

public class CoordinatorApp extends CoordinatorPOA{
	private NamingContext naming;
	private CoordinatorGui coordinatorGui;
	private boolean criticalSession = false;
	private ArrayList<String> processQueue = new ArrayList<String>();
	
	public CoordinatorApp(NamingContext naming) {
		// TODO Auto-generated constructor stub
		this.naming = naming;
		coordinatorGui = new CoordinatorGui();
	}

	@Override
	public void request(String processID) {
		// TODO Auto-generated method stub
		if( criticalSession == true ){
			processQueue.add(processID);
			coordinatorGui.drawQueue(processQueue);
			this.coordinatorGui.log("Adding process "+ processID +" to queue...\r\n");
		}else{
			if( processQueue.isEmpty() ){
				try{
					NameComponent[] processName = {new NameComponent(processID,"")};
					org.omg.CORBA.Object processObjRef =  naming.resolve(processName);
					Client client = ClientHelper.narrow(processObjRef);
					this.coordinatorGui.log("Grant access to process "+ processID+"\r\n");
					this.criticalSession = true;
					client.OK();
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
			else{
				processQueue.add(processID);
				coordinatorGui.drawQueue(processQueue);
				this.coordinatorGui.log("Adding process "+ processID +" to queue...\r\n");
			}
		}
		
	}

	@Override
	public void release(String processID) {
		// TODO Auto-generated method stub
		this.criticalSession = false;
		this.coordinatorGui.log("Process "+ processID +" released the critical session...\r\n");
		try{
			if( !processQueue.isEmpty() ){
				String nextProcessID = processQueue.remove(0);
				coordinatorGui.drawQueue(processQueue);
				NameComponent[] processName = {new NameComponent(nextProcessID,"")};
				org.omg.CORBA.Object processObjRef =  naming.resolve(processName);
				Client client = ClientHelper.narrow(processObjRef);
				this.coordinatorGui.log("Grant access to process "+nextProcessID+"\r\n");
				this.criticalSession = true;
				client.OK();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ORB orb = ORB.init(args,null); 	
			org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
			POA rootPOA = POAHelper.narrow(objPoa);		

			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext naming = NamingContextHelper.narrow(obj);

			CoordinatorApp coordinator = new CoordinatorApp(naming);
			org.omg.CORBA.Object   objRef =	 rootPOA.servant_to_reference(coordinator);

			NameComponent[] name = {new NameComponent("Coordinator","")};

			naming.rebind(name,objRef);
			rootPOA.the_POAManager().activate();
			System.out.println("Coordinator ready ...");
			orb.run();

		   }catch (Exception ex){
				ex.printStackTrace();
		  }

	}

}
