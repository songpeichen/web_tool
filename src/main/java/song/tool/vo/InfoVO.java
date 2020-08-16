package song.tool.vo;

import lombok.Data;
import song.tool.pojo.Info;

@Data
public class InfoVO extends Info {
    Integer pageNum;
    Integer pageSize;
    Long total;
}
