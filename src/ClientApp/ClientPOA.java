package ClientApp;


/**
* ClientApp/ClientPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ClientDL.idl
* Sexta-feira, 20 de Janeiro de 2017 13h20min56s GMT-03:00
*/

public abstract class ClientPOA extends org.omg.PortableServer.Servant
 implements ClientApp.ClientOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("OK", new java.lang.Integer (0));
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
       case 0:  // ClientApp/Client/OK
       {
         this.OK ();
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
    "IDL:ClientApp/Client:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Client _this() 
  {
    return ClientHelper.narrow(
    super._this_object());
  }

  public Client _this(org.omg.CORBA.ORB orb) 
  {
    return ClientHelper.narrow(
    super._this_object(orb));
  }


} // class ClientPOA
