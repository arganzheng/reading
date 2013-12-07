/**
 * Request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class Request  implements java.io.Serializable {
    private java.lang.String user_name;

    private java.lang.String auth_cm_com_session_key;

    private java.lang.String auth_cm_com_ticket;

    private java.lang.Integer system_id;

    private java.lang.Integer operation_id;

    private java.lang.String user_ip;

    private java.lang.String user_url;

    private java.lang.String local_session_id;

    private java.lang.String operation_log;

    private java.lang.String login_mode;

    public Request() {
    }

    public Request(
           java.lang.String user_name,
           java.lang.String auth_cm_com_session_key,
           java.lang.String auth_cm_com_ticket,
           java.lang.Integer system_id,
           java.lang.Integer operation_id,
           java.lang.String user_ip,
           java.lang.String user_url,
           java.lang.String local_session_id,
           java.lang.String operation_log,
           java.lang.String login_mode) {
           this.user_name = user_name;
           this.auth_cm_com_session_key = auth_cm_com_session_key;
           this.auth_cm_com_ticket = auth_cm_com_ticket;
           this.system_id = system_id;
           this.operation_id = operation_id;
           this.user_ip = user_ip;
           this.user_url = user_url;
           this.local_session_id = local_session_id;
           this.operation_log = operation_log;
           this.login_mode = login_mode;
    }


    /**
     * Gets the user_name value for this Request.
     * 
     * @return user_name
     */
    public java.lang.String getUser_name() {
        return user_name;
    }


    /**
     * Sets the user_name value for this Request.
     * 
     * @param user_name
     */
    public void setUser_name(java.lang.String user_name) {
        this.user_name = user_name;
    }


    /**
     * Gets the auth_cm_com_session_key value for this Request.
     * 
     * @return auth_cm_com_session_key
     */
    public java.lang.String getAuth_cm_com_session_key() {
        return auth_cm_com_session_key;
    }


    /**
     * Sets the auth_cm_com_session_key value for this Request.
     * 
     * @param auth_cm_com_session_key
     */
    public void setAuth_cm_com_session_key(java.lang.String auth_cm_com_session_key) {
        this.auth_cm_com_session_key = auth_cm_com_session_key;
    }


    /**
     * Gets the auth_cm_com_ticket value for this Request.
     * 
     * @return auth_cm_com_ticket
     */
    public java.lang.String getAuth_cm_com_ticket() {
        return auth_cm_com_ticket;
    }


    /**
     * Sets the auth_cm_com_ticket value for this Request.
     * 
     * @param auth_cm_com_ticket
     */
    public void setAuth_cm_com_ticket(java.lang.String auth_cm_com_ticket) {
        this.auth_cm_com_ticket = auth_cm_com_ticket;
    }


    /**
     * Gets the system_id value for this Request.
     * 
     * @return system_id
     */
    public java.lang.Integer getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this Request.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.Integer system_id) {
        this.system_id = system_id;
    }


    /**
     * Gets the operation_id value for this Request.
     * 
     * @return operation_id
     */
    public java.lang.Integer getOperation_id() {
        return operation_id;
    }


    /**
     * Sets the operation_id value for this Request.
     * 
     * @param operation_id
     */
    public void setOperation_id(java.lang.Integer operation_id) {
        this.operation_id = operation_id;
    }


    /**
     * Gets the user_ip value for this Request.
     * 
     * @return user_ip
     */
    public java.lang.String getUser_ip() {
        return user_ip;
    }


    /**
     * Sets the user_ip value for this Request.
     * 
     * @param user_ip
     */
    public void setUser_ip(java.lang.String user_ip) {
        this.user_ip = user_ip;
    }


    /**
     * Gets the user_url value for this Request.
     * 
     * @return user_url
     */
    public java.lang.String getUser_url() {
        return user_url;
    }


    /**
     * Sets the user_url value for this Request.
     * 
     * @param user_url
     */
    public void setUser_url(java.lang.String user_url) {
        this.user_url = user_url;
    }


    /**
     * Gets the local_session_id value for this Request.
     * 
     * @return local_session_id
     */
    public java.lang.String getLocal_session_id() {
        return local_session_id;
    }


    /**
     * Sets the local_session_id value for this Request.
     * 
     * @param local_session_id
     */
    public void setLocal_session_id(java.lang.String local_session_id) {
        this.local_session_id = local_session_id;
    }


    /**
     * Gets the operation_log value for this Request.
     * 
     * @return operation_log
     */
    public java.lang.String getOperation_log() {
        return operation_log;
    }


    /**
     * Sets the operation_log value for this Request.
     * 
     * @param operation_log
     */
    public void setOperation_log(java.lang.String operation_log) {
        this.operation_log = operation_log;
    }


    /**
     * Gets the login_mode value for this Request.
     * 
     * @return login_mode
     */
    public java.lang.String getLogin_mode() {
        return login_mode;
    }


    /**
     * Sets the login_mode value for this Request.
     * 
     * @param login_mode
     */
    public void setLogin_mode(java.lang.String login_mode) {
        this.login_mode = login_mode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Request)) return false;
        Request other = (Request) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.user_name==null && other.getUser_name()==null) || 
             (this.user_name!=null &&
              this.user_name.equals(other.getUser_name()))) &&
            ((this.auth_cm_com_session_key==null && other.getAuth_cm_com_session_key()==null) || 
             (this.auth_cm_com_session_key!=null &&
              this.auth_cm_com_session_key.equals(other.getAuth_cm_com_session_key()))) &&
            ((this.auth_cm_com_ticket==null && other.getAuth_cm_com_ticket()==null) || 
             (this.auth_cm_com_ticket!=null &&
              this.auth_cm_com_ticket.equals(other.getAuth_cm_com_ticket()))) &&
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id()))) &&
            ((this.operation_id==null && other.getOperation_id()==null) || 
             (this.operation_id!=null &&
              this.operation_id.equals(other.getOperation_id()))) &&
            ((this.user_ip==null && other.getUser_ip()==null) || 
             (this.user_ip!=null &&
              this.user_ip.equals(other.getUser_ip()))) &&
            ((this.user_url==null && other.getUser_url()==null) || 
             (this.user_url!=null &&
              this.user_url.equals(other.getUser_url()))) &&
            ((this.local_session_id==null && other.getLocal_session_id()==null) || 
             (this.local_session_id!=null &&
              this.local_session_id.equals(other.getLocal_session_id()))) &&
            ((this.operation_log==null && other.getOperation_log()==null) || 
             (this.operation_log!=null &&
              this.operation_log.equals(other.getOperation_log()))) &&
            ((this.login_mode==null && other.getLogin_mode()==null) || 
             (this.login_mode!=null &&
              this.login_mode.equals(other.getLogin_mode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUser_name() != null) {
            _hashCode += getUser_name().hashCode();
        }
        if (getAuth_cm_com_session_key() != null) {
            _hashCode += getAuth_cm_com_session_key().hashCode();
        }
        if (getAuth_cm_com_ticket() != null) {
            _hashCode += getAuth_cm_com_ticket().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        if (getOperation_id() != null) {
            _hashCode += getOperation_id().hashCode();
        }
        if (getUser_ip() != null) {
            _hashCode += getUser_ip().hashCode();
        }
        if (getUser_url() != null) {
            _hashCode += getUser_url().hashCode();
        }
        if (getLocal_session_id() != null) {
            _hashCode += getLocal_session_id().hashCode();
        }
        if (getOperation_log() != null) {
            _hashCode += getOperation_log().hashCode();
        }
        if (getLogin_mode() != null) {
            _hashCode += getLogin_mode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "Request"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_cm_com_session_key");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_cm_com_session_key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_cm_com_ticket");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_cm_com_ticket"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("system_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "system_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_ip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_ip"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("local_session_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "local_session_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation_log");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation_log"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login_mode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login_mode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
