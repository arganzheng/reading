/**
 * RoleResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class RoleResult  implements java.io.Serializable {
    private com.paipai.api.bossadmin.sensitive.BusinessRole[] business_role_list;

    private int status;

    private java.lang.String status_info;

    public RoleResult() {
    }

    public RoleResult(
           com.paipai.api.bossadmin.sensitive.BusinessRole[] business_role_list,
           int status,
           java.lang.String status_info) {
           this.business_role_list = business_role_list;
           this.status = status;
           this.status_info = status_info;
    }


    /**
     * Gets the business_role_list value for this RoleResult.
     * 
     * @return business_role_list
     */
    public com.paipai.api.bossadmin.sensitive.BusinessRole[] getBusiness_role_list() {
        return business_role_list;
    }


    /**
     * Sets the business_role_list value for this RoleResult.
     * 
     * @param business_role_list
     */
    public void setBusiness_role_list(com.paipai.api.bossadmin.sensitive.BusinessRole[] business_role_list) {
        this.business_role_list = business_role_list;
    }

    public com.paipai.api.bossadmin.sensitive.BusinessRole getBusiness_role_list(int i) {
        return this.business_role_list[i];
    }

    public void setBusiness_role_list(int i, com.paipai.api.bossadmin.sensitive.BusinessRole _value) {
        this.business_role_list[i] = _value;
    }


    /**
     * Gets the status value for this RoleResult.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this RoleResult.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the status_info value for this RoleResult.
     * 
     * @return status_info
     */
    public java.lang.String getStatus_info() {
        return status_info;
    }


    /**
     * Sets the status_info value for this RoleResult.
     * 
     * @param status_info
     */
    public void setStatus_info(java.lang.String status_info) {
        this.status_info = status_info;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RoleResult)) return false;
        RoleResult other = (RoleResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.business_role_list==null && other.getBusiness_role_list()==null) || 
             (this.business_role_list!=null &&
              java.util.Arrays.equals(this.business_role_list, other.getBusiness_role_list()))) &&
            this.status == other.getStatus() &&
            ((this.status_info==null && other.getStatus_info()==null) || 
             (this.status_info!=null &&
              this.status_info.equals(other.getStatus_info())));
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
        if (getBusiness_role_list() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getBusiness_role_list());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getBusiness_role_list(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getStatus();
        if (getStatus_info() != null) {
            _hashCode += getStatus_info().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RoleResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "RoleResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("business_role_list");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_role_list"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "BusinessRole"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status_info");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status_info"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
