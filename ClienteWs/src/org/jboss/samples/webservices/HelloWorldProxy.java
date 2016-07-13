package org.jboss.samples.webservices;

public class HelloWorldProxy implements org.jboss.samples.webservices.HelloWorld {
  private String _endpoint = null;
  private org.jboss.samples.webservices.HelloWorld helloWorld = null;
  
  public HelloWorldProxy() {
    _initHelloWorldProxy();
  }
  
  public HelloWorldProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloWorldProxy();
  }
  
  private void _initHelloWorldProxy() {
    try {
      helloWorld = (new org.jboss.samples.webservices.HelloWorldServiceLocator()).getHelloWorldPort();
      if (helloWorld != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)helloWorld)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (helloWorld != null)
      ((javax.xml.rpc.Stub)helloWorld)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.jboss.samples.webservices.HelloWorld getHelloWorld() {
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld;
  }
  
  public java.lang.String sayHello(java.lang.String arg0) throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld.sayHello(arg0);
  }
  
  public java.lang.String hola() throws java.rmi.RemoteException{
    if (helloWorld == null)
      _initHelloWorldProxy();
    return helloWorld.hola();
  }
  
  
}