package CoordinatorApp;


/**
* CoordinatorApp/CoordinatorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CoordinatorDL.idl
* Sexta-feira, 20 de Janeiro de 2017 14h07min38s GMT-03:00
*/

public abstract class CoordinatorPOA extends org.omg.PortableServer.Servant
 implements CoordinatorApp.CoordinatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("request", new java.lang.Integer (0));
    _methods.put ("release", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CoordinatorApp/Coordinator/request
       {
         String processID = in.read_string ();
         this.request (processID);
         out = $rh.createReply();
         break;
       }

       case 1:  // CoordinatorApp/Coordinator/release
       {
         String processID = in.read_string ();
         this.release (processID);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CoordinatorApp/Coordinator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Coordinator _this() 
  {
    return CoordinatorHelper.narrow(
    super._this_object());
  }

  public Coordinator _this(org.omg.CORBA.ORB orb) 
  {
    return CoordinatorHelper.narrow(
    super._this_object(orb));
  }


} // class CoordinatorPOA
