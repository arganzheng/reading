/**
 * CheckBusinessRoleRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class CheckBusinessRoleRequest  implements java.io.Serializable {
    private java.lang.String user_name;

    private java.lang.Integer system_id;

    private java.lang.String auth_cm_com_session_key;

    private java.lang.String user_url;

    private java.lang.String user_ip;

    private java.lang.String local_session_id;

    private com.paipai.api.bossadmin.sensitive.BusinessRoleRelation[] business_role_relation_list;

    public CheckBusinessRoleRequest() {
    }

    public CheckBusinessRoleRequest(
           java.lang.String user_name,
           java.lang.Integer system_id,
           java.lang.String auth_cm_com_session_key,
           java.lang.String user_url,
           java.lang.String user_ip,
           java.lang.String local_session_id,
           com.paipai.api.bossadmin.sensitive.BusinessRoleRelation[] business_role_relation_list) {
           this.user_name = user_name;
           this.system_id = system_id;
           this.auth_cm_com_session_key = auth_cm_com_session_key;
           this.user_url = user_url;
           this.user_ip = user_ip;
           this.local_session_id = local_session_id;
           this.business_role_relation_list = business_role_relation_list;
    }


    /**
     * Gets the user_name value for this CheckBusinessRoleRequest.
     * 
     * @return user_name
     */
    public java.lang.String getUser_name() {
        return user_name;
    }


    /**
     * Sets the user_name value for this CheckBusinessRoleRequest.
     * 
     * @param user_name
     */
    public void setUser_name(java.lang.String user_name) {
        this.user_name = user_name;
    }


    /**
     * Gets the system_id value for this CheckBusinessRoleRequest.
     * 
     * @return system_id
     */
    public java.lang.Integer getSystem_id() {
        return system_id;
    }


    /**
     * Sets the system_id value for this CheckBusinessRoleRequest.
     * 
     * @param system_id
     */
    public void setSystem_id(java.lang.Integer system_id) {
        this.system_id = system_id;
    }


    /**
     * Gets the auth_cm_com_session_key value for this CheckBusinessRoleRequest.
     * 
     * @return auth_cm_com_session_key
     */
    public java.lang.String getAuth_cm_com_session_key() {
        return auth_cm_com_session_key;
    }


    /**
     * Sets the auth_cm_com_session_key value for this CheckBusinessRoleRequest.
     * 
     * @param auth_cm_com_session_key
     */
    public void setAuth_cm_com_session_key(java.lang.String auth_cm_com_session_key) {
        this.auth_cm_com_session_key = auth_cm_com_session_key;
    }


    /**
     * Gets the user_url value for this CheckBusinessRoleRequest.
     * 
     * @return user_url
     */
    public java.lang.String getUser_url() {
        return user_url;
    }


    /**
     * Sets the user_url value for this CheckBusinessRoleRequest.
     * 
     * @param user_url
     */
    public void setUser_url(java.lang.String user_url) {
        this.user_url = user_url;
    }


    /**
     * Gets the user_ip value for this CheckBusinessRoleRequest.
     * 
     * @return user_ip
     */
    public java.lang.String getUser_ip() {
        return user_ip;
    }


    /**
     * Sets the user_ip value for this CheckBusinessRoleRequest.
     * 
     * @param user_ip
     */
    public void setUser_ip(java.lang.String user_ip) {
        this.user_ip = user_ip;
    }


    /**
     * Gets the local_session_id value for this CheckBusinessRoleRequest.
     * 
     * @return local_session_id
     */
    public java.lang.String getLocal_session_id() {
        return local_session_id;
    }


    /**
     * Sets the local_session_id value for this CheckBusinessRoleRequest.
     * 
     * @param local_session_id
     */
    public void setLocal_session_id(java.lang.String local_session_id) {
        this.local_session_id = local_session_id;
    }


    /**
     * Gets the business_role_relation_list value for this CheckBusinessRoleRequest.
     * 
     * @return business_role_relation_list
     */
    public com.paipai.api.bossadmin.sensitive.BusinessRoleRelation[] getBusiness_role_relation_list() {
        return business_role_relation_list;
    }


    /**
     * Sets the business_role_relation_list value for this CheckBusinessRoleRequest.
     * 
     * @param business_role_relation_list
     */
    public void setBusiness_role_relation_list(com.paipai.api.bossadmin.sensitive.BusinessRoleRelation[] business_role_relation_list) {
        this.business_role_relation_list = business_role_relation_list;
    }

    public com.paipai.api.bossadmin.sensitive.BusinessRoleRelation getBusiness_role_relation_list(int i) {
        return this.business_role_relation_list[i];
    }

    public void setBusiness_role_relation_list(int i, com.paipai.api.bossadmin.sensitive.BusinessRoleRelation _value) {
        this.business_role_relation_list[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckBusinessRoleRequest)) return false;
        CheckBusinessRoleRequest other = (CheckBusinessRoleRequest) obj;
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
            ((this.system_id==null && other.getSystem_id()==null) || 
             (this.system_id!=null &&
              this.system_id.equals(other.getSystem_id()))) &&
            ((this.auth_cm_com_session_key==null && other.getAuth_cm_com_session_key()==null) || 
             (this.auth_cm_com_session_key!=null &&
              this.auth_cm_com_session_key.equals(other.getAuth_cm_com_session_key()))) &&
            ((this.user_url==null && other.getUser_url()==null) || 
             (this.user_url!=null &&
              this.user_url.equals(other.getUser_url()))) &&
            ((this.user_ip==null && other.getUser_ip()==null) || 
             (this.user_ip!=null &&
              this.user_ip.equals(other.getUser_ip()))) &&
            ((this.local_session_id==null && other.getLocal_session_id()==null) || 
             (this.local_session_id!=null &&
              this.local_session_id.equals(other.getLocal_session_id()))) &&
            ((this.business_role_relation_list==null && other.getBusiness_role_relation_list()==null) || 
             (this.business_role_relation_list!=null &&
              java.util.Arrays.equals(this.business_role_relation_list, other.getBusiness_role_relation_list())));
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
        if (getSystem_id() != null) {
            _hashCode += getSystem_id().hashCode();
        }
        if (getAuth_cm_com_session_key() != null) {
            _hashCode += getAuth_cm_com_session_key().hashCode();
        }
        if (getUser_url() != null) {
            _hashCode += getUser_url().hashCode();
        }
        if (getUser_ip() != null) {
            _hashCode += getUser_ip().hashCode();
        }
        if (getLocal_session_id() != null) {
            _hashCode += getLocal_session_id().hashCode();
        }
        if (getBusiness_role_relation_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusiness_role_relation_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusiness_role_relation_list(), i);
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
        new org.apache.axis.description.TypeDesc(CheckBusinessRoleRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "CheckBusinessRoleRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_name"));
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
        elemField.setFieldName("auth_cm_com_session_key");
        elemField.setXmlName(new javax.xml.namespace.QName("", "auth_cm_com_session_key"));
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
        elemField.setFieldName("user_ip");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_ip"));
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
        elemField.setFieldName("business_role_relation_list");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_role_relation_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "BusinessRoleRelation"));
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
