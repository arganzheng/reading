/**
 * Auth_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public interface Auth_PortType extends java.rmi.Remote {
    public com.paipai.api.bossadmin.sensitive.Result checkSession(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result checkAuth(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result writeOperationRecord(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result logOut(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result lookupAuth(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public java.lang.String echo(java.lang.String in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.RoleResult lookupBusinessRole(com.paipai.api.bossadmin.sensitive.RoleRequest in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.RoleResult getAllBusinessRole(com.paipai.api.bossadmin.sensitive.RoleRequest in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result lookupOwner(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.Result lookupOperation(com.paipai.api.bossadmin.sensitive.Request in) throws java.rmi.RemoteException;
    public com.paipai.api.bossadmin.sensitive.CheckBusinessRoleResult checkBusinessRole(com.paipai.api.bossadmin.sensitive.CheckBusinessRoleRequest in) throws java.rmi.RemoteException;
}
