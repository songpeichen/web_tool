package song.tool.vo;

import lombok.Data;

@Data
public class ResponseVO {
    boolean success = false;
    String code = "0";
    String msg = "";
    Object data ;
    public static ResponseVO instance(boolean success, Object data){
        return new ResponseVO(success,data);
    }

    private ResponseVO(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
}
