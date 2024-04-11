package co.com.barona.microservice.resolveEnigmaApi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
@ApiModel(description = "JsonApiBodyResponseSuccess")
public class JsonApiBodyResponseSuccess {
    @JsonProperty("data")
    @Valid
    private List<GetEnigmaStepResponse> data = new ArrayList<>();

    public JsonApiBodyResponseSuccess data(List<GetEnigmaStepResponse> data) {
        this.data = data;
        return this;
    }

    public JsonApiBodyResponseSuccess addDataItem(GetEnigmaStepResponse response) {
        this.data.add(response);
        return this;
    }

    @ApiModelProperty(required = true, value = "")
    @NotNull
    @Valid
    public List<GetEnigmaStepResponse> getData() {
        return data;
    }

    public void setData(List<GetEnigmaStepResponse> data) {
        this.data = data;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JsonApiBodyResponseSuccess jsonApiBodyResponseSuccess = (JsonApiBodyResponseSuccess) o;
        return Objects.equals(this.data, jsonApiBodyResponseSuccess.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JsonApiBodyResponseSuccess {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
