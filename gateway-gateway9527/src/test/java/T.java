import java.time.ZonedDateTime;

/**
 * @author Crossing
 * @Date 2020-07-17
 */
public class T {

  public static void main(String[] args) {
    ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
    System.out.println(zbj);

    //2020-07-17T14:50:03.210+08:00[Asia/Shanghai]

  }

}
