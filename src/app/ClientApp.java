package app;

import org.omg.CosNaming.*; 
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import ClientApp.ClientPOA;
import CoordinatorApp.Coordinator;
import CoordinatorApp.CoordinatorHelper;
import java.util.UUID;
import gui.ClientGui;


public class ClientApp extends ClientPOA{
	private ClientGui clientGui;
	private String ID;
	private Coordinator coordinator;
	@Override
	public void OK() {
		// TODO Auto-generated method stub
		this.clientGui.enableBtnRelease();
		this.clientGui.log("Accessing the critical session\r\n");
	}
	
	public ClientApp(String ID, Coordinator coordinator){
		this.ID = ID;
		this.coordinator = coordinator;
		clientGui = new ClientGui(this.ID,this.coordinator);
	}

	public static void main(String[] args) {

		try{
			ORB orb = ORB.init(args,null); 	
		
			org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
			POA rootPOA = POAHelper.narrow(objPoa);		


			org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
			NamingContext naming = NamingContextHelper.narrow(obj);
			
			String clientID = UUID.randomUUID().toString();
			
			NameComponent[] coordinatorName = {new NameComponent("Coordinator","")};
			org.omg.CORBA.Object coordObjRef =  naming.resolve(coordinatorName);
			Coordinator coordinator = CoordinatorHelper.narrow(coordObjRef);
			
			ClientApp client = new ClientApp(clientID, coordinator);
			org.omg.CORBA.Object   objRef =	 rootPOA.servant_to_reference(client);
			
			NameComponent[] name = {new NameComponent(clientID,"")};
			naming.rebind(name,objRef);
			rootPOA.the_POAManager().activate();

			orb.run();

		   }catch (Exception ex){
				ex.printStackTrace();
		  }

	}
}
