/**
 * CheckBusinessRoleResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class CheckBusinessRoleResult  implements java.io.Serializable {
    private java.lang.Integer status_code;

    private java.lang.String status_info;

    private java.lang.String login_url;

    private boolean[] check_result_list;

    public CheckBusinessRoleResult() {
    }

    public CheckBusinessRoleResult(
           java.lang.Integer status_code,
           java.lang.String status_info,
           java.lang.String login_url,
           boolean[] check_result_list) {
           this.status_code = status_code;
           this.status_info = status_info;
           this.login_url = login_url;
           this.check_result_list = check_result_list;
    }


    /**
     * Gets the status_code value for this CheckBusinessRoleResult.
     * 
     * @return status_code
     */
    public java.lang.Integer getStatus_code() {
        return status_code;
    }


    /**
     * Sets the status_code value for this CheckBusinessRoleResult.
     * 
     * @param status_code
     */
    public void setStatus_code(java.lang.Integer status_code) {
        this.status_code = status_code;
    }


    /**
     * Gets the status_info value for this CheckBusinessRoleResult.
     * 
     * @return status_info
     */
    public java.lang.String getStatus_info() {
        return status_info;
    }


    /**
     * Sets the status_info value for this CheckBusinessRoleResult.
     * 
     * @param status_info
     */
    public void setStatus_info(java.lang.String status_info) {
        this.status_info = status_info;
    }


    /**
     * Gets the login_url value for this CheckBusinessRoleResult.
     * 
     * @return login_url
     */
    public java.lang.String getLogin_url() {
        return login_url;
    }


    /**
     * Sets the login_url value for this CheckBusinessRoleResult.
     * 
     * @param login_url
     */
    public void setLogin_url(java.lang.String login_url) {
        this.login_url = login_url;
    }


    /**
     * Gets the check_result_list value for this CheckBusinessRoleResult.
     * 
     * @return check_result_list
     */
    public boolean[] getCheck_result_list() {
        return check_result_list;
    }


    /**
     * Sets the check_result_list value for this CheckBusinessRoleResult.
     * 
     * @param check_result_list
     */
    public void setCheck_result_list(boolean[] check_result_list) {
        this.check_result_list = check_result_list;
    }

    public boolean getCheck_result_list(int i) {
        return this.check_result_list[i];
    }

    public void setCheck_result_list(int i, boolean _value) {
        this.check_result_list[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckBusinessRoleResult)) return false;
        CheckBusinessRoleResult other = (CheckBusinessRoleResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.status_code==null && other.getStatus_code()==null) || 
             (this.status_code!=null &&
              this.status_code.equals(other.getStatus_code()))) &&
            ((this.status_info==null && other.getStatus_info()==null) || 
             (this.status_info!=null &&
              this.status_info.equals(other.getStatus_info()))) &&
            ((this.login_url==null && other.getLogin_url()==null) || 
             (this.login_url!=null &&
              this.login_url.equals(other.getLogin_url()))) &&
            ((this.check_result_list==null && other.getCheck_result_list()==null) || 
             (this.check_result_list!=null &&
              java.util.Arrays.equals(this.check_result_list, other.getCheck_result_list())));
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
        if (getStatus_code() != null) {
            _hashCode += getStatus_code().hashCode();
        }
        if (getStatus_info() != null) {
            _hashCode += getStatus_info().hashCode();
        }
        if (getLogin_url() != null) {
            _hashCode += getLogin_url().hashCode();
        }
        if (getCheck_result_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCheck_result_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCheck_result_list(), i);
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
        new org.apache.axis.description.TypeDesc(CheckBusinessRoleResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "CheckBusinessRoleResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status_code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status_code"));
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
        elemField.setFieldName("login_url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "login_url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("check_result_list");
        elemField.setXmlName(new javax.xml.namespace.QName("", "check_result_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
