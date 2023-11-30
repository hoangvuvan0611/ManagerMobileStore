package com.example.managermobilestore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseListItemResponse<T> extends BaseResponse{
    private DataList<T> dataList;

    @Data
    public static class DataList<T>{
        private Long total;
        private List<T> items;
    }

    public void setResult(Long total, List<T> items){
        dataList = new DataList<>();
        dataList.setTotal(total);
        dataList.setItems(items);
    }
}
