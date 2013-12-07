/**
 * BusinessRole.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.paipai.api.bossadmin.sensitive;

public class BusinessRole  implements java.io.Serializable {
    private java.lang.String user_name;

    private java.lang.Integer business_id;

    private java.lang.String business_name;

    private java.lang.Integer role_id;

    private java.lang.String role_name;

    public BusinessRole() {
    }

    public BusinessRole(
           java.lang.String user_name,
           java.lang.Integer business_id,
           java.lang.String business_name,
           java.lang.Integer role_id,
           java.lang.String role_name) {
           this.user_name = user_name;
           this.business_id = business_id;
           this.business_name = business_name;
           this.role_id = role_id;
           this.role_name = role_name;
    }


    /**
     * Gets the user_name value for this BusinessRole.
     * 
     * @return user_name
     */
    public java.lang.String getUser_name() {
        return user_name;
    }


    /**
     * Sets the user_name value for this BusinessRole.
     * 
     * @param user_name
     */
    public void setUser_name(java.lang.String user_name) {
        this.user_name = user_name;
    }


    /**
     * Gets the business_id value for this BusinessRole.
     * 
     * @return business_id
     */
    public java.lang.Integer getBusiness_id() {
        return business_id;
    }


    /**
     * Sets the business_id value for this BusinessRole.
     * 
     * @param business_id
     */
    public void setBusiness_id(java.lang.Integer business_id) {
        this.business_id = business_id;
    }


    /**
     * Gets the business_name value for this BusinessRole.
     * 
     * @return business_name
     */
    public java.lang.String getBusiness_name() {
        return business_name;
    }


    /**
     * Sets the business_name value for this BusinessRole.
     * 
     * @param business_name
     */
    public void setBusiness_name(java.lang.String business_name) {
        this.business_name = business_name;
    }


    /**
     * Gets the role_id value for this BusinessRole.
     * 
     * @return role_id
     */
    public java.lang.Integer getRole_id() {
        return role_id;
    }


    /**
     * Sets the role_id value for this BusinessRole.
     * 
     * @param role_id
     */
    public void setRole_id(java.lang.Integer role_id) {
        this.role_id = role_id;
    }


    /**
     * Gets the role_name value for this BusinessRole.
     * 
     * @return role_name
     */
    public java.lang.String getRole_name() {
        return role_name;
    }


    /**
     * Sets the role_name value for this BusinessRole.
     * 
     * @param role_name
     */
    public void setRole_name(java.lang.String role_name) {
        this.role_name = role_name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BusinessRole)) return false;
        BusinessRole other = (BusinessRole) obj;
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
            ((this.business_id==null && other.getBusiness_id()==null) || 
             (this.business_id!=null &&
              this.business_id.equals(other.getBusiness_id()))) &&
            ((this.business_name==null && other.getBusiness_name()==null) || 
             (this.business_name!=null &&
              this.business_name.equals(other.getBusiness_name()))) &&
            ((this.role_id==null && other.getRole_id()==null) || 
             (this.role_id!=null &&
              this.role_id.equals(other.getRole_id()))) &&
            ((this.role_name==null && other.getRole_name()==null) || 
             (this.role_name!=null &&
              this.role_name.equals(other.getRole_name())));
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
        if (getBusiness_id() != null) {
            _hashCode += getBusiness_id().hashCode();
        }
        if (getBusiness_name() != null) {
            _hashCode += getBusiness_name().hashCode();
        }
        if (getRole_id() != null) {
            _hashCode += getRole_id().hashCode();
        }
        if (getRole_name() != null) {
            _hashCode += getRole_name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BusinessRole.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://auth.cm.com/auth/", "BusinessRole"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("business_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("business_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "business_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role_name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role_name"));
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
