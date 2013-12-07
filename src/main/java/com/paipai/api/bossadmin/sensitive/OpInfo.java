/**
 * OpInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class OpInfo  implements java.io.Serializable {
    private java.lang.Integer operation_id;

    private java.lang.String operation_name;

    public OpInfo() {
    }

    public OpInfo(
           java.lang.Integer operation_id,
           java.lang.String operation_name) {
           this.operation_id = operation_id;
           this.operation_name = operation_name;
    }


    /**
     * Gets the operation_id value for this OpInfo.
     * 
     * @return operation_id
     */
    public java.lang.Integer getOperation_id() {
        return operation_id;
    }


    /**
     * Sets the operation_id value for this OpInfo.
     * 
     * @param operation_id
     */
    public void setOperation_id(java.lang.Integer operation_id) {
        this.operation_id = operation_id;
    }


    /**
     * Gets the operation_name value for this OpInfo.
     * 
     * @return operation_name
     */
    public java.lang.String getOperation_name() {
        return operation_name;
    }


    /**
     * Sets the operation_name value for this OpInfo.
     * 
     * @param operation_name
     */
    public void setOperation_name(java.lang.String operation_name) {
        this.operation_name = operation_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OpInfo)) return false;
        OpInfo other = (OpInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operation_id==null && other.getOperation_id()==null) || 
             (this.operation_id!=null &&
              this.operation_id.equals(other.getOperation_id()))) &&
            ((this.operation_name==null && other.getOperation_name()==null) || 
             (this.operation_name!=null &&
              this.operation_name.equals(other.getOperation_name())));
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
        if (getOperation_id() != null) {
            _hashCode += getOperation_id().hashCode();
        }
        if (getOperation_name() != null) {
            _hashCode += getOperation_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OpInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "OpInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operation_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
