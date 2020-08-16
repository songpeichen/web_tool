package song.tool.util;

import lombok.Data;

import java.util.List;

@Data
public class PageUtil<T> {
    List<T> rows;
    Integer pageNum;
    Integer pageSize;
    Long total;

    public PageUtil(List list, int pageNum, int pageSize, long total) {
        this.rows = list;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }
}
