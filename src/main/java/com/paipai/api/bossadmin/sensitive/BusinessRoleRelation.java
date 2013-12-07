/**
 * BusinessRoleRelation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class BusinessRoleRelation  implements java.io.Serializable {
    private java.lang.Integer business_id;

    private java.lang.String role_command;

    public BusinessRoleRelation() {
    }

    public BusinessRoleRelation(
           java.lang.Integer business_id,
           java.lang.String role_command) {
           this.business_id = business_id;
           this.role_command = role_command;
    }


    /**
     * Gets the business_id value for this BusinessRoleRelation.
     * 
     * @return business_id
     */
    public java.lang.Integer getBusiness_id() {
        return business_id;
    }


    /**
     * Sets the business_id value for this BusinessRoleRelation.
     * 
     * @param business_id
     */
    public void setBusiness_id(java.lang.Integer business_id) {
        this.business_id = business_id;
    }


    /**
     * Gets the role_command value for this BusinessRoleRelation.
     * 
     * @return role_command
     */
    public java.lang.String getRole_command() {
        return role_command;
    }


    /**
     * Sets the role_command value for this BusinessRoleRelation.
     * 
     * @param role_command
     */
    public void setRole_command(java.lang.String role_command) {
        this.role_command = role_command;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessRoleRelation)) return false;
        BusinessRoleRelation other = (BusinessRoleRelation) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.business_id==null && other.getBusiness_id()==null) || 
             (this.business_id!=null &&
              this.business_id.equals(other.getBusiness_id()))) &&
            ((this.role_command==null && other.getRole_command()==null) || 
             (this.role_command!=null &&
              this.role_command.equals(other.getRole_command())));
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
        if (getBusiness_id() != null) {
            _hashCode += getBusiness_id().hashCode();
        }
        if (getRole_command() != null) {
            _hashCode += getRole_command().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessRoleRelation.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "BusinessRoleRelation"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("business_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_command");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role_command"));
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
