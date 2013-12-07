/**
 * Result.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class Result  implements java.io.Serializable {
    private java.lang.Integer status;

    private java.lang.String status_info;

    private java.lang.String auth_cm_com_session_key;

    private java.lang.String user_name;

    private java.lang.String operation_name;

    private java.lang.String login_url;

    private java.lang.String auth_apply_url;

    private java.lang.Integer system_id;

    private com.paipai.api.bossadmin.sensitive.OpInfo[] operation_list;

    private java.lang.String logout_url;

    private java.lang.String[] owner_list;

    public Result() {
    }

    public Result(
           java.lang.Integer status,
           java.lang.String status_info,
           java.lang.String auth_cm_com_session_key,
           java.lang.String user_name,
           java.lang.String operation_name,
           java.lang.String login_url,
           java.lang.String auth_apply_url,
           java.lang.Integer system_id,
           com.paipai.api.bossadmin.sensitive.OpInfo[] operation_list,
           java.lang.String logout_url,
           java.lang.String[] owner_list) {
           this.status = status;
           this.status_info = status_info;
           this.auth_cm_com_session_key = auth_cm_com_session_key;
           this.user_name = user_name;
           this.operation_name = operation_name;
           this.login_url = login_url;
           this.auth_apply_url = auth_apply_url;
           this.system_id = system_id;
           this.operation_list = operation_list;
           this.logout_url = logout_url;
           this.owner_list = owner_list;
    }


    /**
     * Gets the status value for this Result.
     * 
     * @return status
     */
    public java.lang.Integer getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Result.
     * 
     * @param status
     */
    public void setStatus(java.lang.Integer status) {
        this.status = status;
    }


    /**
     * Gets the status_info value for this Result.
     * 
     * @return status_info
     */
    public java.lang.String getStatus_info() {
        return status_info;
    }


    /**
     * Sets the status_info value for this Result.
     * 
     * @param status_info
     */
    public void setStatus_info(java.lang.String status_info) {
        this.status_info = status_info;
    }


    /**
     * Gets the auth_cm_com_session_key value for this Result.
     * 
     * @return auth_cm_com_session_key
     */
    public java.lang.String getAuth_cm_com_session_key() {
        return auth_cm_com_session_key;
    }


    /**
     * Sets the auth_cm_com_session_key value for this Result.
     * 
     * @param auth_cm_com_session_key
     */
    public void setAuth_cm_com_session_key(java.lang.String auth_cm_com_session_key) {
        this.auth_cm_com_session_key = auth_cm_com_session_key;
    }


    /**
     * Gets the user_name value for this Result.
     * 
     * @return user_name
     */
    public java.lang.String getUser_name() {
        return user_name;
    }


    /**
     * Sets the user_name value for this Result.
     * 
     * @param user_name
     */
    public void setUser_name(java.lang.String user_name) {
        this.user_name = user_name;
    }


    /**
     * Gets the operation_name value for this Result.
     * 
     * @return operation_name
     */
    public java.lang.String getOperation_name() {
        return operation_name;
    }


    /**
     * Sets the operation_name value for this Result.
     * 
     * @param operation_name
     */
    public void setOperation_name(java.lang.String operation_name) {
        this.operation_name = operation_name;
    }


    /**
     * Gets the login_url value for this Result.
     * 
     * @return login_url
     */
    public java.lang.String getLogin_url() {
        return login_url;
    }


    /**
     * Sets the login_url value for this Result.
     * 
     * @param login_url
     */
    public void setLogin_url(java.lang.String login_url) {
        this.login_url = login_url;
    }


    /**
     * Gets the auth_apply_url value for this Result.
     * 
     * @return auth_apply_url
     */
    public java.lang.String getAuth_apply_url() {
        return auth_apply_url;
    }


    /**
     * Sets the auth_apply_url value for this Result.
     * 
     * @param auth_apply_url
     */
    public void setAuth_apply_url(java.lang.String auth_apply_url) {
        this.auth_apply_url = auth_apply_url;
    }


    /**
     * Gets the system_id value for this Result.
     * 
     * @return system_id
     */
    public java.lang.Integer getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this Result.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.Integer system_id) {
        this.system_id = system_id;
    }


    /**
     * Gets the operation_list value for this Result.
     * 
     * @return operation_list
     */
    public com.paipai.api.bossadmin.sensitive.OpInfo[] getOperation_list() {
        return operation_list;
    }


    /**
     * Sets the operation_list value for this Result.
     * 
     * @param operation_list
     */
    public void setOperation_list(com.paipai.api.bossadmin.sensitive.OpInfo[] operation_list) {
        this.operation_list = operation_list;
    }

    public com.paipai.api.bossadmin.sensitive.OpInfo getOperation_list(int i) {
        return this.operation_list[i];
    }

    public void setOperation_list(int i, com.paipai.api.bossadmin.sensitive.OpInfo _value) {
        this.operation_list[i] = _value;
    }


    /**
     * Gets the logout_url value for this Result.
     * 
     * @return logout_url
     */
    public java.lang.String getLogout_url() {
        return logout_url;
    }


    /**
     * Sets the logout_url value for this Result.
     * 
     * @param logout_url
     */
    public void setLogout_url(java.lang.String logout_url) {
        this.logout_url = logout_url;
    }


    /**
     * Gets the owner_list value for this Result.
     * 
     * @return owner_list
     */
    public java.lang.String[] getOwner_list() {
        return owner_list;
    }


    /**
     * Sets the owner_list value for this Result.
     * 
     * @param owner_list
     */
    public void setOwner_list(java.lang.String[] owner_list) {
        this.owner_list = owner_list;
    }

    public java.lang.String getOwner_list(int i) {
        return this.owner_list[i];
    }

    public void setOwner_list(int i, java.lang.String _value) {
        this.owner_list[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Result)) return false;
        Result other = (Result) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus()))) &&
            ((this.status_info==null && other.getStatus_info()==null) || 
             (this.status_info!=null &&
              this.status_info.equals(other.getStatus_info()))) &&
            ((this.auth_cm_com_session_key==null && other.getAuth_cm_com_session_key()==null) || 
             (this.auth_cm_com_session_key!=null &&
              this.auth_cm_com_session_key.equals(other.getAuth_cm_com_session_key()))) &&
            ((this.user_name==null && other.getUser_name()==null) || 
             (this.user_name!=null &&
              this.user_name.equals(other.getUser_name()))) &&
            ((this.operation_name==null && other.getOperation_name()==null) || 
             (this.operation_name!=null &&
              this.operation_name.equals(other.getOperation_name()))) &&
            ((this.login_url==null && other.getLogin_url()==null) || 
             (this.login_url!=null &&
              this.login_url.equals(other.getLogin_url()))) &&
            ((this.auth_apply_url==null && other.getAuth_apply_url()==null) || 
             (this.auth_apply_url!=null &&
              this.auth_apply_url.equals(other.getAuth_apply_url()))) &&
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id()))) &&
            ((this.operation_list==null && other.getOperation_list()==null) || 
             (this.operation_list!=null &&
              java.util.Arrays.equals(this.operation_list, other.getOperation_list()))) &&
            ((this.logout_url==null && other.getLogout_url()==null) || 
             (this.logout_url!=null &&
              this.logout_url.equals(other.getLogout_url()))) &&
            ((this.owner_list==null && other.getOwner_list()==null) || 
             (this.owner_list!=null &&
              java.util.Arrays.equals(this.owner_list, other.getOwner_list())));
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
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getStatus_info() != null) {
            _hashCode += getStatus_info().hashCode();
        }
        if (getAuth_cm_com_session_key() != null) {
            _hashCode += getAuth_cm_com_session_key().hashCode();
        }
        if (getUser_name() != null) {
            _hashCode += getUser_name().hashCode();
        }
        if (getOperation_name() != null) {
            _hashCode += getOperation_name().hashCode();
        }
        if (getLogin_url() != null) {
            _hashCode += getLogin_url().hashCode();
        }
        if (getAuth_apply_url() != null) {
            _hashCode += getAuth_apply_url().hashCode();
        }
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        if (getOperation_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOperation_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOperation_list(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLogout_url() != null) {
            _hashCode += getLogout_url().hashCode();
        }
        if (getOwner_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOwner_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOwner_list(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Result.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "Result"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status_info");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status_info"));
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
        elemField.setFieldName("user_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("login_url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login_url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("auth_apply_url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_apply_url"));
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
        elemField.setFieldName("operation_list");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "OpInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logout_url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logout_url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner_list");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
