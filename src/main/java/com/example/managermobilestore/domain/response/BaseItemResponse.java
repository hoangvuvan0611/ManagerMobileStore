package com.example.managermobilestore.domain.response;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseItemResponse<T> extends BaseResponse {

    private DataItem<T> dataItem;

    @Data
    public static class DataItem<T>{
        private T item;
    }

    public void setData(T data){
        dataItem = new DataItem<>();
        dataItem.setItem(data);
    }
}
