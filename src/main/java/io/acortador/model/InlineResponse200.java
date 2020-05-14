package io.acortador.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-06T17:21:42.001Z")

public class InlineResponse200   {
  @JsonProperty("longUrl")
  private String longUrl = null;

  public InlineResponse200 longUrl(String longUrl) {
    this.longUrl = longUrl;
    return this;
  }

  /**
   * Get longUrl
   * @return longUrl
  **/
  @ApiModelProperty(example = "mercadolibre.com.ar/watch?dlm123elsws", value = "")


  public String getLongUrl() {
    return longUrl;
  }

  public void setLongUrl(String longUrl) {
    this.longUrl = longUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.longUrl, inlineResponse200.longUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(longUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    longUrl: ").append(toIndentedString(longUrl)).append("\n");
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

