package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AddressLibrary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-09-07T09:32:08.696Z")

public class AddressLibrary   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("province")
  private String province = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("county")
  private String county = null;

  @JsonProperty("specificAddress")
  private String specificAddress = null;

  @JsonProperty("consignee")
  private String consignee = null;

  @JsonProperty("contactInformation")
  private String contactInformation = null;

  @JsonProperty("userId")
  private String userId = null;

  public AddressLibrary id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public AddressLibrary country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AddressLibrary province(String province) {
    this.province = province;
    return this;
  }

   /**
   * Get province
   * @return province
  **/
  @ApiModelProperty(value = "")


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public AddressLibrary city(String city) {
    this.city = city;
    return this;
  }

   /**
   * Get city
   * @return city
  **/
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddressLibrary county(String county) {
    this.county = county;
    return this;
  }

   /**
   * Get county
   * @return county
  **/
  @ApiModelProperty(value = "")


  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public AddressLibrary specificAddress(String specificAddress) {
    this.specificAddress = specificAddress;
    return this;
  }

   /**
   * Get specificAddress
   * @return specificAddress
  **/
  @ApiModelProperty(value = "")


  public String getSpecificAddress() {
    return specificAddress;
  }

  public void setSpecificAddress(String specificAddress) {
    this.specificAddress = specificAddress;
  }

  public AddressLibrary consignee(String consignee) {
    this.consignee = consignee;
    return this;
  }

   /**
   * Get consignee
   * @return consignee
  **/
  @ApiModelProperty(value = "")


  public String getConsignee() {
    return consignee;
  }

  public void setConsignee(String consignee) {
    this.consignee = consignee;
  }

  public AddressLibrary contactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
    return this;
  }

   /**
   * Get contactInformation
   * @return contactInformation
  **/
  @ApiModelProperty(value = "")


  public String getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(String contactInformation) {
    this.contactInformation = contactInformation;
  }

  public AddressLibrary userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressLibrary addressLibrary = (AddressLibrary) o;
    return Objects.equals(this.id, addressLibrary.id) &&
        Objects.equals(this.country, addressLibrary.country) &&
        Objects.equals(this.province, addressLibrary.province) &&
        Objects.equals(this.city, addressLibrary.city) &&
        Objects.equals(this.county, addressLibrary.county) &&
        Objects.equals(this.specificAddress, addressLibrary.specificAddress) &&
        Objects.equals(this.consignee, addressLibrary.consignee) &&
        Objects.equals(this.contactInformation, addressLibrary.contactInformation) &&
        Objects.equals(this.userId, addressLibrary.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, country, province, city, county, specificAddress, consignee, contactInformation, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressLibrary {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    province: ").append(toIndentedString(province)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    specificAddress: ").append(toIndentedString(specificAddress)).append("\n");
    sb.append("    consignee: ").append(toIndentedString(consignee)).append("\n");
    sb.append("    contactInformation: ").append(toIndentedString(contactInformation)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

