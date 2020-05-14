package io.acortador.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * InlineResponse201
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-06T17:21:42.001Z")

public class InlineResponse201   {


  @JsonProperty("shortUrl")
  private String shortUrl = null;

  public InlineResponse201 shortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
    return this;
  }

  /**
   * Get shortUrl
   * @return shortUrl
  **/
  @ApiModelProperty(example = "me.li/123456", value = "")


  public String getShortUrl() {
    return    shortUrl;
  }

  public void setShortUrl(String shortUrl) {
    this.shortUrl = shortUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse201 inlineResponse201 = (InlineResponse201) o;
    return Objects.equals(this.shortUrl, inlineResponse201.shortUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(shortUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse201 {\n");
    
    sb.append("    shortUrl: ").append(toIndentedString(shortUrl)).append("\n");
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

