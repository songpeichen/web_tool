package song.tool.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "info")
@Data
public class Info extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "summary")
    private String summary;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "need_callback")
    private String needCallback;

    @Column(name = "callback_date")
    //备用yyyy-MM-dd HH:mm:ss
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date callbackDate;

    @Column(name = "sex")
    private String sex;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "create_user_code")
    private String createUserCode;

    @Column(name = "create_date")
    //备用yyyy-MM-dd HH:mm:ss
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;

}
