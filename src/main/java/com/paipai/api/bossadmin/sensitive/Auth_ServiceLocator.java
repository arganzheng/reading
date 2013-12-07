/**
 * Auth_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class Auth_ServiceLocator extends org.apache.axis.client.Service implements com.paipai.api.bossadmin.sensitive.Auth_Service {

    public Auth_ServiceLocator() {
    }


    public Auth_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Auth_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for authSOAP
    private java.lang.String authSOAP_address = "http://auth.cm.com:8080/auth";

    public java.lang.String getauthSOAPAddress() {
        return authSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String authSOAPWSDDServiceName = "authSOAP";

    public java.lang.String getauthSOAPWSDDServiceName() {
        return authSOAPWSDDServiceName;
    }

    public void setauthSOAPWSDDServiceName(java.lang.String name) {
        authSOAPWSDDServiceName = name;
    }

    public com.paipai.api.bossadmin.sensitive.Auth_PortType getauthSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(authSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getauthSOAP(endpoint);
    }

    public com.paipai.api.bossadmin.sensitive.Auth_PortType getauthSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.paipai.api.bossadmin.sensitive.AuthSOAPStub _stub = new com.paipai.api.bossadmin.sensitive.AuthSOAPStub(portAddress, this);
            _stub.setPortName(getauthSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setauthSOAPEndpointAddress(java.lang.String address) {
        authSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.paipai.api.bossadmin.sensitive.Auth_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.paipai.api.bossadmin.sensitive.AuthSOAPStub _stub = new com.paipai.api.bossadmin.sensitive.AuthSOAPStub(new java.net.URL(authSOAP_address), this);
                _stub.setPortName(getauthSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("authSOAP".equals(inputPortName)) {
            return getauthSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://auth.cm.com/auth/", "auth");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "authSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("authSOAP".equals(portName)) {
            setauthSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
