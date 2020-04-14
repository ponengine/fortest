package com.test.company.domain;

import java.util.List;
import lombok.ToString;

@ToString
public class BaseResponse<T> {

    private String errorCode;
    private String errorMessage;
    private List<String> errorMessages;
    private T data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrorMessages() {
      return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
      this.errorMessages = errorMessages;
    }

}
