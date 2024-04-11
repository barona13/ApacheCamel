package co.com.barona.microservice.resolveEnigmaApi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;


@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-03-12T18:29:07.377-05:00[America/Bogota]")
public class GetEnigmaStepResponse {
    @JsonProperty("header")
    private Header header = null;
    

    @JsonProperty("answer")
    private String answer = null;

    public GetEnigmaStepResponse header(Header header) {
        this.header = header;
        return this;
    }

    
    @ApiModelProperty(required = true, value = "")
    @Valid
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public GetEnigmaStepResponse answer(String answer) {
        this.answer = answer;
        return this;
    }

   
    @ApiModelProperty(required = true, value = "")
    @NotNull
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public void setId(String id) {
        if (this.header == null) {
            this.header = new Header();
        }
        this.header.setId(id);
    }
    
    public void setType(String type) {
        if (this.header == null) {
            this.header = new Header();
        }
        this.header.setType(type);
    }
    
    public void setSolution(String solution) {
        this.answer = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetEnigmaStepResponse that = (GetEnigmaStepResponse) o;
        return Objects.equals(header, that.header) &&
                Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, answer);
    }

    @Override
    public String toString() {
        return "GetEnigmaStepResponse{" +
                "header=" + header +
                ", answer='" + answer + '\'' +
                '}';
    }

}
